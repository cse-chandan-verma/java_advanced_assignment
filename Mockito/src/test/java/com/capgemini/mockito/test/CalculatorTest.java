package com.capgemini.mockito.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import com.capgemini.mockito.Calculator;
import com.capgemini.mockito.MathService;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
	@Mock
	MathService mathService;
	@InjectMocks
	Calculator calculator;
	
	@Test
	void testAdd() {
		when(mathService.sum(10, 20)).thenReturn(30);
		assertEquals(30, calculator.add(20, 10));
		verify(mathService).sum(10, 20);
	}
}


