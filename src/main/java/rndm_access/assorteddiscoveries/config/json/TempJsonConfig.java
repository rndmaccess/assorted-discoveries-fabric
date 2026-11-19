package rndm_access.assorteddiscoveries.config.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempJsonConfig implements AutoCloseable {
    private final Path file;

    public TempJsonConfig(Path configPath) throws IOException {
        file = Files.createTempFile(configPath.getFileName().toString(), null);
    }

    public Path getFile() {
        return file;
    }

    @Override
    public void close() throws IOException {
        Files.deleteIfExists(file);
    }
}
