package ch13;
// 3.2 imprecise catch
import java.io.File;
import java.io.IOException;

public class BadPractice {
	public static void main(String args[]) {
		try {
			testCheckedException();
		} catch (Exception e) {
			System.out.println("Failed as creating file!!");
		}
	}

	public static void testCheckedException() throws IOException {
		String path = System.getProperty("user.dir") + "/ch13/temp/";
		File f = new File(path + "test.txt");
		f.createNewFile();
		System.out.println("File is created? " + f.exists());
		// deal with another logic
		int[] array = new int[4];
		array[4] = 100;
	}

}
