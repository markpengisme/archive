#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{		int n, i, j, t, c;
		printf("�п�J�n�ƧǴX���ƭ�:");
		scanf("%d",&c); 
		int data[c];
		
	     /* num:�n�j�M�}�C�����Ц�m	:midNum:��M�}�C���������� */
		int searchNum, num=-1, low=0, high=c-1, midNum=0; /* searchNum:�j�M��*/
		printf("======  �G���j�M�k ======\n\n");
		printf(" �s���J�Ʀr(�Ʀr���Ť@��) : \n\n");
		
		/*��J�Ƨǫe�����*/
		printf(" �Ƨǫe�G");
		for(i=0;i<c;i++)
		{
			scanf("%d", &n);
			data[i]=n;
		}
		/*��w�ƧǪk*/
		for(i=c-1;i>0;i--)
		{
			for(j=0;j<=i;j++)
			{
				if(data[j]>data[j+1])
				{
					t=data[j];
					data[j]=data[j+1];
					data[j+1]=t;
				}
			}
		}
		/*�L�X�Ƨǫ᪺���*/
		printf(" �Ƨǫ�G");
		for(i=0;i<c;i++)
		{
			printf("%d ", data[i]);
		}
		printf("\n\n");
		/*��J�n�j�M���Ʀr*/
		printf(" �п�J�n�j�M���Ʀr�G");
		scanf("%d", &searchNum);	
		/*�G���j�M�k*/
		do
		{
			midNum=(low+high)/2;
			printf("high=[%d]	",high);
			printf("low=[%d]	",low);
			printf("midNum=[%d]\n",midNum);
			if(data[midNum]==searchNum)
			{
				num=midNum;
				break;
			}
			if(data[midNum]>searchNum)
			{
				high=midNum-1;
			
			}
			else
			{
				low=midNum+1;
				
			}
		}while(low<=high);
		if(num==-1)
		{
			printf("\n Sorry ! �䤣�� %d �o�ӼƦr ... \n", searchNum);
		}
		else
		{
			printf("\n Find ! ���Ƨǫ�� %d�Ӧ�m ...\n", (num+1));
		}
   printf("\n\n");
   system("PAUSE");	
   return 0;
}
