package assignment_problem;

public class EmployeeCompanyInfo {

    static class Employee {

        String empName;
        double salary;

        static String companyName = "Tech Solutions";
        static int employeeCount = 0;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }
    }

    static void printCompanyInfo() {

        System.out.println("Company: " + Employee.companyName);
        System.out.println("Employee Count: " + Employee.employeeCount);
    }

    public static void main(String[] args) {

        Employee e1 =
            new Employee("Krishna", 60000);

        Employee e2 =
            new Employee("Rahul", 50000);

        Employee e3 =
            new Employee("Priya", 55000);

        printCompanyInfo();
    }
}