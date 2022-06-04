package ch13;
// 3.3 multi catch
import java.io.File;
import java.io.IOException;

public class MultiExceptionDemo {
	public static void main(String args[]) {
		try {
			createTempFile();
		} catch (IOException ioe) {
			System.out.println(ioe);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.out.println(aiobe);
		} catch (SecurityException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void createTempFile() throws IOException {
		String path = System.getProperty("user.dir") + "/ch13/temp/";
		File f = new File(path);
		File tf = File.createTempFile("ji", null, f);
		System.out.println("Temp file name: " + tf.getPath());
		int arr[] = new int[5];
		arr[5] = 25;
	}

}
