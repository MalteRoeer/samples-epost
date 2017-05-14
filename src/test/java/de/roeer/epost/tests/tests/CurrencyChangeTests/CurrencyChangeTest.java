package de.roeer.epost.tests.tests.CurrencyChangeTests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import de.roeer.epost.tests.tests.currencychange.Change;
import de.roeer.epost.tests.tests.currencychange.CurrencyChange;

public class CurrencyChangeTest {

	private Change change;
	
	@Before
	public void setUpChanges(){
		change = new Change(1,2,1,0,4);		
	}
	
	@Test
	public void testCurrencyChange(){
		assertEquals(change.getDollars(), CurrencyChange.getCorrectChange(164).getDollars());
		assertEquals(change.getQuarters(), CurrencyChange.getCorrectChange(164).getQuarters());
		assertEquals(change.getDimes(), CurrencyChange.getCorrectChange(164).getDimes());
		assertEquals(change.getNickels(), CurrencyChange.getCorrectChange(164).getNickels());
		assertEquals(change.getCents(), CurrencyChange.getCorrectChange(164).getCents());
	}
	
	@Test
	public void testImpossibleCurrencyChange(){
		assertNull(CurrencyChange.getCorrectChange(-1));
	}
}
