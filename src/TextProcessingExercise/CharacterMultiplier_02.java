package TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputString = scanner.nextLine().split("\\s+");
        String string1 = inputString[0];
        String string2 = inputString[1];
        int minLength = Math.min(string1.length(), string2.length());
        int maxLength = Math.max(string1.length(), string2.length());

        int sum = 0;

        for (int i = 0; i < minLength; i++) {
            char ch1 = string1.charAt(i);
            char ch2 = string2.charAt(i);
            int multiply = ch1 * ch2;
            sum += multiply;
        }
        if (string1.length() > string2.length()) {
            for (int i = minLength; i < maxLength; i++) {
                char ch = string1.charAt(i);
                sum += ch;
            }
        } else {
            for (int i = minLength; i < maxLength; i++) {
                char ch = string2.charAt(i);
                sum += ch;
            }
        }
        System.out.println(sum);
    }
}
