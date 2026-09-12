package assignment_problem;

public class HallTicket {

    String studentName;
    String seatNumber;

    HallTicket(String studentName, String seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    void printTicket() {
        System.out.println(
            "Student: " + studentName +
            " | Seat: " + seatNumber
        );
    }

    public static void main(String[] args) {

        HallTicket priya =
            new HallTicket("Priya", "A101");

        HallTicket copy = priya;

        copy.seatNumber = "B202";

        priya.printTicket();

        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate =
            new HallTicket("Priya", "B202");

        System.out.println(
            "separate == priya: " + (separate == priya)
        );
    }
}