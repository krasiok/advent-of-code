package advent_2022.AoC10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileConverter {
    public List<Command> getListFromInput() {
        List<Command> commands = new ArrayList<>();
        String regex = "^(\\w+)\\s*(-?\\d+)?$";
        Pattern pattern = Pattern.compile(regex);
        try (BufferedReader br = new BufferedReader(new FileReader("src/advent_2022/AoC10/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String name = matcher.group(1);
                    if (matcher.group(2)!=null) {
                        int signalStrength = Integer.parseInt(matcher.group(2));
                        commands.add(new Command(name, signalStrength));
                    } else {
                        commands.add(new Command(name));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Could not write the file");
        }
        return commands;
    }
}
