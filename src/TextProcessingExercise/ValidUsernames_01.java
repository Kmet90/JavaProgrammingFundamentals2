package TextProcessingExercise;

import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] userNames = scanner.nextLine().split(", ");

        for (String name : userNames) {
            if (checkValidation(name)) {
                System.out.println(name);
            }
        }
    }

    private static boolean checkValidation(String userNames) {
        if (userNames.length()<3 || userNames.length()>16){
            return false;
        }
        for (int i = 0; i < userNames.length(); i++) {
            char ch = userNames.charAt(i);
            if (!Character.isLetterOrDigit(ch) && ch != '-' && ch != '_') {
                return false;
            }
        }
        return true;
    }
}
