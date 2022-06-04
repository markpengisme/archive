import java.lang.*;

public class args
{
	public static void main(String[] args) 
	{
		System.out.println("本程式共接收到"+args.length+"個輸入引數");

		for(int i=0;i<args.length;i++)
		{
			System.out.println("args["+i+"]字串為"+args[i]);
		}
	}
}