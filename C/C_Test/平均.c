#include <stdio.h>
#include <stdlib.h>
#include <conio.h> 
#include <string> 
int main(int argc, char *argv[])
{   
 char a[20];//�r���}�C 
 int b,c,d;
 float e,f;
 printf("�п�J�m�W,������,�^�����,�ƾǤ���\n");
 scanf("%s%d%d%d",&a,&b,&c,&d);
 printf("�m�W:%s\n���:%d\n�^��:%d\n�ƾ�:%d\n\n",a,b,c,d);
 e=b+c+d;
 f=e/3;
 printf("%s�P�Ǫ��`���O%3.2f,�����O%3.2f\n",a,e,f);
 system("PAUSE");	
  return 0;
}
