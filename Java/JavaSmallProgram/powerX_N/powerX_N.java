import java.lang.*;
import java.io.*;

public class powerX_N
{
	public static void main(String[] args) 
	{	
		int b;
		double a,ans;
		Console console=System.console();
		System.out.println("計算a的b次方");
		System.out.println("a?");
		a=Double.parseDouble(console.readLine());
		System.out.println("b?");
		b=Integer.parseInt(console.readLine());
		ans=power(a,b);
		System.out.println("a^b="+ans);

	}

	public static  double power(double x,int n)
	{
		double powerx=1;
		for (int i=0;i<n ;i++ ) 
		{
			powerx*=x;
		}
		return powerx;
	}
}