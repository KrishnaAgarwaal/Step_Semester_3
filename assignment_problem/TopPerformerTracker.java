package assignment_problem;

public class TopPerformerTracker {

    static String findMinMaxSpread(int[] scores) {

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {

            if (scores[i] < min) {
                min = scores[i];
            }

            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;

        return "Minimum: " + min +
               " | Maximum: " + max +
               " | Spread: " + spread;
    }

    public static void main(String[] args) {

        int[] scores = {45, 78, 62, 91, 55};

        System.out.println(findMinMaxSpread(scores));
    }
}