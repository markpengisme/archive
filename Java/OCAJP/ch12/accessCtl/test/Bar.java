package ch12.accessCtl.test;
// 3. protected and default access control difference
import ch12.accessCtl.demo.Foo;

public class Bar extends Foo {
	private int sum = 10;

	public void reportSum() {
		sum += result; // OK
		// sum += other; // NG
		System.out.println(this.sum);
	}

	public static void main(String[] args) {
		Bar bar = new Bar();
		bar.reportSum();
	}
}
