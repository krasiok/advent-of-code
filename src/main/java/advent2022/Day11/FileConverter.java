package advent_2022.AoC11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileConverter {
    private List<Integer> parseIntegerList(String text) {
        List<Integer> result = new ArrayList<>();
        String[] parts = text.split(",");
        for (String part : parts) {
            result.add(Integer.parseInt(part.trim()));
        }
        return result;
    }

    public List<Monkey> inputToList() {
        List<Monkey> monkeys = new ArrayList<>();
        String regex = "Monkey (\\d+):\\s+Starting items: ([\\d, ]+)\\s+Operation: new = old ([*+]) (\\w+)\\s+Test: divisible by (\\d+)\\s+If true: throw to monkey (\\d+)\\s+If false: throw to monkey (\\d+)";
        Pattern pattern = Pattern.compile(regex);
        String fullPath = "src/advent_2022/AoC11/input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }

            Matcher matcher = pattern.matcher(fileContent.toString());
            while (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String itemsText = matcher.group(2);
                char opType = matcher.group(3).charAt(0);
                String opValStr = matcher.group(4);
                int opVal = opValStr.equals("old") ? -1 : Integer.parseInt(opValStr);
                int testValue = Integer.parseInt(matcher.group(5));
                int ifTrue = Integer.parseInt(matcher.group(6));
                int ifFalse = Integer.parseInt(matcher.group(7));
                List<Integer> items = parseIntegerList(itemsText);
                Monkey monkey = new Monkey(id, items, opType, opVal, testValue, ifTrue, ifFalse);
                monkeys.add(monkey);
            }
        } catch (IOException e) {
            System.err.println("Could not read the file");
        }
        return monkeys;
    }
}