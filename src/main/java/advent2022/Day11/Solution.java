package advent_2022.AoC11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public void run() {
        FileConverter fileConverter = new FileConverter();
        List<Monkey> monkeys = fileConverter.inputToList();


        long commonMultiple = 1;
        for (Monkey monkey : monkeys) {
            commonMultiple *= monkey.getTestValue();
        }

        int rounds = 10000;
        for (int round = 0; round < rounds; round++) {
            for (int m = 0; m < monkeys.size(); m++) {
                List<Integer> items = new ArrayList<>(monkeys.get(m).getItems());
                monkeys.get(m).getItems().clear();

                for (int item : items) {
                    long newValue;
                    if (monkeys.get(m).getOperationType() == '*') {
                        newValue = (monkeys.get(m).getOperationValue() == -1) ? (long) item * item : (long) item * monkeys.get(m).getOperationValue();
                    } else {
                        newValue = (long) item + monkeys.get(m).getOperationValue();
                    }


                    newValue %= commonMultiple;

                    if (newValue % monkeys.get(m).getTestValue() == 0) {
                        monkeys.get(monkeys.get(m).getIfTrue()).getItems().add((int) newValue);
                    } else {
                        monkeys.get(monkeys.get(m).getIfFalse()).getItems().add((int) newValue);
                    }

                    monkeys.get(m).setOperations(monkeys.get(m).getOperations() + 1);
                }
            }
        }

        List<Long> inspections = new ArrayList<>();
        for (Monkey monkey : monkeys) {
            inspections.add((long) monkey.getOperations());
        }

        Collections.sort(inspections, Collections.reverseOrder());
        if (inspections.size() >= 2) {
            long monkeyBusiness = inspections.get(0) * inspections.get(1);
            System.out.println(monkeyBusiness);
        } else {
            System.err.println("Nie udało się znaleźć dwóch małp do obliczenia wyniku.");
        }
    }
}