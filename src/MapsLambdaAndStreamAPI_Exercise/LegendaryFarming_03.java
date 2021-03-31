package MapsLambdaAndStreamAPI_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>() {
            {
                put("fragments", 0);
                put("shards", 0);
                put("motes", 0);
            }
        };
        Map<String, Integer> junk = new TreeMap<>();

        boolean isLegendaryOver250 = false;

        while (!isLegendaryOver250) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {

                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    int count = keyMaterials.get(material);
                    if (count >= 250) {
                        isLegendaryOver250 = true;
                        keyMaterials.put(material, count - 250);
                        switch (material) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        break;
                    }
                } else {
                    junk.putIfAbsent(material, 0);
                    junk.put(material, junk.get(material) + quantity);
                }
            }
        }
        keyMaterials.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junk.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
