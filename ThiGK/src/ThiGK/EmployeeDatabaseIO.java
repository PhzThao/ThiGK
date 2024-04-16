package ThiGK;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabaseIO {
    private static final String URL = "jdbc:mysql://localhost:127.0.0.1:3306/Employee";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "181125";

    public static List<Employee> readEmployeesFromDatabase() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                String birthDay = resultSet.getString("birth_day");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String employeeType = resultSet.getString("employee_type");
                switch (employeeType) {
                    case "Experience":
                        int expInYear = resultSet.getInt("exp_in_year");
                        String proSkill = resultSet.getString("pro_skill");
                        employees.add(new Experience(id, fullName, birthDay, phone, email, expInYear, proSkill));
                        break;
                    case "Fresher":
                        String graduationDate = resultSet.getString("graduation_date");
                        String graduationRank = resultSet.getString("graduation_rank");
                        String education = resultSet.getString("education");
                        employees.add(new Fresher(id, fullName, birthDay, phone, email, graduationDate, graduationRank, education));
                        break;
                    case "Intern":
                        String majors = resultSet.getString("majors");
                        String semester = resultSet.getString("semester");
                        String universityName = resultSet.getString("university_name");
                        employees.add(new Intern(id, fullName, birthDay, phone, email, majors, semester, universityName));
                        break;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error reading employees from database: " + e.getMessage());
        }
        return employees;
    }

    public static void writeEmployeesToDatabase(List<Employee> employees) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            for (Employee employee : employees) {
                String sql = "INSERT INTO employees (id, full_name, birth_day, phone, email, employee_type, exp_in_year, pro_skill, graduation_date, graduation_rank, education, majors, semester, university_name) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, employee.id);
                statement.setString(2, employee.fullName);
                statement.setString(3, employee.birthDay);
                statement.setString(4, employee.phone);
                statement.setString(5, employee.email);
                statement.setString(6, employee.employeeType);
                if (employee instanceof Experience) {
                    Experience exp = (Experience) employee;
                    statement.setInt(7, exp.expInYear);
                    statement.setString(8, exp.proSkill);
                    statement.setNull(9, Types.VARCHAR);
                    statement.setNull(10, Types.VARCHAR);
                    statement.setNull(11, Types.VARCHAR);
                    statement.setNull(12, Types.VARCHAR);
                    statement.setNull(13, Types.VARCHAR);
                    statement.setNull(14, Types.VARCHAR);
                } else if (employee instanceof Fresher) {
                    Fresher fresher = (Fresher) employee;
                    statement.setNull(7, Types.INTEGER);
                    statement.setNull(8, Types.VARCHAR);
                    statement.setString(9, fresher.graduationDate);
                    statement.setString(10, fresher.graduationRank);
                    statement.setString(11, fresher.education);
                    statement.setNull(12, Types.VARCHAR);
                    statement.setNull(13, Types.VARCHAR);
                    statement.setNull(14, Types.VARCHAR);
                } else if (employee instanceof Intern) {
                    Intern intern = (Intern) employee;
                    statement.setNull(7, Types.INTEGER);
                    statement.setNull(8, Types.VARCHAR);
                    statement.setNull(9, Types.VARCHAR);
                    statement.setNull(10, Types.VARCHAR);
                    statement.setNull(11, Types.VARCHAR);
                    statement.setString(12, intern.majors);
                    statement.setString(13, intern.semester);
                    statement.setString(14, intern.universityName);
                }
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error writing employees to database: " + e.getMessage());
        }
    }
}