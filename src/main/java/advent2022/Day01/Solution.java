package advent_2022.AoC1;

import java.util.*;

public class Solution {


    private int sumTopGroups(List<String> rawInput, int topCount) {
        List<Integer> summedCalories = new ArrayList<>();

        int sum = 0;
        for (String number : rawInput) {

            if (!number.isEmpty()) {
                sum += Integer.parseInt(number);
            } else {
                summedCalories.add(sum);
                sum = 0;
            }
        }

        if (sum > 0) {
            summedCalories.add(sum);
        }


        summedCalories.sort(Collections.reverseOrder());
        int totalSum = 0;
        for (int i = 0; i < topCount && i < summedCalories.size(); i++) {
            totalSum += summedCalories.get(i);
        }

        return totalSum;
    }

    public void run() {
        FileHandler fileHandler = new FileHandler();
        List<String> rawCalories = fileHandler.getConvertedListFromFile();
        System.out.println(sumTopGroups(rawCalories, 1));
        System.out.println(sumTopGroups(rawCalories, 3));
    }
}
