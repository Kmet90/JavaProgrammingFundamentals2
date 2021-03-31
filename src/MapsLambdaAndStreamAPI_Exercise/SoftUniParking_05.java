package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> parking = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String name = tokens[1];
            switch (command) {
                case "register":
                    String registration = tokens[2];
                    if (!parking.containsKey(name)) {
                        parking.put(name, registration);
                        System.out.printf("%s registered %s successfully%n", name, registration);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", registration);
                    }
                    break;
                case "unregister":
                    if (parking.containsKey(name)) {
                        parking.remove(name);
                        System.out.printf("%s unregistered successfully%n", name);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", name);
                    }
                    break;
            }
        }
        parking.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
