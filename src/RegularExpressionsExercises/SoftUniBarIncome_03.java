package RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*" +
                "\\|(?<quantity>\\d+)\\|[^|$%.]*?(?<price>\\d+([.]\\d+)?)\\$";
        double totalIncome = 0;

        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalPrice = quantity * price;
                totalIncome += totalPrice;
                System.out.printf("%s: %s - %.2f%n", name, product, totalPrice);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
