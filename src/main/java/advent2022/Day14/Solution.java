package advent_2022.AoC14;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    FileParser fileParser = new FileParser();
    List<List<Position>> rockPostion = fileParser.fileInputToList();

    public void run(){
        Position sandStart = new Position(500,0);
        for(List<Position> positionList:rockPostion){
            for(Position position:positionList){
                
            }
        }
    }
}
