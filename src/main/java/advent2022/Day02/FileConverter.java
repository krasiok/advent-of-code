package advent_2022.AoC2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileConverter {
    public List<Move> getListFromInput() {
        List<Move> moves = new ArrayList<>();
        String regex = "(.) (.$)";
        Pattern pattern = Pattern.compile(regex);
        try (BufferedReader br = new BufferedReader(new FileReader("src/advent_2022/AoC2/input.txt"))) {
            String line;
            while((line = br.readLine())!= null){
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    char opponentMove = matcher.group(1).charAt(0);
                    char myMove = matcher.group(2).charAt(0);
                    moves.add(new Move(opponentMove,myMove));
                }
            }
        }
        catch (IOException e){
            System.err.println("Could not read the file");
        }
        return moves;
    }
}
