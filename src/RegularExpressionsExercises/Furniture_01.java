package RegularExpressionsExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<product>\\w+)<<(?<price>([0-9]+\\.[0-9]+)|(\\d+))!(?<quantity>\\d*)";
        String newProduct = scanner.nextLine();
        double sum = 0;
        List<String> products = new ArrayList<>();


        while (!newProduct.equals("Purchase")) {

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(newProduct);

            while (matcher.find()) {
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double totalPrice = price * quantity;
                String product = matcher.group("product");
                products.add(product);
                sum += totalPrice;
            }
            newProduct = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        products.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", sum);
    }
}
