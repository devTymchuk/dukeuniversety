/**
 * Reads a chosen CSV file of our preferences and prints each field.
 * 
 * @author Duke Software Team
 */
//

package duke.solving;

//обробляє данні з таблиці
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class FirstCSVExample {
	public void readFood() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		for (CSVRecord record : parser) {
			System.out.print(record.get("Name") + " ");
			System.out.print(record.get("Favorite Color") + " ");
			System.out.println(record.get("Favorite Food"));
		}
	}
}
