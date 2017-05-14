package de.roeer.epost.tests.tests.simplespringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	@Autowired
	private NumberProvider numberProvider;
	
	@Autowired
	private Calculator calculator;
	
	public float calculateResultForNextNumbers(){
		return calculator.calculate(numberProvider.provideNumbers());
	}

	public NumberProvider getNumberProvider() {
		return numberProvider;
	}

	public void setNumberProvider(NumberProvider numberProvider) {
		this.numberProvider = numberProvider;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
}
