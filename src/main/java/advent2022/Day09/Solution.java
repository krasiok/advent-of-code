import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {
    public void run() {
        FileConverter fileConverter = new FileConverter();
        List<Move> moves = fileConverter.getMoves();


        System.out.println("Part 1: " + solvePart1(moves));


        System.out.println("Part 2: " + solvePart2(moves));
    }

    private int solvePart1(List<Move> moves) {
        int headX = 0, headY = 0;
        int tailX = 0, tailY = 0;

        HashSet<Position> visitedPositions = new HashSet<>();
        visitedPositions.add(new Position(0, 0));

        Map<Character, int[]> dirMap = createDirectionMap();

        for (Move m : moves) {
            int[] move = dirMap.get(m.direction);
            for (int i = 0; i < m.steps; i++) {

                headX += move[0];
                headY += move[1];


                int dx = headX - tailX;
                int dy = headY - tailY;
                if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
                    tailX += (dx != 0) ? Integer.signum(dx) : 0;
                    tailY += (dy != 0) ? Integer.signum(dy) : 0;
                }

                visitedPositions.add(new Position(tailX, tailY));
            }
        }

        return visitedPositions.size();
    }

    private int solvePart2(List<Move> moves) {

        Position[] knots = new Position[10];
        for (int i = 0; i < 10; i++) {
            knots[i] = new Position(0, 0);
        }

        HashSet<Position> visitedPositions = new HashSet<>();
        visitedPositions.add(new Position(0, 0));

        Map<Character, int[]> dirMap = createDirectionMap();

        for (Move m : moves) {
            int[] move = dirMap.get(m.direction);
            for (int i = 0; i < m.steps; i++) {

                knots[0].x += move[0];
                knots[0].y += move[1];


                for (int knotIndex = 1; knotIndex < 10; knotIndex++) {
                    Position leader = knots[knotIndex - 1];
                    Position follower = knots[knotIndex];

                    int dx = leader.x - follower.x;
                    int dy = leader.y - follower.y;


                    if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
                        follower.x += (dx != 0) ? Integer.signum(dx) : 0;
                        follower.y += (dy != 0) ? Integer.signum(dy) : 0;
                    }
                }


                visitedPositions.add(new Position(knots[9].x, knots[9].y));
            }
        }

        return visitedPositions.size();
    }

    private Map<Character, int[]> createDirectionMap() {
        Map<Character, int[]> dirMap = new HashMap<>();
        dirMap.put('U', new int[]{0, 1});
        dirMap.put('R', new int[]{1, 0});
        dirMap.put('D', new int[]{0, -1});
        dirMap.put('L', new int[]{-1, 0});
        return dirMap;
    }
}