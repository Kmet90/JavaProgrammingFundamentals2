package TextProcessingLab;

import java.util.Scanner;

public class TextFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            if (text.contains(bannedWord)) {
                String replacement = replacementWord("*", bannedWord.length());
                text = text.replace(bannedWord, replacement);
            }
        }
        System.out.println(text);
    }

    private static String replacementWord(String s, int length) {
        return String.valueOf(s).repeat(Math.max(0, length));
    }
}
