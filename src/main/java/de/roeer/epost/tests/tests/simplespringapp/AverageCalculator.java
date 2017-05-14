package de.roeer.epost.tests.tests.simplespringapp;

import java.util.List;

public class AverageCalculator implements Calculator {

	@Override
	public float calculate(List<Float> numbers) {
        if(numbers == null || numbers.size()==0){
        	throw new RuntimeException("Do not pass null or empty list");
        }
        float ret = 0;
        int size = numbers.size();
        for(Float number : numbers){
        	ret = ret + number;
        }        
        return ret/size;
	}

}
