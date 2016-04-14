package duke.arraylist;

/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.HashMap;

import edu.duke.FileResource;

public class LogAnalyzer {
	private ArrayList<LogEntry> records;

	public LogAnalyzer() {
		// complete constructor
		records = new ArrayList<LogEntry>();
	}

	public void readFile(String filename) {
		// complete method
		FileResource fr = new FileResource();
		for (String line : fr.lines()) {
			LogEntry le = WebLogParser.parseEntry(line);
			records.add(le);
		}
	}

	public int countUniqueIPs() {
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		for (LogEntry le : records) {
			String ipAdr = le.getIpAddress();
			if (!uniqueIPs.contains(ipAdr)) {
				uniqueIPs.add(ipAdr);
			}
		}
		return uniqueIPs.size();
	}

	public void printAll() {
		for (LogEntry le : records) {
			System.out.println(le);
		}
	}

	public HashMap<String, Integer> countVisitsPerIP() {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		for (LogEntry le : records) {
			String ip = le.getIpAddress();
			if (!counts.containsKey(ip)) {
				counts.put(ip, 1);
			} else {
				counts.put(ip, counts.get(ip) + 1);
			}
		}
		return counts;
	}
}
