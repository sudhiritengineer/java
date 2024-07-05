package object;

import java.nio.charset.StandardCharsets;

/*
 * run-time polymorphism allows you to invoke an overridden method of a subclass having a reference to the base class.
 */
class File {
	protected String fullName;

	// constructor
	public File(String fullName) {
		this.fullName = fullName;
	}
	// getters and setters

	public void printFileInfo() {
		String info = this.getFileInfo(); // here is polymorphic behavior!!!
		System.out.println(info);
	}

	protected String getFileInfo() {
		return "File: " + fullName;
	}
}

class ImageFile extends File {

	protected int width;
	protected int height;
	protected byte[] content;

	// constructor
	public ImageFile(String fullName, int width, int height, byte[] content) {
		super(fullName);
		this.width = width;
		this.height = height;
		this.content = content;
	}

	// getters and setters

	@Override
	protected String getFileInfo() {
		return String.format("Image: %s, width: %d, height: %d, byteContent: %s", fullName, width, height, content);
	}

}

public class PolyMorphism {

	public static void main(String[] args) {
		File img = new ImageFile("/path/to/file/img.png", 480, 640, "temp2H@jj".getBytes(StandardCharsets.UTF_8));

		 // It prints "Image: /path/to/file/img.png, width: 480, height: 640, byteContent: [B@5594a1b5"
		img.printFileInfo();

	}

}
