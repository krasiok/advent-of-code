package advent_2022.AoC5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandList {
    private final List<Command> commands = new ArrayList<>();

    public void addCommand(int count, int from, int to) {
        commands.add(new Command(count, from, to));
    }

    public List<Command> getAll() {
        return Collections.unmodifiableList(commands);
    }

    public int size() {
        return commands.size();
    }
}
