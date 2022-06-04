package ch05;

public class BinaryLiteralsDemo {

	public static void main(String[] args) {
		
		byte b1 = 2;
		
		byte b2 = 0b10; 
		// = 2*1 + 1*0 = 2
		
		byte b3 = 0b101011;
		// = 32*1 + 16*0 + 8*1 + 4*0 + 2*1 + 1*1 = 43

		System.out.println(b1 + ", " + b2 + ", " + b3);

	}

}
