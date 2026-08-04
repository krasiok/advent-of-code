package advent_2022.AoC16;

public class TargetBox {
    private int distance;
    private int flowRate;

    public TargetBox(int distance, int flowRate) {
        this.distance = distance;
        this.flowRate = flowRate;
    }

    public int getDistance() {
        return distance;
    }

    public int getFlowRate() {
        return flowRate;
    }

    @Override
    public String toString() {
        return "distance: " + distance + ", flowRate: " + flowRate;
    }
}
