#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <conio.h>

int main(int argc, char *argv[])
{
 	char ch;
	int n=0, digit=0, upper=0, lower=0, punct=0, cntrl=0, celse=0;
	printf("=== �P�_�r�������A��ESC��i���} ===\n");
	do
	{	
        printf("\n�п�J���զr���G");
	    ch=getche()//����enter�|��ܪ���J;
		if (ch==27)//ESC=ASCii:27
		{
			break;
		}
		else if(isdigit(ch))//�P�_�r���O�_��10�i��Ʀr 
		{
			digit++;
		}
		//else if(isalpha(ch))�P�_�r���O�_���^��r��  
		
		else if(isupper(ch))//�P�_�r���O�_���j�g�r��  
		{
			upper++;
		}
		else if(islower(ch))//�P�_�r���O�_���p�g�r�� 
		{
			lower++;
		}
		else if(ispunct(ch))//�P�_�r���O�_���Ÿ��r�� 
		{
			punct++;
		}
		else if(iscntrl(ch))//�P�_�r���O�_������r�� 
		{
			cntrl++;
		}
		else
		{
			celse++;
		}
		n++;
	}while(1);
	printf("\n\n");
	printf("��J0-9 �Ƥl %d ��.\n", digit);
	printf("��J�j�g�r�� %d ��.\n", upper);
	printf("��J�p�g�r�� %d ��.\n", lower);
	printf("��J���I�Ÿ� %d ��.\n", punct);
	printf("��J����r�� %d ��.\n", cntrl);
	printf("��J��L���� %d ��.\n", celse);
    printf("\n");
    system("PAUSE");	
    return 0;
}
