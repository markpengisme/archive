#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(int argc, char *argv[])
{
  		int keyin, guess, count, min, max;
		char *c; 
		count=0;
		min=0;
		max=100;
		srand((unsigned)time(NULL));  
        guess=rand()%99+1; 		
		printf("======= �q�Ʀr�C�� =======�G\n\n");
		do
		{	
			printf("�q�Ƥl�d�� %d < ? < %d �G", min, max);
			scanf("%d", &keyin);
			count++;
			if(keyin>=1 && keyin<100)
			{
				if(keyin>=min && keyin<max)
					{
						if(keyin==guess)
						{
							printf("���G! �q��F, ���׬O %d\n", guess);
							break;
						}
						else if(keyin>guess)
						{
							max=keyin;	/*�N�ثe��J���Ʀrkeyin���w��max*/
							printf("�A�p�@�I!!");
						}
						else if(keyin<guess)
						{
							min=keyin;	/*�N�ثe��J���Ʀrkeyin���w��min*/
							printf("�A�j�@�I!!");
						}
						printf(" �z�q�F %d ��\n\n", count);
					}
				else
					printf("�п�J���ܽd�򤺪��Ʀr!\n");
			}
			else
				printf("�п�J���ܽd�򤺪��Ʀr!\n");
		}
		while(1);	/*�L�a�j��*/
		if (count>=7)
			c="�n��";
		else if (3<count&&count<7)
			c="�٤���";
		else
			c="�u�F�`";
		printf("\n�`�@�q�F %d ��!(%s)\n\n", count,c);
		
  system("PAUSE");	
  return 0;
}
