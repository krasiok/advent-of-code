package advent_2022.AoC2;

public enum ResultPoints {
    LOSE(0),
    DRAW(3),
    WIN(6);

    private final int points;

    ResultPoints(int points){
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
