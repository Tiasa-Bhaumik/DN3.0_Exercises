package employeemanagement;

import java.util.Arrays;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    // Constructor
    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add Employee
    public void addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Employee list is full.");
            return;
        }
        employees[size++] = employee;
    }

    // Search Employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse Employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee by ID
    public void deleteEmployee(int employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete != -1) {
            for (int i = indexToDelete; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--size] = null; // Clear the last element
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        ems.addEmployee(new Employee(1, "Alice", "Manager", 70000));
        ems.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        ems.addEmployee(new Employee(3, "Charlie", "Analyst", 50000));

        System.out.println("All Employees:");
        ems.traverseEmployees();

        System.out.println("Searching for Employee with ID 2:");
        System.out.println(ems.searchEmployee(2));

        System.out.println("Deleting Employee with ID 2.");
        ems.deleteEmployee(2);

        System.out.println("All Employees after deletion:");
        ems.traverseEmployees();
    }
}
