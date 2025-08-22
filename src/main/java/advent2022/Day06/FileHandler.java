package advent_2022.AoC6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    public static String getContent(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + path, e);
        }
    }
}
