import java.lang.*;
import java.util.Arrays;
public class ArraySort
{
	public static void main(String[] args) 
	{
		int x[]={25,10,39,40,33,12};
		int spec=11;

		Arrays.sort(x);
		for (int i=0;i<6 ;i++ ) 
		{
			System.out.print(x[i]+"\t");
		}
		System.out.println("\n特別號\t"+spec);
	}
}