package Students_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Students> students = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("end")){
            String[] tokens = line.split(" ");

            String firstName = tokens[0];
            String secondName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String town = tokens[3];

            Students student = new Students(firstName, secondName, age , town);
            students.add(student);

            line = scanner.nextLine();
        }
        String filterTown = scanner.nextLine();

        for (Students student : students) {
            if (student.getTown().equals(filterTown)){
                System.out.printf("%s %s is %d years old%n"
                        , student.getFirstName(),student.getSecondName(),student.getAge());
            }
        }
    }
}
