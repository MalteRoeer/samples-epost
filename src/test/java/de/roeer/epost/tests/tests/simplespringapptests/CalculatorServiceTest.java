package de.roeer.epost.tests.tests.simplespringapptests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import de.roeer.epost.tests.tests.simplespringapp.AverageCalculator;
import de.roeer.epost.tests.tests.simplespringapp.Calculator;
import de.roeer.epost.tests.tests.simplespringapp.CalculatorService;
import de.roeer.epost.tests.tests.simplespringapp.NumberProvider;
import de.roeer.epost.tests.tests.simplespringapp.SumCalculator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class CalculatorServiceTest {

	@Autowired
	CalculatorService calculatorService;
	
	@Test
	public void testCalculation(){
		assertTrue(Math.abs(3.5 -calculatorService.calculateResultForNextNumbers())< 0.001);
	}	
	
	@Configuration
	@ComponentScan(basePackageClasses = {CalculatorService.class})
	public static class TestConfiguration{
		@Autowired
		public CalculatorService calculatorService;
		
		@Bean
		public Calculator averageCalculator(){
			return new AverageCalculator();
		}
		
		@Bean
		public NumberProvider numberProvider(){
			NumberProvider numberProvider = mock(NumberProvider.class);
		
			List<Float> numbers = new ArrayList<>();
			numbers.add((float) 2);
			numbers.add((float) 5);
			
			when(numberProvider.provideNumbers()).thenReturn(numbers);
			
			return numberProvider;
		}
	}
	
}
