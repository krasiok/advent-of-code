package advent_2022.AoC16;

import java.util.*;

public class Solution {
    FileParser fileParser = new FileParser();
    List<Valve> valves = fileParser.inputToVaultConnections("src/main/java/advent_2022/AoC16/input.txt");
    Queue<DistanceBox> checkNeighboursDistanceQueue = new LinkedList<>();
    //    Map<String, Integer> valveDistance = new HashMap<>();
    Map<String, TargetBox> valveTarget = new HashMap<>();
    Set<Valve> logbook = new HashSet<>();

    private void checkAndSaveDistance() {
        for(Valve valve : valves) {
            String startName = valve.getValveName();
            checkNeighboursDistanceQueue.add(new DistanceBox(valve, 0));
            logbook.add(valve);
            while (!checkNeighboursDistanceQueue.isEmpty()) {
                DistanceBox valveBox = checkNeighboursDistanceQueue.poll();
                int distance = valveBox.getDistance();

                for (Valve neighbour : getNeighbours(valveBox.getValve())) {
                    if (!logbook.contains(neighbour)) {
                        logbook.add(neighbour);
                        if (neighbour.getFlowRate() > 0) {
                            valveTarget.put(startName + "->" + neighbour.getValveName(), new TargetBox(distance + 1, neighbour.getFlowRate()));
                        }
                        checkNeighboursDistanceQueue.add(new DistanceBox(neighbour, distance + 1));
                    }
                }

            }
            logbook.clear();
        }
    }

    private List<Valve> getNeighbours(Valve mainValve) {
        List<Valve> neighbours = new ArrayList<>();

        for (String neighbour : mainValve.getConnectedValves()) {
            for (Valve valve : valves) {
                if (neighbour.trim().equals(valve.getValveName().trim())) {
                    neighbours.add(valve);
                    break;
                }
            }
        }
        return neighbours;
    }

    private int chooseBestWay(String room, int time, Set<String> visited){

        int maxPressure = 0;

        for(Map.Entry<String,TargetBox> entry : valveTarget.entrySet()){

            Set<String> newVisited = new HashSet<>(visited);

            TargetBox targetBox = entry.getValue();
            int distance = targetBox.getDistance();
            int flowRate = targetBox.getFlowRate();
            int openingTime = 1;
            String connection = entry.getKey();
            String startName = connection.substring(0,2);
            String destinationName = connection.substring(connection.length() - 2);

            if(startName.equals(room)) {
                if (distance < time && !newVisited.contains(destinationName)) {
                    int remainingTime = time - distance - openingTime;
                    int tmpPressure = remainingTime * flowRate;
                    newVisited.add(destinationName);
                    tmpPressure += chooseBestWay(destinationName, remainingTime, newVisited);
                    if (tmpPressure > maxPressure) {
                        maxPressure = tmpPressure;
                    }
                }
            }

        }
        return maxPressure;
    }

    public void printValves() {
        checkAndSaveDistance();
        Set<String> initialVisited = new HashSet<>();
        initialVisited.add("AA");
        int maxPressure = chooseBestWay("AA",30, initialVisited);
        System.out.println(maxPressure);
    }


}
