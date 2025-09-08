package advent_2022.AoC13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileConverter {
    public List<Signal> parseFile() {

        List<Signal> signals = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/advent_2022/AoC13/input.txt"))) {
            while(true){
                String line1 = br.readLine();
                if(line1==null) break;
                if(line1.isEmpty()) continue;

                String line2 = br.readLine();
                if(line2==null) break;
                if(line2.isEmpty()) continue;

                signals.add(new Signal(PacketParser.parsePacket(line1),PacketParser.parsePacket(line2)));
            }
        } catch (IOException e) {
            System.err.println("Could not read the file");
        }
        return signals;
    }
}
