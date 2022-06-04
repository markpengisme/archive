#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <conio.h> 

int main(int argc, char *argv[])
{ 
while(1)
{

  char d;
  printf("請輸入一個字母測性格(a~d)\n");
  d=getchar();//getchar 在conio.h裡 
  d=tolower(d);//tolower&toupper 在 ctype.h裡 
 
  switch(d)
  {
  	case'a':
  		printf("白癡");
  		break;
	case'b':
		printf("智障");
		break;
	case'c':
		printf("腦殘");
		break;
	case'd':
		printf("天才");
		break;
	default:
		printf("幹"); 
		break;
  }   
  fflush(stdin);//緩衝區消除 
  printf("\n");
}
}


