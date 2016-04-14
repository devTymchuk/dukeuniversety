package duke.solving;

import dna.CSVMax;

public class Main {

	public static void main(String[] args) {

		String s = "dukeprogramming";
		System.out.println("s.leg" + s.length());
		System.out.println(s.indexOf("g")); // 7
		System.out.println(s.indexOf("p")); // -1 never
		System.out.println(s.indexOf("g", 8)); // 14
		System.out.println(s.startsWith("duke")); // /true
		System.out.println(s.endsWith("king")); // false
		System.out.println(s.substring(4, 7));// "pro"
		System.out.println(s.toUpperCase()); // DUKEPROGRAMMI

		HelloWorld h = new HelloWorld();
		h.runHello();
		// GrayScaleConverter gray = new GrayScaleConverter();
		// gray.testGray();

		// gray.selectAndConvert();

		// ImageSaver is = new ImageSaver();
		// is.doSave();

		// URLFinder uf = new URLFinder();
		// uf.findURLs("http://www.8-nig.zzz.com.ua/");

		// CSV file
		// FirstCSVExample fcsv = new FirstCSVExample();
		// fcsv.readFood();

		// WhichCountriesExport wcountry = new WhichCountriesExport();
		// wcountry.whoExportsCoffee();

		// максимальна температура
		CSVMax tmax = new CSVMax();
		tmax.testHottestInDay();
		tmax.testHottestInManyDays();// кілька файлів оброблює

	}
}
