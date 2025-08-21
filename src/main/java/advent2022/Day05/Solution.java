package advent_2022.AoC5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    private CommandList loadCommands(String filePath) {
        CommandList commandList = new CommandList();
        try (BufferedReader input = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] tokens = line.split("[^\\d]+");
                commandList.addCommand(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3])
                );
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read the input file: " + filePath, e);
        }
        return commandList;
    }

    public void solvePart1() {
        CommandList commands = loadCommands("src/advent_2022/AoC5/input.txt");
        CrateStacks crateStacks = new CrateStacks();

        for (Command cmd : commands.getAll()) {
            Stack<String> fromStack = crateStacks.getStacks().get(cmd.getFrom() - 1);
            Stack<String> toStack   = crateStacks.getStacks().get(cmd.getTo() - 1);

            for (int i = 0; i < cmd.getCount(); i++) {
                toStack.push(fromStack.pop());
            }
        }

        crateStacks.getStacks().forEach(stack -> System.out.print(stack.peek()));
        System.out.println();
    }

    public void solvePart2() {
        CommandList commands = loadCommands("src/advent_2022/AoC5/input.txt");
        CrateStacks crateStacks = new CrateStacks();

        for (Command cmd : commands.getAll()) {
            Stack<String> fromStack = crateStacks.getStacks().get(cmd.getFrom() - 1);
            Stack<String> toStack   = crateStacks.getStacks().get(cmd.getTo() - 1);

            List<String> buffer = new ArrayList<>();
            for (int i = 0; i < cmd.getCount(); i++) {
                buffer.add(fromStack.pop());
            }
            Collections.reverse(buffer);
            toStack.addAll(buffer);
        }

        crateStacks.getStacks().forEach(stack -> System.out.print(stack.peek()));
        System.out.println();
    }
}
