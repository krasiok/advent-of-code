package advent_2022.AoC6;

public class Main {
    public static void main(String[] args) {
        String content = FileHandler.getContent("src/advent_2022/AoC6/input.txt");
        FindMarker fm = new FindMarker();
        fm.findFirstMarker(content, 4);
        fm.findFirstMarker(content, 14);
    }
}
