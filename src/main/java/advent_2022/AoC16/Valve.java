package advent_2022.AoC16;

import java.util.Arrays;

public class Valve {
    private String valveName;
    private int flowRate;
    private String[] connectedValves;

    public Valve(String valveName, int flowRate, String[] connectedValves) {
        this.valveName = valveName;
        this.flowRate = flowRate;
        this.connectedValves = connectedValves;
    }

    public String getValveName() {
        return valveName;
    }

    public int getFlowRate() {
        return flowRate;
    }

    public String[] getConnectedValves() {
        return connectedValves;
    }

    @Override
    public String toString() {
        return valveName + " " + flowRate + " " + Arrays.toString(connectedValves);
    }
}
