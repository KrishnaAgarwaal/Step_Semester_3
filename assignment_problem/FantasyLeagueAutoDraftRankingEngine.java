package assignment_problem;

import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        Player(String name, int matchesPlayed,
               double battingAverage, boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        @Override
        public int compareTo(Player other) {

            return Double.compare(
                other.battingAverage,
                this.battingAverage
            );
        }
    }

    // Experience-only rule
    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    // Experience + injury rule
    static boolean isDraftable(int matchesPlayed, boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {

        Player[] draftablePlayers = new Player[players.length];

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (isDraftable(
                    players[i].matchesPlayed,
                    players[i].injured)) {

                draftablePlayers[count] = players[i];
                count++;
            }
        }

        Player[] finalList = Arrays.copyOf(draftablePlayers, count);

        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < finalList.length; i++) {

            result.append(i + 1)
                  .append(". ")
                  .append(finalList[i].name)
                  .append(" - Fantasy Points: ")
                  .append(finalList[i].battingAverage)
                  .append("\n");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player("Rahul", 7, 55, false),

            new Player("Virat", 15, 48, false),

            new Player("Sameer", 3, 70, false),

            new Player("Dev", 12, 20, true)
        };

        System.out.println(draftAndRank(players));

        System.out.println(
            "Virat experience-only draftable: "
            + isDraftable(15)
        );

        System.out.println(
            "Rahul combined draftable: "
            + isDraftable(7, false)
        );
    }
}