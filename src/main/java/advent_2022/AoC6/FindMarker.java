package advent_2022.AoC6;


import java.util.*;

public class FindMarker {
    private boolean compareSizes(Deque<Character> charactersFromInput, Set<Character> distinctCharacters, int distinctCharactersLength) {
        return charactersFromInput.size() == distinctCharactersLength && distinctCharacters.size() == distinctCharactersLength;
    }

    public void findFirstMarker(String content, int distinctCharactersLength) {
        Deque<Character> charactersFromInput = new ArrayDeque<>();
        Set<Character> distinctCharacters = new HashSet<>();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            charactersFromInput.add(c);
            if (charactersFromInput.size() > distinctCharactersLength) {
                char remove = charactersFromInput.removeFirst();

                if (!charactersFromInput.contains(remove)) {
                    distinctCharacters.remove(remove);
                }
            }
            distinctCharacters.add(c);
            if (compareSizes(charactersFromInput, distinctCharacters, distinctCharactersLength)) {
                System.out.println(i + 1);
                break;
            }
        }

    }
}


