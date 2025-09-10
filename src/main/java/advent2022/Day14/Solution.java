package advent_2022.AoC14;

import java.util.List;

public class Solution {

    FileParser fileParser = new FileParser();
    List<List<Position>> rockPostion = fileParser.fileInputToList();
    int grid[][] = fileParser.getGrid();
    GridFiller gridFiller = new GridFiller();

    public void run() {
        Position sandStart = new Position(500, 0);
        Position sandCurr = new Position(500, 0);
        int sandCounter = 0;
        gridFiller.gridFill(grid, rockPostion);

        //PART 1
//        while (true) {
//            if (sandCurr.getY() + 1 >= grid.length || sandCurr.getX() - 1 < 0 || sandCurr.getX() + 1 >= grid[0].length) {
//                break;
//            }
//            if (grid[sandCurr.getY() + 1][sandCurr.getX()] == 0) {
//                sandCurr.setY(sandCurr.getY() + 1);
//                continue;
//            }
//            if (grid[sandCurr.getY() + 1][sandCurr.getX() - 1] == 0) {
//                sandCurr.setY(sandCurr.getY() + 1);
//                sandCurr.setX(sandCurr.getX() - 1);
//                continue;
//            }
//            if (grid[sandCurr.getY() + 1][sandCurr.getX() + 1] == 0) {
//                sandCurr.setY(sandCurr.getY() + 1);
//                sandCurr.setX(sandCurr.getX() + 1);
//                continue;
//            }
//            grid[sandCurr.getY()][sandCurr.getX()] = 1;
//            sandCounter++;
//            sandCurr = new Position(sandStart.getX(), sandStart.getY());
//        }

        while (true) {
            int x = sandCurr.getX();
            int y = sandCurr.getY();

            if (grid[y + 1][x] == 0) {
                sandCurr.setY(y + 1);
            } else if (x - 1 >= 0 && grid[y + 1][x - 1] == 0) {
                sandCurr.setY(y + 1);
                sandCurr.setX(x - 1);
            } else if (x + 1 < grid[0].length && grid[y + 1][x + 1] == 0) {
                sandCurr.setY(y + 1);
                sandCurr.setX(x + 1);
            } else {
                grid[y][x] = 1;
                sandCounter++;

                if (grid[sandStart.getY()][sandStart.getX()] == 1) {
                    break;
                }

                sandCurr = new Position(sandStart.getX(), sandStart.getY());
            }
        }



        System.out.println(sandCounter);

    }
}
