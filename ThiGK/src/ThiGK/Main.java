package ThiGK;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Thêm mới nhân viên
        Experience experience = new Experience(1, "John Doe", "1990-01-01", "123456789", "john.doe@example.com", "Java, Spring");
        EmployeeManager.createEmployee(experience);

        Fresher fresher = new Fresher(2, "Jane Smith", "1995-05-15", "987654321", "jane.smith@example.com", "2022-05-15", "Excellent", "University of Example");
        EmployeeManager.createEmployee(fresher);

        Intern intern = new Intern(3, "Bob Johnson", "2000-09-01", "456789123", "bob.johnson@example.com", "Computer Science", "Spring 2023", "University of Example");
        EmployeeManager.createEmployee(intern);

        // Đọc thông tin nhân viên
        EmployeeManager.readEmployee(1);
        EmployeeManager.readEmployee(2);
        EmployeeManager.readEmployee(3);

        // Cập nhật thông tin nhân viên
        Fresher updatedFresher = new Fresher(2, "Jane Smith", "1995-05-15", "987654321", "jane.smith@example.com", "2022-05-15", "Good", "University of Example");
        EmployeeManager.updateEmployee(2, updatedFresher);

        // Xóa nhân viên
        EmployeeManager.deleteEmployee(1);

        // Đọc/ghi thông tin nhân viên từ/vào file
        List<Employee> employees = EmployeeFileIO.readEmployeesFromFile();
        for (Employee employee : employees) {
            employee.showInfo();
        }
        EmployeeFileIO.writeEmployeesToFile(employees);

        // Đọc/ghi thông tin nhân viên từ/vào database
        List<Employee> employeesFromDB = EmployeeDatabaseIO.readEmployeesFromDatabase();
        for (Employee employee : employeesFromDB) {
            employee.showInfo();
        }
        EmployeeDatabaseIO.writeEmployeesToDatabase(employeesFromDB);
    }
}
