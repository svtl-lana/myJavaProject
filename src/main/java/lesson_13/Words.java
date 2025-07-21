package lesson_13;

import java.util.*;

public class Words {
    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "Blueberry", "Strawberry", "Peach", "Blueberry", "Cherry",
                "Strawberry", "Grape", "Grape", "Blueberry", "Cherry",
                "Peach", "Apple", "Grape", "Strawberry", "Cherry"
        );
        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println("Unique words:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                int oldCount = wordCount.get(word);
                wordCount.put(word, oldCount + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        System.out.println("------------------------");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
