package ch09;
// 1. while
public class MyElevator2 {
	public final int MAX_FLOOR = 10;
	public final int MIN_FLOOR = 1;
	public boolean open = false;
	public int currentFloor = MIN_FLOOR;

	// 電梯 開門
	public void open() {
		if (open) {
			System.out.println("NG!! Door is opened and can't open again!!");
		} else {
			System.out.println("Try to open door,");
			open = true;
			System.out.println("Door is open now.");
		}
	}

	// 電梯關門
	public void close() {
		if (!open) {
			System.out.println("NG!! Door is closed and can't close again!!");
		} else {
			System.out.println("Try to close door,");
			open = false;
			System.out.println("Door is closed now.");
		}
	}

	// 電梯 上樓
	public void up() {
		if (currentFloor >= MAX_FLOOR) {
			System.out.println("NG!!, this is " + currentFloor + " and can't go up!!");
		} else {
			if (open) {
				System.out.println("NG!! Door is opened and must close before go up!!");
			} else {
				System.out.println("Elevator up...");
				currentFloor++;
				System.out.println("Now " + currentFloor);
			}
		}
	}

	// 電梯下樓
	public void down() {
		if (currentFloor <= MIN_FLOOR) {
			System.out.println("NG!!, this is " + currentFloor + " and can't go down!!");
		} else {
			if (open) {
				System.out.println("NG!! Door is opened and must close before go down!!");
			} else {
				System.out.println("Elevator down...");
				currentFloor--;
				System.out.println("Now " + currentFloor);
			}
		}
	}
	
	public void toFloor(int targetFloor) {
		while (currentFloor != targetFloor) {
			if (currentFloor < targetFloor) {
				up();
			} else {
				down();
			}
		}
	}


}