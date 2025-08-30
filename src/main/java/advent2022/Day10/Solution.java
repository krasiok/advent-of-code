package advent_2022.AoC10;

import java.util.List;

public class Solution {
    FileConverter fileConverter = new FileConverter();

    List<Command> commands = fileConverter.getListFromInput();

    List<Integer> checkSignalStrength = List.of(20, 60, 100, 140, 180, 220);
    int cycle = 0;
    int x = 1;
    int sum = 0;

    private void cycleCondition(int times) {
        for (int i = 0; i < times; i++) {
            cycle++;
            if (checkSignalStrength.contains(cycle)) {
                sum += x * cycle;

            }
        }
    }

    public void run() {
        for (Command command : commands) {
            if (command.getName().equals("noop")) {
                cycleCondition(1);
            }

            if (command.getName().contains("addx")) {
                cycleCondition(2);
                x += command.getStrength();
            }
        }
        System.out.println(sum);
    }
}
