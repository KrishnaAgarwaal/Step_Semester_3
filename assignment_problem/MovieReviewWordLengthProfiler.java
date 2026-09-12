package assignment_problem;

public class MovieReviewWordLengthProfiler {

    static void classifyWordLengths(String review) {

        String[] words = review.split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (int i = 0; i < words.length; i++) {

            int length = words[i].length();

            if (length >= 1 && length <= 4) {
                shortWords++;
            } 
            else if (length >= 5 && length <= 8) {
                mediumWords++;
            } 
            else {
                longWords++;
            }
        }

        System.out.println("Short words: " + shortWords);
        System.out.println("Medium words: " + mediumWords);
        System.out.println("Long words: " + longWords);
    }

    public static void main(String[] args) {

        String review = "Java is a powerful programming language";

        classifyWordLengths(review);
    }
}