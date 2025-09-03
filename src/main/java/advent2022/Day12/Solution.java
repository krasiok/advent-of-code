package advent_2022.AoC12;

import java.util.*;

public class Solution {
    FileConverter fileConverter = new FileConverter();

    public void run() {
        List<String> lines = fileConverter.fileToGrid();
        int rows = lines.size();
        int cols = lines.get(0).length();

        Position start = null;
        Position end = null;
        List<Position> allAs = new ArrayList<>();

        char[][] grid = new char[rows][cols];

        
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                char c = lines.get(y).charAt(x);
                grid[y][x] = c;

                if (c == 'S') {
                    start = new Position(x, y);
                    allAs.add(new Position(x, y));
                }
                if (c == 'E') end = new Position(x, y);
                if (c == 'a') allAs.add(new Position(x, y));
            }
        }

        // Part 1
        int part1 = bfs(grid, Collections.singletonList(start), end);
        System.out.println("Part 1 (S → E): " + part1);

        // Part 2
        int part2 = bfs(grid, allAs, end);
        System.out.println("Part 2 (najkrótsza z dowolnego 'a' → E): " + part2);
    }

    private int bfs(char[][] grid, List<Position> starts, Position end) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Node> queue = new LinkedList<>();

        for (Position start : starts) {
            queue.add(new Node(start.getX(), start.getY(), 0));
            visited[start.getY()][start.getX()] = true;
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.getX();
            int y = current.getY();
            int steps = current.getSteps();

            if (x == end.getX() && y == end.getY()) return steps;

            char currentHeight = convertChar(grid[y][x]);

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < cols && ny >= 0 && ny < rows && !visited[ny][nx]) {
                    char neighbourHeight = convertChar(grid[ny][nx]);
                    if (neighbourHeight <= currentHeight + 1) {
                        visited[ny][nx] = true;
                        queue.add(new Node(nx, ny, steps + 1));
                    }
                }
            }
        }

        return -1;
    }

    private char convertChar(char c) {
        if (c == 'S') return 'a';
        if (c == 'E') return 'z';
        return c;
    }
}
