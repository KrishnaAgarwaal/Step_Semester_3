package assignment_problem;

public class TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {

        char longestChar = signalLog.charAt(0);
        int longestLength = 1;

        char currentChar = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == currentChar) {
                currentLength++;
            } else {
                currentChar = signalLog.charAt(i);
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestChar = currentChar;
            }
        }

        System.out.println("Longest streak character: " + longestChar);
        System.out.println("Longest streak length: " + longestLength);
    }

    public static void main(String[] args) {
        findLongestStreak("RRRGGGGGYYRR");
    }
}