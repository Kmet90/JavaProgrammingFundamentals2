package TextProcessingExercise;

import java.util.Scanner;

public class CaesarCipher_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        StringBuilder newPassword = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char ch = (char)(password.charAt(i) + 3);
            newPassword.append(ch);
        }
        System.out.println(newPassword.toString());
    }
}
