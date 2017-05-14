package de.roeer.epost.tests.tests.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortedSublistCollector<T> {

	private Comparator<T> comparator;
	     
     public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public Set<List<T>> findAllSortedSublists(List<T> list){
    	  
    	 if(list==null){
    		 throw new IllegalArgumentException("Do not pass null as parameter");
    	 }
    	 
    	 Set<List<T>> sortedArrays = new HashSet<List<T>>();
    	 
    	 for(T element : list){
    		 List<T> temp = new ArrayList<T>(list);
    		 temp.remove(element);
    		 
    		 Set<List<T>> recursivelyDefinedSetOfOrderedSublists = findAllSortedSublists(temp);
    		 sortedArrays.addAll(recursivelyDefinedSetOfOrderedSublists);
    		 sortedArrays.addAll(findListOfOrderedSublistsWithElementAsFirstEntry(element, recursivelyDefinedSetOfOrderedSublists));    		 
    	 }
    	 
    	 return sortedArrays;
     }

	private List<List<T>> findListOfOrderedSublistsWithElementAsFirstEntry(T element, Set<List<T>> recursivelyDefinedSetOfOrderedSublists) {
		List<List<T>> temp = new ArrayList<List<T>>();
		
		if(recursivelyDefinedSetOfOrderedSublists.size()==0){
			List<T> oneElementList = new ArrayList<T>();
			oneElementList.add(element);
			temp.add(oneElementList);
			return temp;
		}
		
		for(List<T> orderedSublist : recursivelyDefinedSetOfOrderedSublists){
			 if(comparator.compare(element, orderedSublist.get(0))>=0){
			 
			  orderedSublist.add(0,element);
			  temp.add(orderedSublist);
			 }
		 }
		return temp;
	}

}