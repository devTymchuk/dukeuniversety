package duke.solving;
import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

public class GrayScaleConverter {

	public ImageResource makeGray(ImageResource inImage) {
		ImageResource outImage = new ImageResource(inImage.getWidth(),
				inImage.getHeight());
		for (Pixel pixel : outImage.pixels()) {
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			int avarege = (inPixel.getRed() + inPixel.getBlue() + inPixel
					.getGreen()) / 3;
			pixel.setRed(avarege);
			pixel.setBlue(avarege);
			pixel.setGreen(avarege);

		}
		return outImage;
	}

	public void testGray() {
		ImageResource ir = new ImageResource();
		ImageResource gray = makeGray(ir);
		gray.draw();
	}

	public void selectAndConvert() {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			ImageResource inImage = new ImageResource(f);
			ImageResource gray = makeGray(inImage);
			gray.draw();
		}
	}
}
