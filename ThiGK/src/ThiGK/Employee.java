package ThiGK;

public class Employee implements IEmployee {
	public static int employeeCount = 0;
	public int id;
	public String fullName;
	public String birthDay;
	public String phone;
	public String email;
	public String employeeType;
	
	public Employee(int id, String fullName, String birthday, String phone, String email, String employeeType) {
		this.id = id;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.employeeType = employeeType;
		++employeeCount;
	}
	
	@Override
	public void showInfo() {
		System.out.println("ID: " + id);
		System.out.println("Full name: " + fullName);
		System.out.println("Birthday: " + birthDay);
		System.out.println("Phone: " + phone);
		System.out.println("Email: " + email);
		System.out.println("Employee type: " + employeeType);
	}
	
	public static int getEmployeeCount() {
		return employeeCount;
	}

}
