package de.roeer.epost.tests.tests.simplespringapp;

import java.util.List;

public class SumCalculator implements Calculator {

	@Override
	public float calculate(List<Float> numbers) {
         if(numbers==null){
        	 throw new RuntimeException("Do not pass null");
         }
         float ret = 0;
         for(Float number : numbers){
        	 ret= ret + number;
         }
         return ret;
	}
	

}
