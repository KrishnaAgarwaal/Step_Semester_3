package class_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanDays();

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26)
                        .plusDays(getLoanDays());
    }
}

class BookItem extends LibraryItem {
    BookItem(String title) {
        super(title);
    }

    int getLoanDays() {
        return 14;
    }
}

class DVDItem extends LibraryItem {
    DVDItem(String title) {
        super(title);
    }

    int getLoanDays() {
        return 7;
    }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title) {
        super(title);
    }

    int getLoanDays() {
        return 3;
    }
}

public class LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1)
                               .replace("\"", "");

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new BookItem(title);
                    break;
                case "DVD":
                    item = new DVDItem(title);
                    break;
                default:
                    item = new MagazineItem(title);
            }

            System.out.println(
                item.title + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}