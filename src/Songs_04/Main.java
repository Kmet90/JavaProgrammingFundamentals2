package Songs_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfSongs = Integer.parseInt(scanner.nextLine());

        List<Songs> songs = new ArrayList<>();

        for (int i = 0; i < numbersOfSongs; i++) {
            String[] data = scanner.nextLine().split("_");
            String type = data[0];
            String name = data[1];
            String time = data[2];

            Songs song = new Songs();

            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }
        String typeList = scanner.nextLine();

        if (typeList.equals("all")) {
            for (Songs song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Songs song : songs) {
                if (song.getTypeList().equals(typeList)){
                    System.out.println(song.getName());
                }
            }
        }
    }
}
