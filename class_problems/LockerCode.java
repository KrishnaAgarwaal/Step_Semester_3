package class_problems;

public class LockerCode {
    private String combination;
    private final int lockerNumber;

    public LockerCode(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combination.equals(currentCode)) {
            combination = newCode;
            return true;
        }

        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        LockerCode locker = new LockerCode(101, "1234");

        if (locker.changeCode("1234", "5678")) {
            System.out.println("Code change successful");
        } else {
            System.out.println("Code change rejected");
        }

        if (locker.changeCode("0000", "9999")) {
            System.out.println("Code change successful");
        } else {
            System.out.println("Code change rejected");
        }
    }
}