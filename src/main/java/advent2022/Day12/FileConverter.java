package advent_2022.AoC12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileConverter {
    public List<String> fileToGrid(){
        List<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/advent_2022/AoC12/input.txt"))){

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
