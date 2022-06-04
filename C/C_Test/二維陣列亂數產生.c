#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(int argc, char *argv[])
{	
	srand((unsigned)time(NULL));  
		
	int i,j,k,l,a[3][4],guess;
	
	for(k=0;k<3;k++)
	{	
		for(l=0;l<4;l++)
		{	
			guess=rand()+1;//1~32768 
			a[k][l]=guess;
		}
	}
	for(i=0;i<3;i++)
	{
		for(j=0;j<4;j++)
		{
			printf("a[%d][%d]=%d\n",i,j,a[i][j]);
		}
	}


  system("PAUSE");
  return 0;
}

