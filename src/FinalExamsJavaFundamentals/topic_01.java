package FinalExamsJavaFundamentals;

import java.util.Scanner;

public class topic_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        String commands = scanner.nextLine();

        while (!commands.equals("End")){
            String[] tokens = commands.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Translate": {
                    String symbol = tokens[1];
                    String replacement = tokens[2];
                    int indexSymbol = inputString.indexOf(symbol);
                    if (indexSymbol < 0) {
                        break;
                    }
                    inputString = inputString.replace(symbol, replacement);
                    System.out.println(inputString);
                }
                break;
                case "Includes": {
                    String containsString = tokens[1];
                    if (inputString.contains(containsString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                }
                break;
                case "Start": {
                    String containsString = tokens[1];
                    int indexBegin = inputString.indexOf(containsString);
                    int length = containsString.length();
                    if (indexBegin + length == length) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                }
                break;
                case "Lowercase": {
                   inputString =  inputString.toLowerCase();
                    System.out.println(inputString);
                }
                break;
                case "FindIndex": {
                    char symbol = tokens[1].charAt(0);
                    int lastIndex = inputString.lastIndexOf(String.valueOf(symbol));
                    System.out.println(lastIndex);
                }
                break;
                case "Remove": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    int endIndex = startIndex+count;
                    StringBuilder newString = new StringBuilder(inputString);
                    newString.delete(startIndex,endIndex);
                    inputString = newString.toString();
                    System.out.println(inputString);
                }
                break;
            }


            commands = scanner.nextLine();
        }
    }
}
