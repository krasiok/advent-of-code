package advent_2022.AoC16;

public record TargetBox(int distance, int flowRate) {

    @Override
    public String toString() {
        return "distance: " + distance + ", flowRate: " + flowRate;
    }
}
