package OrderByAge_07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        String name = scanner.next();
        while(!name.equals("End")){

            String id = scanner.next();
            int age = scanner.nextInt();

            Person currentPerson = new Person(name,id,age);
            persons.add(currentPerson);

            name=scanner.next();
        }
        persons.sort(Comparator.comparingInt(Person::getAge));

        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}
