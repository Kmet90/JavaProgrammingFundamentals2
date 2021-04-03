package FinalExamsJavaFundamentals;

import java.util.*;

public class topic_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> followers = new HashMap<>();
        String commands = scanner.nextLine();

        while (!commands.equals("Log out")) {
            String[] tokens = commands.split(":\\s+");
            String action = tokens[0];
            String username = tokens[1];

            switch (action) {
                case "New follower":
                    if (!followers.containsKey(username)) {
                        followers.put(username, new ArrayList<>());
                        followers.get(username).add(0, 0);
                        followers.get(username).add(1, 0);
                    }
                    break;
                case "Like":
                    int likes = Integer.parseInt(tokens[2]);
                    if (!followers.containsKey(username)) {
                        followers.put(username, new ArrayList<>());
                        followers.get(username).add(0, likes);
                        followers.get(username).add(1, 0);
                    } else {
                        int oldLikes = followers.get(username).get(0);
                        followers.get(username).set(0, oldLikes + likes);
                    }
                    break;
                case "Comment":
                    int comment = 1;
                    if (!followers.containsKey(username)) {
                        followers.put(username, new ArrayList<>());
                        followers.get(username).add(0, 0);
                        followers.get(username).add(1, comment);

                    } else {
                        int oldComments = followers.get(username).get(1);
                        followers.get(username).set(1, oldComments + comment);
                    }
                    break;
                case "Blocked":
                    if (!followers.containsKey(username)) {
                        System.out.printf("%s doesn't exist.%n", username);
                    } else {
                        followers.remove(username, followers.get(username));
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        System.out.println(followers.size() + " followers");

        followers.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if (getLikes(e1.getValue()) == getLikes(e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    }

                    return Integer.compare(getLikes(e2.getValue()), getLikes(e1.getValue()));
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), sumLikesAndComments(e.getValue())));

    }

    public static int sumLikesAndComments(List<Integer> list) {
        return list.get(0) + list.get(1);
    }

    public static int getLikes(List<Integer> list){
        return list.get(0);
    }

}
