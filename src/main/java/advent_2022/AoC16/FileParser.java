package advent_2022.AoC16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileParser {
    public List<Valve> inputToVaultConnections(String fileName){
        String regex = "Valve ([A-Z]{2}) has flow rate=(\\d+); tunnel[s]? lead[s]? to valve[s]? (.*)";
        Pattern pattern = Pattern.compile(regex);
        List<Valve> valves = new ArrayList<Valve>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null){
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    String valveName = matcher.group(1);
                    int flowRate = Integer.parseInt(matcher.group(2));
                    String[] connections = matcher.group(3).split(",");
                    valves.add(new Valve(valveName,flowRate,connections));
                }
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        return valves;
    }
}
