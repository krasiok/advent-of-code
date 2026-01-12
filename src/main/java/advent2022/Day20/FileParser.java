package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public List<Item> parseFileToItemList(){
        List<Item> itemList = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("src/main/java/org/example/input.txt"))){
            String line;
            int index = 0;
            while((line = bf.readLine()) != null){
                itemList.add(new Item(Integer.parseInt(line),index));
                index++;
            }
        }
        catch (IOException e){
            System.out.println("Could not find a file");
        }
        return itemList;
    }
}
