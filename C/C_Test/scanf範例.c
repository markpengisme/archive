#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	/*�ŧicname��ename�r���}�C�ΨӦs��r��*/
    char cname[20],ename[20];
	printf("\nPlease input your chinese name :" );
	scanf("%s",&cname); 	/*��J�r���ƥؤ���*/
	printf("Your name is : %s ",cname);
	printf("\nPlease input your english name :" );
	scanf("%6s",&ename); 	/*��J�r�����̫e��6�Ӧr�� */
	printf("Your english name : %s", ename);
	printf("\n\n");

    system("PAUSE");	
    return 0;
}
