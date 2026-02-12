package junitdemo;

public class StudentService {
	
	public int calculateTotal(Student s) {
		return s.getMark1() + s.getMark2() + s.getMark3();
	}
	
	public double calculateAverage(Student s) {
		int total = calculateTotal(s);
		
		return (double)total/3;
	}
	
	public boolean isPassed(Student s) {
		return calculateAverage(s) >= 40;
	}
	
}
