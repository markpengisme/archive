package ch08;
// 5
import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList<String> myList = new ArrayList<>();
		
		myList.add("S1");
		myList.add("S2");
		myList.add("S3");
		myList.add("S4");

		myList.remove(0);
		myList.remove(myList.size()-1);
		myList.remove("S3");
		
		System.out.println(myList);

	}

}
