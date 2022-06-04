import java.lang.*;
import java.util.Arrays;

public class BigLotto 
{
    public static void main(String[] args) 
    {
        int a[]=new int[7],temp,flag;

        for (int i = 0; i < 7; i++) 
        {
        	flag=0;
            temp=(int)(Math.random()*49+1);//random產生0.0~1.0之間的double
            for(int j=0;j<i;j++)
            {
            	if(temp==a[j])
            		{
            			flag=1;//重複旗標設為1
            		}
            }
            if(flag==0)//沒重複寫入a陣列
            	{
            		a[i]=temp;
            	}
            else//重複再做一次
            {
            	i--;
            }
        }
        Arrays.sort(a,0,6);//排序a陣列0~5項
        //Arrays.sort(arrays,fromindex(inclusive),toindex(exclusive))
        for (int i = 0; i < 7; i++) 
        {
        	System.out.print(a[i]+"\t");
        }

    }

}