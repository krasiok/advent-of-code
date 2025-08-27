import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileConverter {
    public List<Move> getMoves() {
        List<Move> moves = new ArrayList<>();
        String regex = "([LRDU]) (\\d+)";
        Pattern pattern = Pattern.compile(regex);
        try (BufferedReader br = new BufferedReader(new FileReader("src/input.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                if (matcher.find() && matcher.matches()) {
                    char direction = matcher.group(1).charAt(0);
                    int steps = Integer.parseInt(matcher.group(2));
                    moves.add(new Move(direction,steps));
                }

            }
            return moves;
        } catch (IOException e) {
            System.err.println("Could not write the input file");
            return null;
        }
    }
}
