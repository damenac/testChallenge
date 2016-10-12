package root;

import java.util.List;

public interface ISort {

	/**
	 * Creates and returns an array of numbers whose values are within the given interval and with the given size. 
	 * @param minValue
	 * @param maxValue
	 * @param size
	 * @return
	 */
	public List<Integer> createSortedArray(int minValue, int maxValue, int size);
	
	/**
	 * Sorts the list of integers given in the parameter.
	 * @param numbers
	 */
	public void sort(List<Integer> numbers);
}
