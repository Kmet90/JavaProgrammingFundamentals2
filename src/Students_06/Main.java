package Students_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Students_06.Students> students = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] tokens = line.split(" ");

            String firstName = tokens[0];
            String secondName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String town = tokens[3];

            if (isStudentExisting(students, firstName, secondName)) {
                Students student = getStudent(students, firstName, secondName);
                student.setFirstName(firstName);
                student.setSecondName(secondName);
                student.setAge(age);
                student.setTown(town);
            } else {
                Students_06.Students student = new Students_06.Students(firstName, secondName, age, town);
                students.add(student);
            }

            line = scanner.nextLine();
        }
        String filterTown = scanner.nextLine();

        for (Students student : students) {
            if (student.getTown().equals(filterTown)) {
                System.out.printf("%s %s is %d years old%n"
                        , student.getFirstName(), student.getSecondName(), student.getAge());
            }
        }
    }

    private static Students getStudent(List<Students> students, String firstName, String secondName) {
        Students existingStudent = null;
        for (Students student : students) {
            if (student.getFirstName().equals(firstName) && student.getSecondName().equals(secondName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }

    private static boolean isStudentExisting(List<Students> students, String firstName, String secondName) {
        for (Students student : students) {
            if (student.getFirstName().equals(firstName) && student.getSecondName().equals(secondName)) {
                return true;
            }
        }
        return false;
    }
}
