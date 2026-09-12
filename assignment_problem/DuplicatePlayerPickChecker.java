package assignment_problem;

public class DuplicatePlayerPickChecker {

    static String findDuplicatePick(String[] playerNames) {

        for (int i = 0; i < playerNames.length; i++) {

            for (int j = i + 1; j < playerNames.length; j++) {

                if (playerNames[i].equals(playerNames[j])) {
                    return playerNames[i];
                }
            }
        }

        return "No duplicate";
    }

    public static void main(String[] args) {

        String[] players = {
            "Virat", "Rohit", "Rahul", "Virat", "Bumrah"
        };

        System.out.println(findDuplicatePick(players));
    }
}