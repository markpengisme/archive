#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char *argv[])
{
    char usr_id[7];//�i�s��7�Ӧr��,���r�ꥻ���᭱������m'\0'�Ŧr�������r�� 
    char pwd[5];
    printf("�п�J�b�� (�����Ӧr��)�G");
	scanf("%s", usr_id);
	printf("�п�J�K�X (���|�Ӧr��)�G");
	scanf("%s", pwd);
	printf("\n");
	if (strcmp(usr_id , "gotop")==0 && strcmp(pwd,"i168")==0)
	{
		printf("�b�� �M �K�X���T ...  ^_^ !!\n");
		printf("�w��i�J���t��...\n\n");
	}
	else
	{
		printf("�b�� �� �K�X��J���~ ...  @_@ !!\n");
		printf("�L�k�i�J���t��...\n\n");
	}

  system("PAUSE");	
  return 0;
  /*strcpy(s1, s2)    �N s2 �����e�ƻs�� s1
	strcmp(s1, s2)    ��� s1�Bs2 �����e�A�p�G�۵��Ǧ^ 0
	strcat(s1, s2)    �N s2 �걵�� s1 �᭱
	strstr(s1, s2)    �Ǧ^ s2 �r��b s1�r�ꤤ�Ĥ@���X�{����m
	strlen(s1)        �Ǧ^ s1 ������(���t '\0' �r��)
	strrev(s1)        �N s1 �r��˸m*/
}
