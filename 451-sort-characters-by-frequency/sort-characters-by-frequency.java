import java.util.*;

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        // Count each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Store characters in a list
        List<Character> list = new ArrayList<>(map.keySet());

        // Sort by frequency
        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder result = new StringBuilder();

        // Add characters based on frequency
        for (char ch : list) {
            int count = map.get(ch);

            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}