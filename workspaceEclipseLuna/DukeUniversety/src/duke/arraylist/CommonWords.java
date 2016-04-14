package duke.arraylist;

/**
 * Count common words in Shakespeare's works
 * 
 * @author Duke Software Team
 * @version 1.0
 */
import edu.duke.FileResource;

// Counting with Arrays
// Шукає серед масиву слів те, що треба знайти з файлу common.txt

public class CommonWords {

	// повертає масив слів, що треба знаходити і рахувати у файлі - тексті
	public String[] getCommon() {
		FileResource resource = new FileResource("data/common.txt");
		String[] common = new String[20];
		int index = 0;
		for (String s : resource.words()) {
			common[index] = s;
			index += 1;
		}
		return common;
	}

	// повертає індекс, де знаходить слово шукане
	public int indexOf(String[] list, String word) {
		for (int k = 0; k < list.length; k++) {
			if (list[k].equals(word)) {
				return k;
			}
		}
		return -1;
	}

	// це можна викликати для обробк своїх файлів ? дописуюючи код наче у void
	// countShakespeare
	public void countWords(FileResource resource, String[] common, int[] counts) {
		for (String word : resource.words()) {
			word = word.toLowerCase();
			int index = indexOf(common, word);
			if (index != -1) {
				counts[index] += 1;
			}
		}
	}

	void countShakespeare() {
		// String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
		// "likeit.txt", "macbeth.txt", "romeo.txt"};

		String[] plays = { "small.txt" };
		String[] common = getCommon();
		int[] counts = new int[common.length];
		for (int k = 0; k < plays.length; k++) {
			FileResource resource = new FileResource("data/" + plays[k]);
			countWords(resource, common, counts);
			System.out.println("done with " + plays[k]);
		}

		for (int k = 0; k < common.length; k++) {
			System.out.println(common[k] + "\t" + counts[k]);
		}
	}
}
