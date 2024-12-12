package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.parser.entries.AbstractConfigEntry;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class JsonEntrySaver {
    private final Path configPath;

    public JsonEntrySaver(Path configPath) {
        this.configPath = configPath;
    }

    public void save(Map<AbstractConfigEntry<?>, Object> entryList) {
        List<String> newContent = new ArrayList<>();

        this.saveEntries(newContent, entryList);

        // To prevent partial files we first save it to a temporary file, then replace the config file!
        try {
            Path tempFile = Files.createTempFile(configPath.getFileName().toString(), null);
            Files.write(tempFile, newContent);
            Files.move(tempFile, configPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save the file!", e);
        }
    }

    private void saveEntries(List<String> fileContent, Map<AbstractConfigEntry<?>, Object> entryList) {
        try (BufferedReader reader = Files.newBufferedReader(configPath)) {
            String lineContent;
            int lineNum = 0;
            this.removeMissingEntries(entryList);
            while ((lineContent = reader.readLine()) != null) {
                String line = this.getLine(entryList, lineContent, lineNum);
                fileContent.add(line);
                lineNum++;
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the file!", e);
        }
    }

    private void removeMissingEntries(Map<AbstractConfigEntry<?>, Object> entryList) {
        List<AbstractConfigEntry<?>> entries = new ArrayList<>(entryList.keySet());

        for (AbstractConfigEntry<?> entry : entries) {
            String entryName = entry.getName();
            int entryLine = entry.getLine();

            if (entryLine == -1) {
                AssortedDiscoveries.LOGGER.error("Failed to save the entry {} because it is missing in the config!",
                        entryName);
                entryList.remove(entry);
            }
        }
    }

    private String getLine(Map<AbstractConfigEntry<?>, Object> entryList, String lineContent, int lineNum) {
        for (AbstractConfigEntry<?> entry : entryList.keySet()) {
            Object value = entryList.get(entry);
            String entryName = entry.getName();
            int entryLine = entry.getLine();

            if (lineNum == entryLine) {
                return this.getUpdatedLine(lineContent, entryName, value, entry);
            }
        }
        return lineContent;
    }

    private String getUpdatedLine(String lineContent, String entryName, Object value, AbstractConfigEntry<?> entry) {
        if (!Objects.equals(entry.getValue(), value)) {
            int start = entry.getStart();
            int end = entry.getEnd();
            String startStr = lineContent.substring(0, start);
            String endStr = lineContent.substring(end);
            String valueStr = value.toString();

            return startStr + "\"" + entryName + "\": " + valueStr + endStr;
        }
        return lineContent;
    }
}
