package class_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class ExamQuestion {
    String correctAnswer;
    String studentAnswer;
    double points;

    ExamQuestion(String correctAnswer, String studentAnswer,
                 double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();
}

class MCQQuestion extends ExamQuestion {
    MCQQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends ExamQuestion {
    TrueFalseQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class EssayQuestion extends ExamQuestion {
    EssayQuestion(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        String[] keywords = correctAnswer.split(",");
        int matches = 0;
        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        Pattern pattern = Pattern.compile(
            "^(MCQ|TF|ESSAY)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$"
        );

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher matcher = pattern.matcher(line);

            if (!matcher.matches()) {
                System.out.println("Invalid input");
                continue;
            }

            String type = matcher.group(1);
            String questionText = matcher.group(2);
            String correct = matcher.group(3);
            String student = matcher.group(4);
            double points = Double.parseDouble(matcher.group(5));

            ExamQuestion question;

            switch (type) {
                case "MCQ":
                    question = new MCQQuestion(correct, student, points);
                    break;
                case "TF":
                    question = new TrueFalseQuestion(correct, student, points);
                    break;
                default:
                    question = new EssayQuestion(correct, student, points);
            }

            double score = question.grade();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}