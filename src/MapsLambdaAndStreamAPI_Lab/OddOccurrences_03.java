package MapsLambdaAndStreamAPI_Lab;

import java.util.*;

public class OddOccurrences_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            String wordsInLowerCase = word.toLowerCase();
            if (counts.containsKey(wordsInLowerCase)) {
                counts.put(wordsInLowerCase, counts.get(wordsInLowerCase) + 1);
            } else {
                counts.put(wordsInLowerCase, 1);
            }
        }
        ArrayList<String> odds = new ArrayList<>();

        for (var entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", odds));
    }
}
