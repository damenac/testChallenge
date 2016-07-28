package test.root;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import root.BubbleSort;

public class BubbleSortTest {

	private List<Integer> scenario1;
	private BubbleSort sort;
	
	@Before
	public void loadScenarios(){
		scenario1 = new ArrayList<Integer>();
		int scenario1Size = 10000;
		
		int i = 0;
		while(i <= scenario1Size){
			int localNumber = 0 + (int)(Math.random() * 100);
			scenario1.add(localNumber);
			i++;
		}
		
		sort = new BubbleSort();
	}
	
	@Test(timeout=1000)
	public void testSort(){
		sort.sort(scenario1);
		for (int i = 0; i < scenario1.size() - 1; i++) {
			Assert.assertTrue("Positions <" + i + "," + (i+1) + ">", 
					scenario1.get(i) <= scenario1.get(i + 1));
		}
	}
}
