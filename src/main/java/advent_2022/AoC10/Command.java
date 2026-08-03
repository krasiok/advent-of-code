package advent_2022.AoC10;

public class Command {
    private String name;
    private int signalStrength;

    Command(String name, int strength){
        this.name=name;
        this.signalStrength =strength;
    }
    Command(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return signalStrength;
    }
}
