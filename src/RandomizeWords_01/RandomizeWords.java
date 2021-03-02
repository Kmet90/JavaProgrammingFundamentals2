package RandomizeWords_01;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Random rdn = new Random();

        for (int i = 0; i < words.length; i++) {
            int position = rdn.nextInt(words.length);
            String word = words[i];
            words[i]= words[position];
            words[position] = word;
        }
        System.out.println(String.join(System.lineSeparator(), words));
    }
}
