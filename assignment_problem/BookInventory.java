package assignment_problem;

public class BookInventory {

    String title;
    String author;
    int copiesAvailable;

    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(
            "Title: " + title +
            " | Author: " + author +
            " | Copies: " + copiesAvailable
        );
    }

    public static void main(String[] args) {

        BookInventory[] books = {
            new BookInventory("Java Basics", "James", 5),
            new BookInventory("Data Structures", "Robert", 3),
            new BookInventory("Clean Code", "Martin", 7),
            new BookInventory("OOP Concepts", "John", 4)
        };

        for (int i = 0; i < books.length; i++) {
            books[i].printEntry();
        }
    }
}