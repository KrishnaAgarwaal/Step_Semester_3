package assignment_problem;

public class MatchDayGridAnalyzer {

    static double rowAverage(int[] row) {

        int sum = 0;

        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {

            double average = rowAverage(runsPerOver[i]);

            if (average >= threshold) {
                result.append("Match ")
                      .append(i + 1)
                      .append(": Power Surge");
            } else {
                result.append("Match ")
                      .append(i + 1)
                      .append(": Normal");
            }

            result.append(" | Average: ")
                  .append(average)
                  .append("\n");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        int[][] runsPerOver = {
            {10, 8, 12, 15},
            {4, 5, 6},
            {9, 10, 11, 12, 13}
        };

        int threshold = 9;

        System.out.println(classifyMatches(runsPerOver, threshold));
    }
}