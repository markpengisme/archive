package ch09;
// 4. Enhanced loop
import java.util.ArrayList;

public class TestEnhancedLoop {

	public static void main(String[] args) {
		enhancedLoopArray();
		enhancedLoopArrayList();
	}
	
	public static void enhancedLoopArray() {
		int[] intArray = { 12, 23, 45, 3, 67, 34, 87, 96, 89 };
		for (int element : intArray) {
			System.out.println(element);
		}
		System.out.println("-----");
		String[] names = { "jim", "bill", "albert", "sue", "mary", "elsa" };
		for (String name : names) {
			System.out.println(name);
		}

	}

	public static void enhancedLoopArrayList() {
		ArrayList<String> names = new ArrayList<>();
		names.add("jim");
		names.add("bill");
		names.add("albert");
		names.add("sue");
		names.add("mary");
		names.add("elsa");
		for (String name : names) {
			System.out.println(name);
		}
	}

}
