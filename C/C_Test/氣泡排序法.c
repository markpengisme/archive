#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{		int n, i, j, t, c;
		printf("�п�J�n�ƧǴX���ƭ�:");
		scanf("%d",&c); 
  		int data[c];	
		printf("== ��w�Ʈ�k,�p��j�Ƨ�==\n\n");
		printf("...�гs���J�ƭ�(��ƶ��Ť@��)...\n\n");
		/*��J�Ƨǫe�����*/
		printf(" �Ƨǫe�G");
		for(i=0;i<c;i++) /* �ϥΪ̿�J����Ʒ|�̧Ǧs��bdata[0]~data[c-1] */
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
					t=data[j];			/*�洫���*/
					data[j]=data[j+1];
					data[j+1]=t;
				}
			}
		}
		/*�L�X�Ƨǫ᪺���*/
		printf("\n �Ƨǫ�G");
		for(i=0;i<c;i++)
		{
			printf("%d ", data[i]);
		}
  printf("\n\n");
  system("PAUSE");	
  return 0;
}
