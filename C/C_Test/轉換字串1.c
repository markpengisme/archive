#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
   char ch1='A';
   printf("   ====1234567890\n");
   printf(" 1.ch1=%c \n",ch1);   
   printf(" 2.ch1=%5c \n",ch1);//�e��5�r�� 
   printf(" 3.ch1=%-c \n",ch1);//�a����� 
   printf(" 4.ch1=%-5c \n",ch1);
   printf(" 5.ch1=%+5c \n",ch1);//5�r���a�k�����l�ɪť� 
   printf(" 6.ch1=%+5d \n",ch1);//�H10�i�����ascii 
   printf(" 7.ch1=%-5d \n",ch1);
   printf(" 8.ch1=%5d \n",ch1);
   printf(" 9.ch1=%-5x \n",ch1);//�H16�i�����ascii 
   printf("10.ch1=%5o \n\n",ch1);//�H8�i�����ascii 
   system("PAUSE");	
   return 0;
}
