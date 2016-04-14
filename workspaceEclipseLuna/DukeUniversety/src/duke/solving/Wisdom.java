/**
 * Print the line that contains the first occurrence of the word "wisdom" in the given text file.
 *
 * @author Duke Software Team 
 */
package duke.solving;

import edu.duke.FileResource;

//  Шукає слово "wisdom" у файлі "data/confucius.txt"
public class Wisdom {
	public void findWisdom() {
		FileResource fr = new FileResource("data/confucius.txt");
		for (String l : fr.lines()) {
			if (l.contains("wisdom")) {
				System.out.println(l);
				break;
			}
		}
	}
}
