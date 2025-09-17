package advent_2022.AoC15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    FileParser fileParser = new FileParser();
    SensorData sensorData = fileParser.inputToSensorData();

    public void run() {
        part1();
        part2();
    }

    public void part1() {
        final int CONSTANT_Y = 2000000;
        List<int[]> correctRanges = new ArrayList<>();
        int counter = 0;

        for (Integer range : sensorData.ranges) {
            int difference = Math.abs(sensorData.sensors.get(counter).getY() - CONSTANT_Y);
            int sensorX = sensorData.sensors.get(counter).getX();
            if (range >= difference) {
                int horizontalReach = range - difference;
                int diffLeft = sensorX - horizontalReach;
                int diffRight = sensorX + horizontalReach;
                correctRanges.add(new int[]{diffLeft, diffRight});
            }
            counter++;
        }

        correctRanges.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> correctRangesMerge = new ArrayList<>();
        if (!correctRanges.isEmpty()) {
            int currentLeft = correctRanges.get(0)[0];
            int currentRight = correctRanges.get(0)[1];

            for (int i = 1; i < correctRanges.size(); i++) {
                int nextLeft = correctRanges.get(i)[0];
                int nextRight = correctRanges.get(i)[1];

                if (currentRight >= nextLeft - 1) {
                    currentLeft = Math.min(currentLeft, nextLeft);
                    currentRight = Math.max(currentRight, nextRight);
                } else {
                    correctRangesMerge.add(new int[]{currentLeft, currentRight});
                    currentLeft = nextLeft;
                    currentRight = nextRight;
                }
            }

            correctRangesMerge.add(new int[]{currentLeft, currentRight});
        }

        int sum = 0;
        for (int[] range : correctRangesMerge) {
            sum += range[1] - range[0] + 1;
        }

        Set<Integer> beaconsToSubtract = new HashSet<>();
        for (Position beacon : sensorData.beacons) {
            if (beacon.getY() == CONSTANT_Y) {
                for (int[] interval : correctRangesMerge) {
                    if (beacon.getX() >= interval[0] && beacon.getX() <= interval[1]) {
                        beaconsToSubtract.add(beacon.getX());
                        break;
                    }
                }
            }
        }

        sum -= beaconsToSubtract.size();

        System.out.println("Part 1: " + sum);
    }

    public void part2() {
        final int MAX_COORDINATE = 4000000;

        List<Integer> linesPlus = new ArrayList<>();
        List<Integer> linesMinus = new ArrayList<>();

        for (int i = 0; i < sensorData.sensors.size(); i++) {
            int sx = sensorData.sensors.get(i).getX();
            int sy = sensorData.sensors.get(i).getY();
            int range = sensorData.ranges.get(i);

            int perimeter = range + 1;

            linesPlus.add(sx + sy + perimeter);
            linesPlus.add(sx + sy - perimeter);
            linesMinus.add(sx - sy + perimeter);
            linesMinus.add(sx - sy - perimeter);
        }

        for (int plusC : linesPlus) {
            for (int minusC : linesMinus) {
                if ((plusC + minusC) % 2 == 0) {
                    int x = (plusC + minusC) / 2;
                    int y = (plusC - minusC) / 2;

                    if (x >= 0 && x <= MAX_COORDINATE && y >= 0 && y <= MAX_COORDINATE) {
                        if (isPointNotCovered(x, y)) {
                            long tuningFrequency = (long) x * 4000000L + y;
                            System.out.println("Part 2: " + tuningFrequency);
                            return;
                        }
                    }
                }
            }
        }
    }

    private boolean isPointNotCovered(int x, int y) {
        for (int i = 0; i < sensorData.sensors.size(); i++) {
            int sensorX = sensorData.sensors.get(i).getX();
            int sensorY = sensorData.sensors.get(i).getY();
            int range = sensorData.ranges.get(i);

            int distance = Math.abs(x - sensorX) + Math.abs(y - sensorY);
            if (distance <= range) {
                return false;
            }
        }
        return true;
    }
}