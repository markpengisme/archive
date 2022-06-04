#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{		int n, i, j, t, c;
		printf("請輸入要排序幾項數值:");
		scanf("%d",&c); 
  		int data[c];	
		printf("== 氣泡排氣法,小到大排序==\n\n");
		printf("...請連續輸入數值(資料間空一格)...\n\n");
		/*輸入排序前的資料*/
		printf(" 排序前：");
		for(i=0;i<c;i++) /* 使用者輸入的整數會依序存放在data[0]~data[c-1] */
		{
			scanf("%d", &n);
			data[i]=n;
		}
		/*氣泡排序法*/
		for(i=c-1;i>0;i--)
		{
			for(j=0;j<=i;j++)
			{
				if(data[j]>data[j+1])
				{
					t=data[j];			/*交換資料*/
					data[j]=data[j+1];
					data[j+1]=t;
				}
			}
		}
		/*印出排序後的資料*/
		printf("\n 排序後：");
		for(i=0;i<c;i++)
		{
			printf("%d ", data[i]);
		}
  printf("\n\n");
  system("PAUSE");	
  return 0;
}
