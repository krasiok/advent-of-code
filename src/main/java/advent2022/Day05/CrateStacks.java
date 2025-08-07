package advent_2022.AoC5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CrateStacks {
    List<Stack<String>> crateColumns = new ArrayList<>();

    public CrateStacks() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader("src/advent_2022/AoC5/stackToParse.txt"))) {
            String line;
            while ((line = input.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Could not read the input file");
            e.printStackTrace();
        }

        for (int i = 0; i < 9; i++) {
            crateColumns.add(new Stack<>());
        }
        for (int lineIndex = lines.size() - 1; lineIndex >= 0; lineIndex--) {
            String backwardLine = lines.get(lineIndex);
            for (int i = 0; i < 9; i++) {
                int startIndex = i * 4;
                if (startIndex + 3 <= backwardLine.length()) {
                    String chunk = backwardLine.substring(startIndex, startIndex + 3);
                    chunk = chunk.trim();
                    if (chunk.startsWith("[") && chunk.endsWith("]")) {
                        String letter = chunk.substring(1, 2);
                        crateColumns.get(i).push(letter);
                    }
                }

            }
        }
        for(int i=0; i<9; i++){
            System.out.println(crateColumns.get(i));
        }

    }
}
