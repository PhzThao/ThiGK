package ThiGK;

public class Intern extends Employee {
    String majors;
    String semester;
    String universityName;

    public Intern(int id, String fullName, String birthDay, String phone, String email, String majors, String semester, String universityName) {
        super(id, fullName, birthDay, phone, email, "Intern");
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Majors: " + majors);
        System.out.println("Semester: " + semester);
        System.out.println("University Name: " + universityName);
    }
}
