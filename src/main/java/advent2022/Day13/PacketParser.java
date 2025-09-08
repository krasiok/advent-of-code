package advent_2022.AoC13;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class PacketParser {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Object parsePacket(String line) throws IOException {
        // Parse JSON into either Integer or List (recursively nested)
        return mapper.readValue(line, Object.class);
    }
}
