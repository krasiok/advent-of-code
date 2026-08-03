package advent_2022.AoC16;

public class DistanceBox {
    private Valve valve;
    private int distance;

    public DistanceBox(Valve valve, int distance) {
        this.valve = valve;
        this.distance = distance;
    }

    public Valve getValve() {
        return valve;
    }

    public int getDistance() {
        return distance;
    }
}
