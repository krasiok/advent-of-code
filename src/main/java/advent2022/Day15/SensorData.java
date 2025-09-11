package advent_2022.AoC15;

import java.util.List;

public class SensorData {
    List<Position> sensors;
    List<Position> beacons;
    List<Integer> ranges;

    public SensorData(List<Position> sensors, List<Position> beacons, List<Integer> ranges){
        this.sensors=sensors;
        this.beacons=beacons;
        this.ranges=ranges;
    }
}
