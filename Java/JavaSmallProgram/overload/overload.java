import java.lang.*;


public class overload
{
	//!!多載只要參數的型態或個數或順序不同就算名稱相同也可以

	public static void main(String[] args) 
	{
		printHello();
		System.out.println("------------");
		printHello(2);
		System.out.println("------------");
		printHello("three");
	}

	public static void printHello()
	{
		System.out.println("Hello java");
	}

	public static void printHello(int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.println("Hello java"+n);
		}
	}
	public static void printHello(String str1)
	{
			System.out.println("Hello java\t"+str1);
	}
}