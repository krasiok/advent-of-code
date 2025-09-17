package advent_2022.AoC15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {
    public SensorData inputToSensorData(){
        List<Position> sensors = new ArrayList<>();
        List<Position> beacons = new ArrayList<>();
        List<Integer> ranges = new ArrayList<>();
        String regex = "x=(-?\\d+), y=(-?\\d+)";
        Pattern pattern = Pattern.compile(regex);

        try(BufferedReader br = new BufferedReader(new FileReader("src/advent_2022/AoC15/input.txt"))){
            String line;
            while((line = br.readLine()) != null){
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));
                    sensors.add(new Position(x,y));
                }
                if(matcher.find()){
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));
                    beacons.add(new Position(x,y));
                }
                int senX = sensors.get(sensors.size()-1).getX();
                int senY = sensors.get(sensors.size()-1).getY();
                int becX = beacons.get(beacons.size()-1).getX();
                int becY = beacons.get(beacons.size()-1).getY();
                int range = Math.abs(senX - becX) + Math.abs(senY - becY);
                ranges.add(range);
            }
        }
        catch (IOException e){
            System.err.println("Could not read the file");
        }
        return new SensorData(sensors,beacons,ranges);
    }
}