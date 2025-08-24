package advent_2022.AoC7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> pathSize = new HashMap<>();
        Pattern pattern = Pattern.compile("(\\/|\\w+)$");
        Pattern filePattern = Pattern.compile("^(\\d+)");
        String tmp;
        int finalCounter1 = 0;
        int finalCounter2 = 0;
        int totalSize = 70000000;
        int neededSize = 30000000;


        try (BufferedReader br = new BufferedReader(new FileReader("src/advent_2022/AoC7/input.txt"))) {
            String line;
            String previousPath = "";
            List<String> previous = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                Matcher matcher2 = filePattern.matcher(line);
                if (matcher2.find()) {
                    String tmpValue = matcher2.group();
                    int value = Integer.parseInt(tmpValue);

                    // POPRAWKA 1: Dodaj rozmiar do aktualnego katalogu i wszystkich nadrzędnych
                    String currentFullPath = previousPath;
                    while (!currentFullPath.isEmpty()) {
                        if (pathSize.containsKey(currentFullPath)) {
                            pathSize.put(currentFullPath, pathSize.get(currentFullPath) + value); // DODAJ zamiast nadpisywać
                        }

                        // Przejdź do katalogu nadrzędnego
                        int lastSlash = currentFullPath.lastIndexOf('/');
                        if (lastSlash <= 0) {
                            // Jesteśmy w root, dodaj do "/" i zakończ
                            if (pathSize.containsKey("/")) {
                                pathSize.put("/", pathSize.get("/") + value);
                            }
                            break;
                        } else {
                            currentFullPath = currentFullPath.substring(0, lastSlash);
                        }
                    }
                }

                if (line.contains("$ cd")) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find() && !line.contains("$ cd ..")) {
                        String matched = matcher.group();

                        if (matched.equals("/")) {
                            tmp = "/";
                            previousPath = "/"; // POPRAWKA 2: Ustaw previousPath na "/" dla root
                        } else if (previousPath.endsWith("/")) {
                            tmp = matched;
                            previousPath += tmp;
                        } else {
                            tmp = "/" + matched;
                            previousPath += tmp;
                        }

                        previous.add(matched.equals("/") ? "/" : tmp); // POPRAWKA 3: Dodaj właściwą wartość

                        if (!pathSize.containsKey(previousPath)) {
                            pathSize.put(previousPath, 0);
                        }
                    }

                    if (line.contains("$ cd ..")) {
                        if (!previous.isEmpty()) {
                            String toRemove = previous.get(previous.size() - 1);
                            // POPRAWKA 4: Lepsze usuwanie z końca ścieżki
                            if (toRemove.equals("/")) {
                                previousPath = "";
                            } else {
                                previousPath = previousPath.substring(0, previousPath.lastIndexOf(toRemove));
                            }
                            previous.remove(previous.size() - 1);
                        }
                    }
                }
            }
            int tmp42 = totalSize - pathSize.get("/");
            int min = 0;

            for (Map.Entry<String, Integer> entry : pathSize.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                if(totalSize-pathSize.get("/")+value>=neededSize){

                    if(finalCounter2==0) {
                        min = value;
                        finalCounter2++;
                    }
                    if(min>value){
                        min=value;
                    }

                }
                if (value <= 100000) {
                    finalCounter1 += value;
                }

            }
            System.out.println("Rozmiar katalogu root '/': " + pathSize.get("/"));


            System.out.println("Part 1: "+finalCounter1);
            System.out.println("Part 2: "+min);
        } catch (IOException e) {
            System.err.println("Could not write the file");
        }
    }
}