package lesson_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        if (!book.containsKey(surname)) {
            book.put(surname, new ArrayList<>());
        }
        book.get(surname).add(phoneNumber);
    }
    public List<String> get(String surname) {
        return book.getOrDefault(surname, new ArrayList<>());
    }
}