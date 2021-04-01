package FinalExamsJavaFundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([@#])(?<one>[A-Za-z]{3,})(\\1)(\\1)(?<two>[A-Za-z]{3,})(\\1)";
        String input = scanner.nextLine();
        List<String> words = new ArrayList<>();
        int count = 0;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            count++;
            String wordOne = matcher.group("one");
            String wordTwo = matcher.group("two");
            StringBuilder reversed = new StringBuilder(wordTwo);
            if (wordOne.equals(reversed.reverse().toString())) {
                words.add(wordOne+ " <=> "+ wordTwo);
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(count + " word pairs found!");
        }
        if (words.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(words.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
