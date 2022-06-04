package ch13;
// 3.1 precise catch
import java.io.File;
import java.io.IOException;

public class IOExceptionDemo {
	public static void main(String args[]) {
		try {
			testCheckedException();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void testCheckedException() throws IOException {
		String path = System.getProperty("user.dir") + "/ch13/temp/";
		System.out.println(path);
		File f = new File(path + "test.txt");
		f.createNewFile();
		System.out.println("File is created? " + f.exists());
	}

}
