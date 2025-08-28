import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {
    private final DirectionMap dm = new DirectionMap();
    private final Map<Character, int[]> dirMap = dm.getDirMap();

    public void run() {
        FileConverter fileConverter = new FileConverter();

        try {
            List<Move> moves = fileConverter.getMoves();

            System.out.println("Part 1: " + solvePart1(moves));
            System.out.println("Part 2: " + solvePart2(moves));

        } catch (FileParsingException e) {
            System.err.println("Error processing input file: " + e.getMessage());
            System.exit(1);
        }
    }

    private void moveFollower(Position leader, Position follower) {
        int dx = leader.getX() - follower.getX();
        int dy = leader.getY() - follower.getY();

        if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
            follower.setX(follower.getX() + ((dx != 0) ? Integer.signum(dx) : 0));
            follower.setY(follower.getY() + ((dy != 0) ? Integer.signum(dy) : 0));
        }
    }

    private int solvePart1(List<Move> moves) {
        Position head = new Position(0, 0);
        Position tail = new Position(0, 0);

        HashSet<Position> visitedPositions = new HashSet<>();
        visitedPositions.add(new Position(0, 0));

        for (Move m : moves) {
            int[] move = dirMap.get(m.direction);

            for (int i = 0; i < m.steps; i++) {
                head.setX(head.getX() + move[0]);
                head.setY(head.getY() + move[1]);

                moveFollower(head, tail);

                visitedPositions.add(new Position(tail.getX(), tail.getY()));
            }
        }
        return visitedPositions.size();
    }

    private int solvePart2(List<Move> moves) {
        final int KNOT_COUNT = 10;
        Position[] knots = new Position[KNOT_COUNT];
        for (int i = 0; i < KNOT_COUNT; i++) {
            knots[i] = new Position(0, 0);
        }

        HashSet<Position> visitedPositions = new HashSet<>();
        visitedPositions.add(new Position(0, 0));

        for (Move m : moves) {
            int[] move = dirMap.get(m.direction);

            for (int i = 0; i < m.steps; i++) {

                knots[0].setX(knots[0].getX() + move[0]);
                knots[0].setY(knots[0].getY() + move[1]);

                for (int knotIndex = 1; knotIndex < KNOT_COUNT; knotIndex++) {
                    moveFollower(knots[knotIndex - 1], knots[knotIndex]);
                }

                visitedPositions.add(new Position(knots[KNOT_COUNT - 1].getX(), knots[KNOT_COUNT - 1].getY()));
            }
        }
        return visitedPositions.size();
    }
}