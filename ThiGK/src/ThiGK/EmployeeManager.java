package ThiGK;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private static List<Employee> employees = new ArrayList<>();

    public static void createEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("New employee added: ");
        employee.showInfo();
    }

    public static void readEmployee(int id) {
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.id == id) {
                employee.showInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void updateEmployee(int id, Employee updatedEmployee) {
        boolean found = false;
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.id == id) {
                employees.set(i, updatedEmployee);
                System.out.println("Employee with ID " + id + " updated:");
                updatedEmployee.showInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void deleteEmployee(int id) {
        boolean found = false;
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.id == id) {
                employees.remove(i);
                System.out.println("Employee with ID " + id + " deleted.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
}
