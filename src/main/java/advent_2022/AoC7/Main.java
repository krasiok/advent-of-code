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
        int totalSize = 70000000;
        int neededSize = 30000000;

        try (BufferedReader br = new BufferedReader(new FileReader("src/advent_2022/AoC7/input.txt"))) {
            String line;
            String fullPath = "";
            List<String> previous = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                Matcher matcher2 = filePattern.matcher(line);
                if (matcher2.find()) {
                    String tmpValue = matcher2.group();
                    int value = Integer.parseInt(tmpValue);

                    String currentFullPath = fullPath;
                    while (!currentFullPath.isEmpty()) {
                        if (pathSize.containsKey(currentFullPath)) {
                            pathSize.put(currentFullPath, pathSize.get(currentFullPath) + value);
                        }

                        int lastSlash = currentFullPath.lastIndexOf('/');
                        if (lastSlash <= 0) {
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
                            fullPath = "/";
                        } else if (fullPath.endsWith("/")) {
                            tmp = matched;
                            fullPath += tmp;
                        } else {
                            tmp = "/" + matched;
                            fullPath += tmp;
                        }

                        previous.add(matched.equals("/") ? "/" : tmp);

                        if (!pathSize.containsKey(fullPath)) {
                            pathSize.put(fullPath, 0);
                        }
                    }

                    if (line.contains("$ cd ..")) {
                        if (!previous.isEmpty()) {
                            String toRemove = previous.getLast();
                            if (toRemove.equals("/")) {
                                fullPath = "";
                            } else {
                                fullPath = fullPath.substring(0, fullPath.lastIndexOf(toRemove));
                            }
                            previous.removeLast();
                        }
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : pathSize.entrySet()) {
                Integer value = entry.getValue();
                if (totalSize - pathSize.get("/") + value >= neededSize) {
                    if (min > value) {
                        min = value;
                    }
                }
                if (value <= 100000) {
                    finalCounter1 += value;
                }
            }

            System.out.println("Rozmiar katalogu root '/': " + pathSize.get("/"));
            System.out.println("Part 1: " + finalCounter1);
            System.out.println("Part 2: " + min);
        } catch (IOException e) {
            System.err.println("Could not read the file");
        }
    }
}
