package MapsLambdaAndStreamAPI_Lab;

import java.util.*;

public class WordSynonyms_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> wordsSynonyms = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            wordsSynonyms.putIfAbsent(word, new ArrayList<>());
            wordsSynonyms.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : wordsSynonyms.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ",entry.getValue()));
        }
    }
}
