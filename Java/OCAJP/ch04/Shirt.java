package ch04;

public class Shirt {
    public int size;
    public double price = 100.5;
    public double getPrize() {
        return price;
    }
    public void display() {
        System.out.println("size = " + size);
		System.out.println("price = " + price);
    }
}
