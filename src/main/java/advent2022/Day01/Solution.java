package advent_2022.AoC1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    private int sumTopCalories(List<String> calorieSums, int topCount) {
        if (topCount > calorieSums.size()) {
            return 0;
        }
        int sumTop = Arrays.stream(String.join(" ", calorieSums).split("  "))
                .mapToInt(group -> Arrays.stream(group.trim().split(" "))
                        .filter(s -> !s.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .sum()
                )
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(topCount)
                .mapToInt(Integer::intValue)
                .sum();

        return sumTop;

    }

    public void run() {
        FileHandler fileHandler = new FileHandler();
        List<String> rawCalories = fileHandler.getConvertedListFromFile();


        System.out.println(sumTopCalories(rawCalories, 1));
        System.out.println(sumTopCalories(rawCalories, 3));
    }
}
