package TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] filePat = scanner.nextLine().split("\\\\");
        String[] file = filePat[filePat.length - 1].split("\\.");
        String fileName = file[0];
        String fileEnd = file[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileEnd);
    }
}
