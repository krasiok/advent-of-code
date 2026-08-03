package advent_2022.AoC16;

import java.util.*;

public class Solution {
    FileParser fileParser = new FileParser();
    List<Valve> valves = fileParser.inputToVaultConnections("src/main/java/advent_2022/AoC16/input.txt");
    Queue<DistanceBox> checkNeighboursDistanceQueue = new LinkedList<>();
    Map<String,Integer> valveDistance = new HashMap<>();
    Set<Valve> logbook = new HashSet<>();

    private void checkAndSaveDistance(){
        String startName = valves.getFirst().getValveName();
        checkNeighboursDistanceQueue.add(new DistanceBox(valves.getFirst(),0));
        logbook.add(valves.getFirst());
            while(!checkNeighboursDistanceQueue.isEmpty()) {
                DistanceBox valve = checkNeighboursDistanceQueue.poll();
                int distance = valve.getDistance();
                for (Valve neighbour : getNeighbours(valve.getValve())) {
                    if(!logbook.contains(neighbour)) {
                        logbook.add(neighbour);
                        valveDistance.put(startName + "->" + neighbour.getValveName(), distance+1);
                        checkNeighboursDistanceQueue.add(new DistanceBox(neighbour,distance+1));
                    }
                }

            }
    }

    private List<Valve> getNeighbours(Valve mainValve){
        List<Valve> neighbours = new ArrayList<>();

            for(String neighbour:mainValve.getConnectedValves()){
                for(Valve valve:valves){
                    if(neighbour.trim().equals(valve.getValveName().trim())){
                        neighbours.add(valve);
                        break;
                    }
                }
            }
        return neighbours;
    }

    public void printValves(){
        checkAndSaveDistance();
        for(Map.Entry<String,Integer> entry:valveDistance.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


}
