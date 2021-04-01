package FinalExamsJavaFundamentals;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Reveal")) {
            String[] tokens = command.split(":\\|:");
            String action = tokens[0];

            switch (action) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    String firstPart = message.substring(0, index);
                    String secondPart = message.substring(index);
                    message = firstPart + " " + secondPart;
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    if (message.contains(substring)) {
                        int subIndex = message.indexOf(substring);
                        StringBuilder newMessage = new StringBuilder(message);
                        StringBuilder reversed = new StringBuilder(substring);
                        String newReversed = reversed.reverse().toString();
                        newMessage.replace(subIndex, subIndex + substring.length(), "");
                        message = newMessage.append(newReversed).toString();
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String text = tokens[1];
                    String replacement = tokens[2];
                    message = message.replace(text, replacement);
                    System.out.println(message);
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
