package duke.solving;

/**
 * Finds a protein within a strand of DNA represented as a string of c,g,t,a letters.
 * A protein is a part of the DNA strand marked by start and stop codons (DNA triples)
 * that is a multiple of 3 letters long.
 *
 * @author Duke Software Team 
 */
import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.StorageResource;

public class TagFinder2 {

	public String findProtein(String dna) {
		int start = dna.indexOf("atg");
		if (start == -1) {
			return "";
		}
		int stop = dna.indexOf("tag", start + 3);
		if ((stop - start) % 3 == 0) {
			return dna.substring(start, stop + 3);
		} else {
			return "";
		}
	}

	public void testing() {
		String a = "cccatggggtttaaataataataggagagagagagagagttt";
		String ap = "atggggtttaaataataatag";
		// String a = "atgcctag";
		// String ap = "";
		// String a = "ATGCCCTAG";
		// String ap = "ATGCCCTAG";
		String result = findProtein(a);
		if (ap.equals(result)) {
			System.out.println("success for " + ap + " length " + ap.length());
		} else {
			System.out.println("mistake for input: " + a);
			System.out.println("got: " + result);
			System.out.println("not: " + ap);
		}
	}

	public void realTesting() {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			String s = fr.asString();
			System.out.println("read " + s.length() + " characters");
			String result = findProtein(s);
			System.out.println("found " + result);
		}
	}

	// my exp
	public void printAllStarts(String dna) {
		int start = 0;
		while (true) {
			int loc = dna.indexOf("atg", start);
			if (loc == -1) {
				break;
			}
			System.out.println("starts at " + loc);
			start = loc + 3;
		}
	}

	public int findStopIndex(String dna, int index) {
		int stop1 = dna.indexOf("tga", index);
		if (stop1 == -1 || (stop1 - index) % 3 != 0) {
			stop1 = dna.length();
		}
		int stop2 = dna.indexOf("taa", index);
		if (stop2 == -1 || (stop2 - index) % 3 != 0) {
			stop2 = dna.length();
		}
		int stop3 = dna.indexOf("tag", index);
		if (stop3 == -1 || (stop3 - index) % 3 != 0) {
			stop3 = dna.length();
		}
		return Math.min(stop1, Math.min(stop2, stop3));
	}

	public void printAll(String dna) {
		int start = 0;
		while (true) {
			int tag = dna.indexOf("atg", start);
			if (tag == -1) {
				break;
			}
			int end = findStopIndex(dna, tag + 3);
			if (end != dna.length()) {
				System.out.println(dna.substring(tag, end + 3));
				start = end + 3;
			} else {
				start = tag + 3;
			}
		}

	}

	public void printGenes(StorageResource sr) {
		for (String gene : sr.data()) {
			if (gene.length() > 60) {
				System.out.println(gene.length() + "\t" + gene);
			}
		}
	}

	public StorageResource getWords() {
		FileResource fr = new FileResource("data/confucius.txt");
		StorageResource store = new StorageResource();
		for (String w : fr.words()) {
			if (!store.contains(w)) {
				store.add(w);
			}
		}
		return store;
	}

	public void uniqueWord() {
		FileResource fr = new FileResource("/datasolv/confucius.txt");
		StorageResource unique = new StorageResource();
		for (String w : fr.words()) {
			if (!unique.contains(w)) {
				unique.add(w);
			}
		}
		System.out.println("number of unique words" + unique.size());
	}
}
