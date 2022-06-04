#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
	int lot[49],choose[7],min=1,max=49,num=7;
	int i,choice;
	for (i=0;i<max;i++)
	{
		lot[i]=min+i;
	}
	srand((unsigned)time(NULL));
	for(i=0;i<num;i++)
	{
		choice=rand()%max;
		choose[i]=lot[choice];
		lot[choice]=lot[max-1];
		max--;
	}
	printf("\n本期開獎號碼為:");
	for(i=0;i<num;i++)
	{
		printf("%d,",choose[i]);
	}
	system("PAUSE");
	return 0;
 } /* 
int main()
{
	int i,ch,sum=0,ca[7]={0};
	
	srand((unsigned)time(NULL));
	printf("\n本期開獎號碼為:");
	
	while(sum<7)
	{	
		ch=rand()%7+1;
		if(ch!=ca[0] && ch!=ca[1] && ch!=ca[2] && ch!=ca[3] && ch!=ca[4] &&  ch!=ca[5] && ch!=ca[6]  )
		{
		printf("%d,",ch);
		ca[sum]=ch;
		sum++;
		}
		else
			continue;
	}
	
	system("PAUSE");
	return 0;
 }
 */
