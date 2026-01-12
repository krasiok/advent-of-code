package org.example;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void run() {
        FileParser fileParser = new FileParser();
        final List<Item> itemList = fileParser.parseFileToItemList();


        List<Item> executableItemList = new ArrayList<>(itemList);



            for (Item item : itemList) {
                int size = executableItemList.size();
                int value = item.getValue();
                if (value == 0) continue;

                int currentIndex = executableItemList.indexOf(item);
                executableItemList.remove(currentIndex);

                int newIndex = (currentIndex + value) % (size - 1);


                if (newIndex < 0) {
                    newIndex += (size - 1);
                }
                executableItemList.add(newIndex, item);
            }
        
        int zeroIndex = 0;
        for (int i = 0; i < executableItemList.size(); i++) {
            if (executableItemList.get(i).getValue() == 0) {
                zeroIndex = i;
                break;
            }
        }
        int size = executableItemList.size();
        int sum;
        int val1000 = executableItemList.get((zeroIndex + 1000) % size).getValue();
        int val2000 = executableItemList.get((zeroIndex + 2000) % size).getValue();
        int val3000 = executableItemList.get((zeroIndex + 3000) % size).getValue();

        sum = val1000 + val2000 + val3000;

        System.out.println(sum);

    }
}
