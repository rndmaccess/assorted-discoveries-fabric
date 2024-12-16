package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.parser.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.parser.entries.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.entries.ErrorConfigEntry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayDeque;
import java.util.List;

public class JsonEntryCorrector {
    private final JsonConfig config;
    private final Path configPath;
    private final List<String> fileContent;

    public JsonEntryCorrector(JsonConfig config, List<String> fileContent, Path configPath) {
        this.config = config;
        this.configPath = configPath;
        this.fileContent = fileContent;
    }

    public void correct(List<ErrorConfigEntry> errorList) {
        ArrayDeque<ConfigCategory> categories = new ArrayDeque<>();
        List<ConfigCategory> configCategories = config.getCategories().stream().toList();
        int configSize = configCategories.size();
        int j = 0;

        // Once this is true we have traversed and corrected the entire config file!
        while (configSize != j) {
            ConfigCategory category = configCategories.get(j);

            categories.push(category);
            this.correctEntries(errorList, category);
            this.correctSubcategories(category, categories, errorList);
            j++;
        }

        try {
            // To prevent partial files we first save it to a temporary file, then replace the config file!
            Path tempFile = Files.createTempFile(configPath.getFileName().toString(), null);
            Files.write(tempFile, fileContent);
            Files.move(tempFile, configPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Could not correct the config!", e);
        }
    }

    private void correctSubcategories(ConfigCategory category, ArrayDeque<ConfigCategory> categories,
                                      List<ErrorConfigEntry> errorList) {
        int i = 0;

        while (category.hasSubCategories() && !categories.isEmpty()) {
            List<ConfigCategory> subCategories = categories.peek().getSubcategories();

            assert categories.peek() != null;
            if (categories.peek().hasSubCategories()) {
                ConfigCategory subcategory = subCategories.get(i);

                categories.push(subcategory);
                this.correctEntries(errorList, subcategory);
            } else {
                categories.pop(); // This category has no sub-categories
                                  // so we can pop it off safely!
                i = popCategories(categories, i);
            }
        }
    }

    private int popCategories(ArrayDeque<ConfigCategory> categories, int i) {
        assert categories.peek() != null;
        List<ConfigCategory> subCategories = categories.peek().getSubcategories();
        int size = subCategories.size() - 1;

        while (!categories.isEmpty()) {
            if (size != i) {
                i++; // We increment i here to move onto the next subcategory in the list!
                return i;
            } else {
                categories.pop(); // If we are here we can safely pop off this category
                                  // because it has no untraversed subcategories!
                i = 0;

                if (!categories.isEmpty()) {
                    subCategories = categories.peek().getSubcategories();
                    size = subCategories.size() - 1;
                }
            }
        }
        return i;
    }

    private void correctEntries(List<ErrorConfigEntry> errorList, ConfigCategory category) {
        for (ErrorConfigEntry entryError : errorList) {
            String errorName = entryError.getName();
            String errorVal = String.valueOf(entryError.getValue());
            int errorLine = entryError.getLine();
            int errorStart = entryError.getStart();
            int errorEnd = entryError.getEnd();

            if (category.hasEntry(errorName)) {
                AbstractConfigEntry<?> entry = category.getEntry(errorName);
                Object defaultValue = entry.getValue();
                String line = fileContent.get(errorLine);
                String startLine = line.substring(0, errorStart);
                String endLine = line.substring(errorEnd);
                String correctedEntry = startLine + "\"" + errorName + "\"" + ": " + defaultValue;
                int newEnd = correctedEntry.length();

                fileContent.set(errorLine, correctedEntry + endLine); // Correct the entry's value!
                entry.setLine(errorLine);
                entry.setStart(errorStart);
                entry.setEnd(newEnd);

                AssortedDiscoveries.LOGGER.warn("Could not load value {} for entry \"{}\", correcting to {} at line {}.",
                        errorVal, errorName, defaultValue, errorLine);
            }
        }
    }
}
