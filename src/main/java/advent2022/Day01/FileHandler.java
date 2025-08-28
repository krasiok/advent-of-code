package advent_2022.AoC1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public List<String> getConvertedListFromFile() {
        String fullPath = "src/advent_2022/AoC1/input.txt";
        List<String> calories = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
            String line;
            while((line = br.readLine()) != null){
                calories.add(line);
            }
        } catch (IOException e) {
            System.err.println("Could not read the file");
        }
        return calories;
    }
}
