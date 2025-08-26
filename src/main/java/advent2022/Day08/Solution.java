package advent_2022.AoC8;

import java.util.List;

public class Solution {
    FileHandler file = new FileHandler();
    List<String> lines = file.attachFile("src/advent_2022/AoC8/input.txt");

    public void run() {
        int visible = 0;
        int rowLength = lines.size();
        int colLength = lines.getFirst().length();


        int[][] gridOfTrees = new int[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                gridOfTrees[i][j] = Character.getNumericValue(lines.get(i).charAt(j));
            }
        }
        int maxScenicScore = 0;
        int currentScenicScore;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                int treeHeight = gridOfTrees[i][j];

                int distanceUp = 0;
                int distanceDown = 0;
                int distanceLeft = 0;
                int distanceRight = 0;

                boolean visibleTop = true;
                boolean visibleBottom = true;
                boolean visibleLeft = true;
                boolean visibleRight = true;

                // up
                for (int k = i - 1; k >= 0; k--) {
                    distanceUp++;
                    if (gridOfTrees[k][j] >= treeHeight) {
                        visibleTop = false;
                        break;
                    }
                }

                // down
                for (int k = i + 1; k < rowLength; k++) {
                    distanceDown++;
                    if (gridOfTrees[k][j] >= treeHeight) {
                        visibleBottom = false;
                        break;
                    }
                }

                // left
                for (int k = j - 1; k >= 0; k--) {
                    distanceLeft++;
                    if (gridOfTrees[i][k] >= treeHeight) {
                        visibleLeft = false;
                        break;
                    }
                }

                //right
                for (int k = j + 1; k < colLength; k++) {
                    distanceRight++;
                    if (gridOfTrees[i][k] >= treeHeight) {
                        visibleRight = false;
                        break;
                    }
                }


                if (visibleTop || visibleBottom || visibleLeft || visibleRight) {
                    visible++;
                }
                currentScenicScore = distanceDown * distanceLeft * distanceRight * distanceUp;

                if (currentScenicScore > maxScenicScore) {
                    maxScenicScore = currentScenicScore;
                }
            }
        }

        System.out.println("Visible trees:" + visible);
        System.out.println("Maximum scenic:" + maxScenicScore);
    }
}
