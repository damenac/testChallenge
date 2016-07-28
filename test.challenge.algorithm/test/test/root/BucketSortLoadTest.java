package test.root;

import test.root.utils.JUnitPerfAdaptor;
import junit.framework.Test;

import com.clarkware.junitperf.ConstantTimer;
import com.clarkware.junitperf.LoadTest;
import com.clarkware.junitperf.Timer;

public class BucketSortLoadTest {

	public static Test loadTest() {
		long maxTime = 1000;
		int users = 10;
		
		Timer timer = new ConstantTimer(maxTime);
		
		JUnitPerfAdaptor factory = new JUnitPerfAdaptor(BucketSortTest.class);
		Test testCase = factory.makeTestSuite();
		Test tiempoMaximoTest = new LoadTest(testCase, users, timer);
		return tiempoMaximoTest;
	}

	/**
	 * Running the execution of the test case according to the load restrictions. 
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(loadTest());
	}
}
