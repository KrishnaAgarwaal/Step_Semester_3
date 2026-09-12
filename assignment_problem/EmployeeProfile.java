package assignment_problem;

public class EmployeeProfile {

    static class Employee {

        int empId;
        String empName;
        double salary;
        boolean isIntern;

        Employee(int empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        Employee(int empId, String empName) {
            this(empId, empName, 0);
            this.isIntern = true;
        }

        void printProfile() {

            System.out.println(
                "ID: " + empId +
                " | Name: " + empName +
                " | Salary: " + salary +
                " | Intern: " + isIntern
            );
        }
    }

    public static void main(String[] args) {

        Employee permanent =
            new Employee(101, "Krishna", 60000);

        Employee intern =
            new Employee(102, "Rahul");

        permanent.printProfile();
        intern.printProfile();
    }
}