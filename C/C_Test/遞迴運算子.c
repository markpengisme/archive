#include <stdio.h>
#include <stdlib.h>
//++©M--// 
int main(int argc, char *argv[])
{
  int short a=10,b=0;
  printf("a=10,b=0\n");
  b=++a;
  printf("b=++a,a=%d,b=%d\n",a,b);
  a=10,b=0;
  b=a++;
  printf("b=a++,a=%d,b=%d\n",a,b);
  a=10,b=0;
  b=--a;
  printf("b=--a,a=%d,b=%d\n",a,b);
  a=10,b=0;
  b=a--;
  printf("b=a--,a=%d,b=%d\n,",a,b);
  system("PAUSE");
  return 0;
}

