package TextProcessingExercise;

import java.util.Scanner;

public class ReplaceRepeatingChars_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder newLine = new StringBuilder();

        char ch = line.charAt(0);
        newLine.append(ch);

        for (int i = 1; i < line.length() - 1; i++) {
            if (ch != line.charAt(i)) {
                ch = line.charAt(i);
                newLine.append(ch);
            }
        }
        if (line.charAt(line.length()-1)!=line.charAt(line.length()-2)){
            newLine.append(line.charAt(line.length()-1));
        }

        System.out.println(newLine.toString());
    }
}
