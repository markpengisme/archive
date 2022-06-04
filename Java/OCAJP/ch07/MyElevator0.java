package ch07;
// 0
public class MyElevator0 {
	public final int MAX_FLOOR = 10;
	public final int MIN_FLOOR = 1;
	public boolean open = false;
	public int currentFloor = MIN_FLOOR;

	//電梯 開門
	public void open() {
		System.out.println("Try to open door,");
		open = true;
		System.out.println("Door is open now.");
	}
	//電梯關門
	public void close() {
		System.out.println("Try to close door,");
		open = false;
		System.out.println("Door is closed now.");
	}
	//電梯 上樓
	public void up() {
		System.out.println("Elevator up...");
		currentFloor++;
		System.out.println("Now " + currentFloor + ".");
	}
	//電梯下樓
	public void down() {
		System.out.println("Elevator down...");
		currentFloor--;
		System.out.println("Now " + currentFloor + ".");
	}

}
