package assignment_problem;

public class PayrollAccount {

    private double basicSalary;
    private double bonus;

    PayrollAccount(double basicSalary, double bonus) {

        if (basicSalary < 0) {
            System.out.println("Warning: Negative basic salary changed to 0.");
            basicSalary = 0;
        }

        if (bonus < 0) {
            System.out.println("Warning: Negative bonus changed to 0.");
            bonus = 0;
        }

        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    void creditBonus(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid bonus amount.");
            return;
        }

        bonus += amount;
    }

    void deductTax(double percentage) {

        if (percentage < 0 || percentage > 100) {
            System.out.println("Invalid tax percentage.");
            return;
        }

        basicSalary = basicSalary - (basicSalary * percentage / 100);
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        PayrollAccount account =
            new PayrollAccount(50000, 5000);

        account.creditBonus(2000);
        account.deductTax(10);

        System.out.println("Net Salary: " + account.getNetSalary());
    }
}