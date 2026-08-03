package advent_2022.AoC12;

public class Node {
    private final int x;
    private final int y;
    private final int steps;

    public Node(int x, int y, int steps){
        this.x = x;
        this.y = y;
        this.steps = steps;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getSteps() { return steps; }
}
