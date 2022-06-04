#include <stdio.h>
#include <stdlib.h>
#include <conio.h> 
#include <string> 
int main(int argc, char *argv[])
{   
 char a[20];//字元陣列 
 int b,c,d;
 float e,f;
 printf("請輸入姓名,國文分數,英文分數,數學分數\n");
 scanf("%s%d%d%d",&a,&b,&c,&d);
 printf("姓名:%s\n國文:%d\n英文:%d\n數學:%d\n\n",a,b,c,d);
 e=b+c+d;
 f=e/3;
 printf("%s同學的總分是%3.2f,平均是%3.2f\n",a,e,f);
 system("PAUSE");	
  return 0;
}
