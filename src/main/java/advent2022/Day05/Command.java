package advent_2022.AoC5;

import java.util.Objects;

public final class Command {
    private final int count;
    private final int from;
    private final int to;

    public Command(int count, int from, int to) {
        this.count = count;
        this.from = from;
        this.to = to;
    }

    public int getCount() {
        return count;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Command[count=" + count + ", from=" + from + ", to=" + to + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;
        Command other = (Command) o;
        return count == other.count && from == other.from && to == other.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, from, to);
    }
}
