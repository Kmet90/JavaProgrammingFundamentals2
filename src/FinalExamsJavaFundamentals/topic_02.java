package FinalExamsJavaFundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class topic_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "([!])(?<command>[A-Z][a-z]{2,})\\1:\\[(?<message>[A-Za-z]{8,})]";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String inputString = scanner.nextLine();
            Matcher matcher = pattern.matcher(inputString);

            if (matcher.find()) {
                String message = matcher.group("message");
                System.out.print(matcher.group("command") + ": ");
                List<String> newMessage = new ArrayList<>();
                for (int j = 0; j < message.length(); j++) {
                    int ch = message.charAt(j);
                    String string = String.valueOf(ch);
                    newMessage.add(string);
                }
                System.out.println(String.join(" ",newMessage));

            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
