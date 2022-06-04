package ch06;
// 6
public class WrapperClassDemo {

	public static void main(String[] args) {

		Byte b = new Byte((byte) 1);

		Short s = new Short((short) 2);

		Integer i = Integer.parseInt("3");

		Long l = Long.valueOf(4);

		Float f = Float.valueOf("2.01");

		Double d = new Double(3.01);

		Character c = new Character('a');

		Boolean bTrue = new Boolean(true);
		Boolean bFalse1 = new Boolean(false);
		Boolean bFalse2 = new Boolean(null);
		
		System.out.println("Short is between " + Short.MAX_VALUE + " ~ " + Short.MIN_VALUE);
		
		System.out.println(i.compareTo(5));
		System.out.println(l.compareTo(i.longValue()));
		
		System.out.println(Long.sum(2, 5));
		
		System.out.println(bFalse2);

	}

}
