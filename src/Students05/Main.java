package Students05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Students> students = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String studentsData = scanner.nextLine();
            //"Lakia Eason 3.90" -> split(" ") -> ["Lakia", "Eason", "3.90"]
            String[] splittedData = studentsData.split("\\s+"); //["Lakia", "Eason", "3.90"]
            String firstName = splittedData[0];
            String lastName = splittedData[1];
            double grade = Double.parseDouble(splittedData[2]);

            Students student = new Students(firstName, lastName, grade);
            students.add(student);
        }

        List<Students> sortedList = students.stream()
                .sorted(Comparator.comparing(Students::getGrade).reversed())
                .collect(Collectors.toList());

        for (Students student : sortedList) {
            System.out.println(student.toString());
        }
    }
}
