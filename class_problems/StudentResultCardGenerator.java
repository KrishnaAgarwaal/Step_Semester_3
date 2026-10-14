package class_problems;

import java.util.Arrays;

class StudentResult {
    String name;
    int[] marks;

    StudentResult(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / marks.length;
    }

    String getGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return "A";
        } else if (average >= 75) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    void printResult() {
        System.out.printf(
            "%s: Average %.1f, Grade %s%n",
            name.toUpperCase(),
            calculateAverage(),
            getGrade()
        );
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        StudentResult s1 = new StudentResult(
            "Asha", new int[]{80, 90, 70}
        );

        StudentResult s2 = new StudentResult(
            "Ravi", new int[]{60, 55, 50}
        );

        s1.printResult();
        s2.printResult();
    }
}