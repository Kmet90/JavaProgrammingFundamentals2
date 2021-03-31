package MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String resource = scan.nextLine();
        while (!"stop".equals(resource)) {
            int quantity = Integer.parseInt(scan.nextLine());
            resources.putIfAbsent(resource, 0);
            int currentValue = resources.get(resource) + quantity;
            resources.put(resource, currentValue);

            resource = scan.nextLine();
        }
        resources.forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }
}

