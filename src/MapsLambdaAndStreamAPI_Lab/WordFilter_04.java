package MapsLambdaAndStreamAPI_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

         Arrays.stream(scanner.nextLine().split(" "))
               .filter(w->w.length()%2==0)
               .forEach(System.out::println);


    }
}
