package MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class StudentAcademy_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsInfo = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            studentsInfo.putIfAbsent(name, new ArrayList<>());
            studentsInfo.get(name).add(grade);
        }

        studentsInfo.entrySet().stream()
                .filter(e -> e.getValue()
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .getAsDouble() >= 4.50)
                .sorted((a,b)-> {
                    double first = a.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = b.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(second,first);
                })
                .forEach(s -> System.out.printf("%s -> %.2f%n",s.getKey(),
                        s.getValue().stream().mapToDouble(Double:: valueOf)
                                .average()
                                .getAsDouble()));

       /* studentsInfo.entrySet().stream()
                .map(e -> { //change the elements from Map.Entry<String, List<Double>> to Pair<String, Double>
                    Double averageGrade = e.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
                    return new Pair<>(e.getKey(), averageGrade);
                }).filter(e -> e.getValue() >= 4.5) //remove all elements, which do NOT meet this criteria
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) //sort descending
                .forEach(e -> System.out.println(String.format("%s -> %.2f", e.getKey(), e.getValue()))); //print*/

    }
}
