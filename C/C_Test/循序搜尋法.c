#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{		
		int c;
		printf("�п�J�`�@���X���ƭ�:");
		scanf("%d",&c); 
 		int data[c];
		/* searchNum:�j�M��	num:�n�j�M�}�C�����Ц�m*/
		int n, i, searchNum, num=-1;
		printf("========  �`�Ƿj�M�k  ========\n\n");
		printf(" �s���J�Ʀr(��ƶ��Ť@��)\n\n");		
		printf(" �п�J�G");
		for(i=0;i<c;i++)
		{
			scanf("%d", &n);
			data[i]=n;
		}
		printf("\n");
		printf(" �п�J�n�j�M���ƭȡG");
		scanf("%d", &searchNum);
		for(i=0;i<c;i++)
		{
			if(data[i]==searchNum)
			{
				num=i;
			}
		}
		printf(" ========================\n");
		if(num==-1)
		{
			printf("\n �Ʀr %d ���s�b ! \n", searchNum);
		}
		else
		{
			printf("\n %d �O�� %d �ӼƦr ! \n", searchNum, (num+1));
		}
  printf("\n\n");
  system("PAUSE");	
  return 0;
}
