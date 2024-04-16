package ThiGK;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileIO {
    private static final String EMPLOYEE_FILE = "employees.txt";

    public static List<Employee> readEmployeesFromFile() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(EMPLOYEE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 11) {
                    int id = Integer.parseInt(parts[0]);
                    String fullName = parts[1];
                    String birthDay = parts[2];
                    String phone = parts[3];
                    String email = parts[4];
                    String employeeType = parts[5];
                    switch (employeeType) {
                        case "Experience":
                            int expInYear = Integer.parseInt(parts[6]);
                            String proSkill = parts[7];
                            employees.add(new Experience(id, fullName, birthDay, phone, email, proSkill));
                            break;
                        case "Fresher":
                            String graduationDate = parts[6];
                            String graduationRank = parts[7];
                            String education = parts[8];
                            employees.add(new Fresher(id, fullName, birthDay, phone, email, graduationDate));
                            break;
                        case "Intern":
                            String majors = parts[6];
                            String semester = parts[7];
                            String universityName = parts[8];
                            employees.add(new Intern(id, fullName, birthDay, phone, email, majors));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading employees from file: " + e.getMessage());
        }
        return employees;
    }

    public static void writeEmployeesToFile(List<Employee> employees) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(EMPLOYEE_FILE))) {
            for (Employee employee : employees) {
                String line = formatEmployeeToString(employee);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing employees to file: " + e.getMessage());
        }
    }

    private static String formatEmployeeToString(Employee employee) {
        StringBuilder sb = new StringBuilder();
        sb.append(employee.id).append(",");
        sb.append(employee.fullName).append(",");
        sb.append(employee.birthDay).append(",");
        sb.append(employee.phone).append(",");
        sb.append(employee.email).append(",");
        sb.append(employee.employeeType);
        if (employee instanceof Experience) {
            Experience exp = (Experience) employee;
            sb.append(",").append(exp.expInYear).append(",").append(exp.proSkill);
        } else if (employee instanceof Fresher) {
            Fresher fresher = (Fresher) employee;
            sb.append(",").append(fresher.graduationDate).append(",").append(fresher.graduationRank).append(",").append(fresher.education);
        } else if (employee instanceof Intern) {
            Intern intern = (Intern) employee;
            sb.append(",").append(intern.majors).append(",").append(intern.semester).append(",").append(intern.universityName);
        }
        return sb.toString();
    }
}
