package TextProcessingLab;

import java.util.Scanner;

public class RepeatStrings_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        StringBuilder fullString = new StringBuilder();

        for (String s : input) {
            fullString.append(s.repeat(s.length()));
        }
        System.out.println(fullString);
    }
}
