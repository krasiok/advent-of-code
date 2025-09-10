package advent_2022.AoC14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {
    private int[][] grid;

    public List<List<Position>> fileInputToList() {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        List<List<Position>> rockPositions = new ArrayList<>();
        String regex = "(\\d+),(\\d+)";
        String filePath = "src/advent_2022/AoC14/input.txt";
        Pattern pattern = Pattern.compile(regex);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<Position> singleLine = new ArrayList<>();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));
                    singleLine.add(new Position(x, y));
                    if (x > maxX) {
                        maxX = x;
                    }
                    if (y > maxY) {
                        maxY = y;
                    }
                }
                rockPositions.add(singleLine);
            }

            // Part 2: dodaj 2 wiersze dla podłogi i rozszerz szerokość
            int floorY = maxY + 2;
            int width = Math.max(maxX + 1, 500 + floorY + 100); // szerokość musi być wystarczająca
            grid = new int[floorY + 1][width];

            // Wypełnij podłogę
            for (int x = 0; x < width; x++) {
                grid[floorY][x] = 1;
            }

        } catch (IOException e) {
            System.err.println("Could not read the file");
        }
        return rockPositions;
    }

    public int[][] getGrid() {
        return grid;
    }
}