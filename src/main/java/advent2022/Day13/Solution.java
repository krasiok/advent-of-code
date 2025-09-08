package advent_2022.AoC13;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    FileConverter fileConverter = new FileConverter();
    List<Signal> signalsToCompare = fileConverter.parseFile();

    public void run() {
        // ----------------------
        // PART 1
        // ----------------------
        List<Integer> goodPairs = new ArrayList<>();
        int counter = 0;
        int index = 1; // AoC liczy indeksy od 1

        for (Signal signal : signalsToCompare) {
            int cmp = compareNested(signal.left, signal.right);
            if (cmp < 0) {
                goodPairs.add(index);
            }
            index++;
        }

        int total = 0;
        for (int sum : goodPairs) {
            total += sum;
        }
        System.out.println("Part 1 result: " + total);

        // ----------------------
        // PART 2
        // ----------------------
        List<Object> allPackets = new ArrayList<>();
        for (Signal signal : signalsToCompare) {
            allPackets.add(signal.left);
            allPackets.add(signal.right);
        }


        List<Object> divider2 = new ArrayList<>();
        divider2.add(new ArrayList<>(List.of(2)));

        List<Object> divider6 = new ArrayList<>();
        divider6.add(new ArrayList<>(List.of(6)));

        allPackets.add(divider2);
        allPackets.add(divider6);


        allPackets.sort(this::compareNested);


        int index2 = allPackets.indexOf(divider2) + 1;
        int index6 = allPackets.indexOf(divider6) + 1;

        System.out.println("Part 2 result: " + (index2 * index6));
    }

    private int compareNested(Object left, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return Integer.compare((Integer) left, (Integer) right);
        }

        if (left instanceof Integer && right instanceof List) {
            List<Object> lList = new ArrayList<>();
            lList.add(left);
            return compareNested(lList, right);
        }

        if (left instanceof List && right instanceof Integer) {
            List<Object> rList = new ArrayList<>();
            rList.add(right);
            return compareNested(left, rList);
        }

        if (left instanceof List && right instanceof List) {
            List<Object> lList = (List<Object>) left;
            List<Object> rList = (List<Object>) right;
            int minSize = Math.min(lList.size(), rList.size());

            for (int i = 0; i < minSize; i++) {
                int cmp = compareNested(lList.get(i), rList.get(i));
                if (cmp != 0) return cmp;
            }

            return Integer.compare(lList.size(), rList.size());
        }

        return 0; // w praktyce nie powinno nigdy dojść tutaj
    }
}
