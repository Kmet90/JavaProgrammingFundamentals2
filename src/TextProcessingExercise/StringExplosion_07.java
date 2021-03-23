package TextProcessingExercise;

import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder field = new StringBuilder(scanner.nextLine());
        int bombStrength = 0;

        for (int i = 0; i < field.length(); i++) {
            if (bombStrength > 0 && field.charAt(i) != '>') {
                field.deleteCharAt(i);
                bombStrength--;
                i--;
            } else if (field.charAt(i) == '>') {
                bombStrength += field.charAt(i + 1) - '0';
            }
        }
        System.out.println(field.toString());
    }
}
