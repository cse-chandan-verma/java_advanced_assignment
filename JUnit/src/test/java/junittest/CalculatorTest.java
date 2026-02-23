package junittest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import junitdemo.Calculator;

public class CalculatorTest {
	
	private Calculator cal;
	
	@BeforeEach
	void setUp() {
		cal = new Calculator();
	}
	
	@Test
	public void testTwoAndTwoGivesFour() {
		assertEquals(4, cal.sum(2, 2));
		
	}

	@Test
	public void testTwoAdnFourGivesSix() {
		assertEquals(6, cal.subtract(10, 4));
		  
	}
	
	@RepeatedTest(3)
	void testSumRepeated() {
		assertEquals(10, cal.sum(5,  5));
	}
	
	@Nested
	class SubtractionTests {
		@Test
		void testSubtraction() {
			assertEquals(1, cal.subtract(5, 4));
		}
		
		@Test
		void testSum() {
			assertEquals(10, cal.sum(5, 5));
		}
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5})
	void testMultiplyByTwo(int number) {
		assertEquals(number * 2, cal.multiply(number, 2));
	}
	
	@ParameterizedTest
	@CsvSource({"2,2,4", "2,3,6","4,4,16"})
	void testMultiply(int x, int y, int expected) {
		assertEquals(expected, cal.multiply(x,  y));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/cal-data.csv", numLinesToSkip = 1)
	void testSumUsingCsvFile(int a, int b, int expectedSum) {
		assertEquals(expectedSum, cal.sum(a, b));
	}
	
	
}
