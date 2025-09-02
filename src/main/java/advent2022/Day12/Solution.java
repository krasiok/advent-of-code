package advent_2022.AoC12;

import java.util.List;

public class Solution {
    FileConverter fileConverter = new FileConverter();
    public void run(){
        List<String> lines = fileConverter.fileToGrid();
        int y = lines.size();
        int x = lines.getFirst().length();
        Position sPos;
        Position ePos;

        char[][] grid = new char[y][x];

        // wypełninie całego grida i zaznaczenie start i koniec
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                grid[i][j] = lines.get(i).charAt(j);
                if(lines.get(i).charAt(j)=='S'){
                    sPos=new Position(j,i);
                }
                if(lines.get(i).charAt(j)=='E'){
                    ePos=new Position(j,i);
                }
            }
        }

        


    }
}
