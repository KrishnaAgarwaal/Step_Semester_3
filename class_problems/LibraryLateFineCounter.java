package class_problems;

import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class BookFine extends LibraryItem {
    BookFine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDFine extends LibraryItem {
    DVDFine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineFine extends LibraryItem {
    MagazineFine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LibraryItem[] items = new LibraryItem[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            switch (type) {
                case "BOOK":
                    items[i] = new BookFine(title, days);
                    break;
                case "DVD":
                    items[i] = new DVDFine(title, days);
                    break;
                case "MAGAZINE":
                    items[i] = new MagazineFine(title, days);
                    break;
            }
        }

        for (LibraryItem item : items) {
            double fine = item.calculateFine();

            System.out.printf("%s: %.2f%n", item.title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}