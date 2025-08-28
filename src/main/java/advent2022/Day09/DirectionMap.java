import java.util.HashMap;
import java.util.Map;

public class DirectionMap {
    private final Map<Character, int[]> dirMap = new HashMap<>();
    public DirectionMap(){
        dirMap.put('U', new int[]{0, 1});
        dirMap.put('R', new int[]{1, 0});
        dirMap.put('D', new int[]{0, -1});
        dirMap.put('L', new int[]{-1, 0});
    }

    public Map<Character, int[]> getDirMap() {
        return dirMap;
    }

}
