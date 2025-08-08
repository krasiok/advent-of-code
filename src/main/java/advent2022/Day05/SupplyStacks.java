package src.main.java.advent2022.Day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class SupplyStacks {
    Commands commands = new Commands();
    CrateStacks stacks = new CrateStacks();
    public void run() {

        try (BufferedReader input = new BufferedReader(new FileReader("src/main/java/advent2022/Day05/input.txt"))) {
            String line;
            while((line = input.readLine()) != null){
               String[] moveFromTo = line.split( "[^\\d]+");
                commands.move.add(Integer.parseInt(moveFromTo[1]));
                commands.from.add(Integer.parseInt(moveFromTo[2]));
                commands.to.add(Integer.parseInt(moveFromTo[3]));
            }
            int counter =0;
            for(int i =0; i<commands.move.size(); i++) {
                for (int j = 0; j < commands.move.get(counter); j++) {
                    Stack<String> loopStack = stacks.crateColumns.get(commands.from.get(counter)-1);
                    Stack<String> loopStack2 = stacks.crateColumns.get(commands.to.get(counter)-1);
                    String element = loopStack.pop();
                    loopStack2.push(element);
                }
                counter++;
            }
            for(int i=0; i<9; i++){
                System.out.print(stacks.crateColumns.get(i).peek());
            }

        } catch (IOException e) {
            System.err.println("Could not read the input file");
            e.printStackTrace();
        }
    }
}
