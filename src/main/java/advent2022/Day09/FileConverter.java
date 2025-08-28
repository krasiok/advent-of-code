import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileConverter {

    public List<Move> getMoves() throws FileParsingException {
        List<Move> moves = new ArrayList<>();
        String regex = "([LRDU]) (\\d+)";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader("src/input.txt"))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                Matcher matcher = pattern.matcher(line);

                if (matcher.matches()) {
                    char direction = matcher.group(1).charAt(0);
                    int steps = Integer.parseInt(matcher.group(2));
                    moves.add(new Move(direction, steps));
                } else {
                    throw new FileParsingException(
                            String.format("Invalid format at line %d: '%s'. Expected format: '[LRDU] [number]'",
                                    lineNumber, line));
                }
            }

            if (moves.isEmpty()) {
                throw new FileParsingException("No valid moves found in file");
            }

            return moves;

        } catch (IOException e) {
            throw new FileParsingException("Could not read the input file: " + e.getMessage(), e);
        } catch (NumberFormatException e) {
            throw new FileParsingException("Invalid number format in input file: " + e.getMessage(), e);
        }
    }
}