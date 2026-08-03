package src.main.java.advent2022.Day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Cleanup {
    private boolean isOneRangeContainedInAnother(int aStart, int bStart, int aEnd, int bEnd) {
        return (bStart >= aStart && bEnd <= aEnd) || (aStart >= bStart && aEnd <= bEnd);
    }

    private boolean doRangesOverlap(int aStart, int bStart, int aEnd, int bEnd) {
        return (aStart <= bEnd && bStart <= aEnd);
    }

    public void run() {
        final String filePath = "src/main/java/advent2022/Day04/input.txt";
        int counter = 0;
        int counter2 = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("[-,]");
                int[] rangeValues = Arrays.stream(parts)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int aStart = rangeValues[0], aEnd = rangeValues[1];
                int bStart = rangeValues[2], bEnd = rangeValues[3];
                if (isOneRangeContainedInAnother(aStart, bStart, aEnd, bEnd)) {
                    counter++;
                }
                if (doRangesOverlap(aStart, bStart, aEnd, bEnd)) {
                    counter2++;
                }
            }
            System.out.println(counter);
            System.out.println(counter2);
        } catch (IOException e) {
            System.err.println("Could not read the input file: " + filePath);
            e.printStackTrace();
        }
    }
}

class Elf {

    int start, end;

    public boolean isContained(Elf elf) {
        return false;
    }
}
