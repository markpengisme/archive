#include <stdio.h>
#include <stdlib.h>
int comb(int,int);
int main(int argc, char *argv[])
{
	int n,m,ans;
	printf("�ФJ�n�զX����Ӽ�:(�γr�I�j�})\n");
	scanf("%d,%d",&n,&m);
	if(n>=m)
	{
		ans=comb(n,m);
		printf("comb(%d,%d)=%d",n,m,ans);
	}
	else
	{
		printf("n�����j��=m");
		return 0;
	}

  system("PAUSE");
  return 0;
}

int comb(int n,int m)
{
	if(n==m|m==0)
		return 1;
	else
		return comb(n-1,m)+comb(n-1,m-1);
}
