package ch07;
// 1
public class MyElevatorTest {
	public static void main(String args[]) {
		MyElevator1 test = new MyElevator1();
		test.open();
		test.close();
		test.down();	// Floor is 0?!
		test.up();
		test.up();
		test.up();
		test.open();
		test.close();
		test.down();
		test.open();
		test.down();
		test.open();	//open twice?!
	}
}