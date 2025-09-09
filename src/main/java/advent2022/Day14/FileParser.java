package advent_2022.AoC14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

    public List<List<Position>> fileInputToList() {
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
                }
                rockPositions.add(singleLine);
            }
        } catch (IOException e) {
            System.err.println("Could not read the file");
        }
        return rockPositions;
    }
}
