package duke.arraylist;

import java.util.HashMap;

/*
 * Tanya
 */
public class CountTester {
	public void testCount() {
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("short-test_log");
		HashMap<String, Integer> counts = la.countVisitsPerIP();
		System.out.println(counts);
	}
}