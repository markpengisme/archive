#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int age;
	printf("=== �q�v�ʲ� ===\n");
	printf("�п�J�z���~�֡G");
	scanf("%d", &age);
	printf("�z�n�ʶR���O���O %s ! ^_^ ... \n", age>=60? "�u�ݲ�": (0<=age && age<=12 ? "�ൣ��" : "���H��"));	
    printf("\n\n");
    system("PAUSE");	
    return 0;
}
