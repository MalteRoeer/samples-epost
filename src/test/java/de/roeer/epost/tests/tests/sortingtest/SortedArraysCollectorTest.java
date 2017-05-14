package de.roeer.epost.tests.tests.sortingtest;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.roeer.epost.tests.tests.sorting.SortedSublistCollector;

@RunWith(MockitoJUnitRunner.class)
public class SortedArraysCollectorTest {

	private List<String> list = new ArrayList<>();

	@Mock
	private Comparator<String> comparator;

	@InjectMocks
	private SortedSublistCollector<String> collector = new SortedSublistCollector<String>();

	@Before
	public void setUp() {
		when(comparator.compare("Berlin", "Leipzig")).thenReturn(1);
		when(comparator.compare("Leipzig", "Berlin")).thenReturn(-1);

		list.add("Berlin");
		list.add("Leipzig");
	}

	@Test
	public void testSizeOfCollectedSet() {
		assertEquals(3, collector.findAllSortedSublists(list).size());
	}

	@Test
	public void testContent() {
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Berlin");
		expectedList.add("Leipzig");

		for (List<String> sublist : collector.findAllSortedSublists(list)) {
			if (sublist.size() == 2) {
				assertTrue(expectedList.equals(sublist));
			}
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFreakCase() {
		collector.findAllSortedSublists(null);
	}

}
