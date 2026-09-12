package assignment_problem;

import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores,
                                 int captainIndex,
                                 int viceCaptainIndex) {

        playerScores[captainIndex] *= 2;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {

        double[] scores = {50, 40, 30, 20};

        applyMultipliers(scores, 0, 1);

        System.out.println(Arrays.toString(scores));
    }
}