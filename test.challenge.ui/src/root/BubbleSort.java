package root;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleSort implements ISort{

	@Override
	public void sort(List<Integer> numbers){
		for(int i = numbers.size() - 1; i >= 0; i--){
			for(int j = 0; j < i; j++){
				if(numbers.get(j) > numbers.get(j+1)){
					int oldJ = numbers.get(j);
					numbers.set(j,numbers.get(j+1));
					numbers.set(j+1,oldJ);
				}
			}
		}
	}

	@Override
	public List<Integer> createSortedArray(int minValue, int maxValue, int size) {
		List<Integer> array = new ArrayList<Integer>();
		int i = 0;
		while(i <= size){
			Random rand = new Random();
			int randomNum = rand.nextInt((maxValue - minValue) + 1) + minValue;
			array.add(randomNum);
			i++;
		}
		this.sort(array);
		return array;
	}
}
