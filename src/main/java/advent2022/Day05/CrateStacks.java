package advent_2022.AoC5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CrateStacks {
    private final List<Stack<String>> stacks = new ArrayList<>();
    private final int stackCount = 9;

    public CrateStacks() {
        this("src/advent_2022/AoC5/stackToParse.txt");
    }

    public CrateStacks(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = input.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read the input file: " + filePath, e);
        }

        for (int i = 0; i < stackCount; i++) {
            stacks.add(new Stack<>());
        }
        for (int lineIndex = lines.size() - 1; lineIndex >= 0; lineIndex--) {
            String row = lines.get(lineIndex);
            for (int i = 0; i < stackCount; i++) {
                int startIndex = i * 4;
                if (startIndex + 3 <= row.length()) {
                    String chunk = row.substring(startIndex, startIndex + 3).trim();
                    if (chunk.startsWith("[") && chunk.endsWith("]")) {
                        String crate = chunk.substring(1, 2);
                        stacks.get(i).push(crate);
                    }
                }
            }
        }
    }

    public List<Stack<String>> getStacks() {
        return stacks;
    }

    public int getStackCount() {
        return stackCount;
    }
}
