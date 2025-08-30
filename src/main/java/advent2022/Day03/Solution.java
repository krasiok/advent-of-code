package advent_2022.AoC3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void run(){

        int sum = 0;
        int sum2 = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        FileConverter fileConverter = new FileConverter();
        List<String> inputLines = fileConverter.inputLinesToList();
        List<String> firstHalf = new ArrayList<>();
        List<String> secondHalf = new ArrayList<>();
        for (String inputLine : inputLines) {
            firstHalf.add(inputLine.substring(0, inputLine.length() / 2));
            secondHalf.add(inputLine.substring(inputLine.length() / 2));
        }
        for(int i = 0; i < firstHalf.size(); i++){
            int counter=0;
            for(int j=0; j<alphabet.length(); j++){
                counter++;
                char letter = alphabet.charAt(j);
                if(firstHalf.get(i).contains(Character.toString(letter)) && secondHalf.get(i).contains(Character.toString(letter))){
                    sum+=counter;
                    break;
                }
            }

        }
        System.out.println(sum);


        for(int i = 0; i < inputLines.size(); i+=3){
            String sack1 = inputLines.get(i);
            String sack2 = inputLines.get(i + 1);
            String sack3 = inputLines.get(i + 2);
            int counter2=0;
            for(int j=0; j<alphabet.length(); j++){
                counter2++;
                char letter = alphabet.charAt(j);
                if(sack1.contains(Character.toString(letter)) && sack2.contains(Character.toString(letter)) && sack3.contains(Character.toString(letter))){
                    sum2+=counter2;
                    break;
                }
            }
        }

        System.out.println(sum2);


    }
}
