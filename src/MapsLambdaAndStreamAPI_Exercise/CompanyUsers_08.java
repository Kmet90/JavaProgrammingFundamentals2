package MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companies = new TreeMap<>();
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("->");
            String companyName = tokens[0].trim();
            String id = tokens[1].trim();

            companies.putIfAbsent(companyName, new ArrayList<>());
            if (!companies.get(companyName).contains(id)) {
                companies.get(companyName).add(id);
            }
            command = scanner.nextLine();
        }
        companies.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(id -> System.out.println("-- " + id));
        });
    }
}
