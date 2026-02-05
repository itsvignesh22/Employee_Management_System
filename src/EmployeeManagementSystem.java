import java.time.LocalDate;
import java.util.*;

public class EmployeeManagementSystem {
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Employee> loaded = EmployeeFileHandler.loadFromFile();
        if (loaded != null) employees = loaded;

        while (true) {
            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Generate Reports");
            System.out.println("7. Save to File");
            System.out.println("8. Load from File");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> EmployeeReportGenerator.generateDepartmentReport(employees);
                case 7 -> EmployeeFileHandler.saveToFile(employees);
                case 8 -> employees = Optional.ofNullable(EmployeeFileHandler.loadFromFile()).orElse(employees);
                case 9 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Position: ");
        String pos = sc.nextLine();
        System.out.print("Enter Salary: ");
        double sal = sc.nextDouble();
        sc.nextLine();

        Employee emp = new Employee(id, name, dept, pos, sal, LocalDate.now());
        employees.add(emp);
        System.out.println("Employee added successfully!");
    }

    private static void viewEmployees() {
        System.out.println("\nID\tName\tDepartment\tPosition\tSalary\tJoin Date");
        for (Employee e : employees) {
            System.out.println(e.getId() + "\t" + e.getName() + "\t" + e.getDepartment() + "\t" +
                    e.getPosition() + "\t₹" + e.getSalary() + "\t" + e.getJoinDate());
        }
    }

    private static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) {
                System.out.println("Found: " + e.getName() + ", " + e.getDepartment());
                return;
            }
        }
        System.out.println("Employee not found");
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        String id = sc.nextLine();
        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) {
                System.out.print("New Salary: ");
                e.setSalary(sc.nextDouble());
                sc.nextLine();
                System.out.println("Employee updated");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String id = sc.nextLine();
        employees.removeIf(e -> e.getId().equalsIgnoreCase(id));
        System.out.println("Employee deleted if existed");
    }

}