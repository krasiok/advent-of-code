package advent_2022.AoC8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public List<String> attachFile(String fullPath){
        try(BufferedReader br = new BufferedReader(new FileReader(fullPath))){
            String line;
            List<String> lines = new ArrayList<>();
            while((line=br.readLine()) != null){
                lines.add(line);
            }
            return lines;
        }
        catch (IOException e){
            System.err.println("Could not read input file");
            return null;
        }
    }
}
