package collections_and_streams;

public class JavaApplication {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Chandan", 10, "Technical", "Software Developer", 55000, 1);
		Employee e2 = new Employee(2, "Amit", 20, "Technical", "Software Engineer", 42000, 2);
		Employee e3 = new Employee(3, "Priya", 30, "Finance", "Accountant", 48000, 3);
		Employee e4 = new Employee(4, "Rahul", 10, "Technical", "Backend Developer", 60000, 1);
		Employee e5 = new Employee(5, "Sneha", 40, "Marketing", "Digital Marketer", 85000, 4);
		Employee e6 = new Employee(6, "Arjun", 10, "Technical", "QA Engineer", 90000, 1);

		EmployeeManagement HR = new EmployeeManagement();
		
		HR.addEmp(e1);
		HR.addEmp(e2);
		HR.addEmp(e3);
		HR.addEmp(e4);
		HR.addEmp(e5);
		HR.addEmp(e6);
		
		HR.displayDetails();
		
		HR.displayAverageSalary();
		
		HR.highestSalary();
		
		HR.higestSalarythan80000();
	}
}
