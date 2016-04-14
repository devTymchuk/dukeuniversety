/**
 * Print the names of all files selected within a directory (or folder).
 * 
 * @author Duke Software Team 
 */
package duke.solving;

import java.io.File;

import edu.duke.DirectoryResource;

public class DirReader {
	public void checkDir() {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			System.out.println(f);
		}
	}
}
