package assignment_problem.week1;

public class TypingSpeedAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matches = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matches * 100.0) / original.length();

        System.out.println("Accuracy: " + accuracy + "%");

        if (firstMismatch == -1) {
            System.out.println("No mismatch found.");
        } else {
            System.out.println("First mismatch at index: " + firstMismatch);
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("java programming", "java programmong");
    }
}