#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <conio.h> 

int main(int argc, char *argv[])
{ 
while(1)
{

  char d;
  printf("�п�J�@�Ӧr�����ʮ�(a~d)\n");
  d=getchar();//getchar �bconio.h�� 
  d=tolower(d);//tolower&toupper �b ctype.h�� 
 
  switch(d)
  {
  	case'a':
  		printf("��è");
  		break;
	case'b':
		printf("����");
		break;
	case'c':
		printf("����");
		break;
	case'd':
		printf("�Ѥ~");
		break;
	default:
		printf("�F"); 
		break;
  }   
  fflush(stdin);//�w�İϮ��� 
  printf("\n");
}
}


