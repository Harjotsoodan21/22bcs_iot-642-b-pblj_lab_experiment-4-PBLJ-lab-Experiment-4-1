Experiment 4.1: Employee Management System

The Employee Management System is a simple Java-based application that uses ArrayList to manage employee records. The system allows users to perform the following operations:

Add Employee → Store Employee ID, Name, and Salary.

Update Employee → Modify employee details based on their ID.

Remove Employee → Delete an employee using their ID.

Search Employee → Find employees by ID or Name.

Display All Employees → Show a complete list of employees.

Test Cases

Test Case 1: Adding Employees (No Employees Initially)
Display Employees
Expected Output:
No employees found.
  
Test Case 2: Add Employees
Input:
Add Employee (ID=101, Name="Anish", Salary=50000)
Add Employee (ID=102, Name="Bobby", Salary=60000)
Expected Output:
Employee Added: ID=101, Name=Anish, Salary=50000
Employee Added: ID=102, Name=Bobby, Salary=60000

Test Case 3: Update Employee Salary
Input:
Update Employee (ID=101, New Salary=55000)
Expected Output:
Employee ID 101 updated successfully.

Test Case 4: Search Employee by ID
Input:
Search Employee by ID=102
Expected Output:
Employee Found: ID=102, Name=Bobby, Salary=60000

Test Case 5: Remove Employee
Input:
Remove Employee (ID=101)
Expected Output:
Employee ID 101 removed successfully.

Test Case 6: Display All Employees
Input:
Display Employees
Expected Output:
ID: 102, Name: Bobby, Salary: 60000

Test Case 7: Adding Duplicate Employee ID
Input:
Add Employee (ID=101, Name="Charlie", Salary=70000)
Expected Output:
Error: Employee with ID 101 already exists.
  program code :
  import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeManagementSystem {

    static class Employee {
        private int id;
        private String name;
        private double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
        }
    }

    private ArrayList<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(int id, String name, double salary) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Error: Employee with ID " + id + " already exists.");
                return;
            }
        }
        Employee newEmployee = new Employee(id, name, salary);
        employees.add(newEmployee);
        System.out.println("Employee Added: " + newEmployee);
    }

    public void updateEmployeeSalary(int id, double newSalary) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setSalary(newSalary);
                System.out.println("Employee ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Error: Employee with ID " + id + " not found.");
    }

    public void removeEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                System.out.println("Employee ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Error: Employee with ID " + id + " not found.");
    }

    public void searchEmployee(String searchValue) {
        boolean found = false;
        for (Employee employee : employees) {
            if (String.valueOf(employee.getId()).equals(searchValue) || employee.getName().equalsIgnoreCase(searchValue)) {
                System.out.println("Employee Found: " + employee);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employee found with the given ID or Name.");
        }
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        system.displayAllEmployees();

        system.addEmployee(101, "Gahan", 900000);
        system.addEmployee(102, "Messi", 600000);

        system.updateEmployeeSalary(101, 955000);

        system.searchEmployee("102");

        system.removeEmployee(101);

        system.displayAllEmployees();

        system.addEmployee(101, "Ronaldo", 50000);
    }
}


