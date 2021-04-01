package Articles2_0_04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Articles> articles = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Articles article = new Articles(title,content,author);
            articles.add(article);
        }
        String cmd = scan.nextLine();

        switch (cmd) {
            case "title":
                articles.sort(Comparator.comparing(Articles::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(Articles::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(Articles::getAuthor));
                break;
        }

        for (Articles article : articles) {
            String element = article.toString();
            System.out.println(element);

        }
    }
}
