package ThiGK;

public class Experience extends Employee {
	
	int expInYear;
	String proSkill;

	public Experience(int id, String fullName, String birthday, String phone, String email, String employeeType) {
		super(id, fullName, birthday, phone, email, "Experience");
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Experience in Year: " + expInYear);
		System.out.println("Professional Skill: " + proSkill);
	}

}
