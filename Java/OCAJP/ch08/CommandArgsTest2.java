package ch08;
// 4
public class CommandArgsTest2 {

	public static void main(String[] args) {

		System.out.println("String is: " + (args[0] + args[1])); // 字串連接

		int i1 = Integer.parseInt(args[0]);
		int i2 = Integer.parseInt(args[1]);

		System.out.println("Summary is: " + (i1 + i2));// 數字相加
	}

}
