package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> countCharacter = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                if (countCharacter.containsKey(ch)) {
                    countCharacter.put(ch, countCharacter.get(ch) + 1);
                } else {
                    countCharacter.put(ch, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : countCharacter.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        //countCharacter.forEach((k,v) -> System.out.printf("%s -> %d%n",k,v));
    }
}
