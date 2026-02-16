package collections_and_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManagement {
	
	private ArrayList<Employee> listOfEmp = new ArrayList<>();
	private List<Employee> listENames = new ArrayList<>();
	
	public void addEmp(Employee emp) {
		listOfEmp.add(emp);
	}
	
	public void displayDetails() {
		for(Employee e : listOfEmp) {
			System.out.println(e);
		}
	}
	
	public void displayAverageSalary() {
		double avgSal = listOfEmp.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
		System.out.println("Average Salary of the employees: "+ avgSal);
	}
	
	public void highestSalary() {
		double highestSal = listOfEmp.stream().mapToDouble(Employee::getSalary).max().orElse(0.0);
		System.out.println("Maximum Salary: "+highestSal);
	}
	
	
	public void higestSalarythan80000() {
		listENames = listOfEmp.stream().filter(e -> e.getSalary()>80000).collect(Collectors.toList());
		
		for(Employee e : listENames) {
			System.out.println(e.getName());
		}
	}
}
