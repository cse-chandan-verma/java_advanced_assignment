package junittest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import junitdemo.Student;
import junitdemo.StudentService;

public class StudentSericeTest {

	Student student = new Student(1, "Chandan", 70,70,50);
	
	StudentService studentService = new StudentService();
	
	@Test
	void result() {
		assertEquals(190, studentService.calculateTotal(student));
	}
	
	@Test
	void passed() {
		assertTrue(studentService.isPassed(student));
	}
	
	
	
}
