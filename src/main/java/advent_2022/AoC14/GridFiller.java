package advent_2022.AoC14;

import java.util.List;

public class GridFiller {
    public void gridFill(int[][] gridToFill, List<List<Position>> rockPostion){
        for(List<Position> positionList:rockPostion){
            for(int i=0; i<positionList.size(); i++){
                if(i+1<positionList.size()) {
                    int x = positionList.get(i).getX();
                    int nextX = positionList.get(i+1).getX();
                    int y = positionList.get(i).getY();
                    int nextY = positionList.get(i+1).getY();
                    if (x == nextX) {
                        if(y >= nextY){
                            while(y >= nextY) {
                                gridToFill[nextY][x] = 1;
                                nextY++;
                            }
                        }
                        else{
                            while(y <= nextY) {
                                gridToFill[y][x] = 1;
                                y++;
                            }
                        }
                    }
                    if(x != nextX){
                        if(x>=nextX){
                            while(x>=nextX){
                                gridToFill[y][nextX] = 1;
                                nextX++;
                            }
                        }
                        else{
                            while(x<=nextX){
                                gridToFill[y][x] = 1;
                                x++;
                            }
                        }
                    }
                }
            }
        }
    }
}
