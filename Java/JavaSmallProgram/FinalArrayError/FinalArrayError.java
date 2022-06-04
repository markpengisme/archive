import java.lang.*;

public class FinalArrayError
{
	public static void main(String[] args) 
	{
		int orgArr[]=new int[3];
		for(int i=0;i<orgArr.length;i++)
		{
			orgArr[i]=i;
		}
		func1(orgArr);
		for(int i=0;i<orgArr.length;i++)
		{
			System.out.println("orgArr["+i+"]="+orgArr[i]);
		}
	}

	public static void func1(final int arr1[])
	{
		int arr2[]={5,10,15};
		for(int i=0;i<arr1.length;i++)
		{
			arr1[i]=arr1[i]*arr1[i];//修改陣列實體的內容
		}
		//arr1=arr2;不合法敘述因為final
	}
}

//array宣告成final代表他的reference不會變但他的實體可以改變