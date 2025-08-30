package advent_2022.AoC3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileConverter {
    public List<String> inputLinesToList(){
        List<String> lines = new ArrayList<>();
        String fullPath = "src/advent_2022/AoC3/input.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(fullPath))){
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }
        }
        catch (IOException e){
            System.err.println("Could not read the file");
        }
        return lines;
    }
}
