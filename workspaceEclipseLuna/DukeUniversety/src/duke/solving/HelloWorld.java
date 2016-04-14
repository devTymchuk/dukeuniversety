package duke.solving;
import edu.duke.URLResource;

public class HelloWorld {
	public void runHello() {
		// FileResource hello =new FileResource (" h.txt");
		URLResource hello = new URLResource(
				"http://www.dukelearntoprogram.com/java/somefile.txt");
		for (String line : hello.lines()) {
			System.out.println(line);
		}
		System.out.println("for (String line : hello.words())");
		for (String line : hello.words()) {
			System.out.println(line);
		}

	}
}
