#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <conio.h>

int main(int argc, char *argv[])
{
 	char ch;
	int n=0, digit=0, upper=0, lower=0, punct=0, cntrl=0, celse=0;
	printf("=== 判斷字元種類，按ESC鍵可離開 ===\n");
	do
	{	
        printf("\n請輸入測試字元：");
	    ch=getche()//不用enter會顯示的輸入;
		if (ch==27)//ESC=ASCii:27
		{
			break;
		}
		else if(isdigit(ch))//判斷字元是否為10進位數字 
		{
			digit++;
		}
		//else if(isalpha(ch))判斷字元是否為英文字母  
		
		else if(isupper(ch))//判斷字元是否為大寫字母  
		{
			upper++;
		}
		else if(islower(ch))//判斷字元是否為小寫字母 
		{
			lower++;
		}
		else if(ispunct(ch))//判斷字元是否為符號字元 
		{
			punct++;
		}
		else if(iscntrl(ch))//判斷字元是否為控制字元 
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
	printf("輸入0-9 數子 %d 次.\n", digit);
	printf("輸入大寫字母 %d 次.\n", upper);
	printf("輸入小寫字母 %d 次.\n", lower);
	printf("輸入標點符號 %d 次.\n", punct);
	printf("輸入控制字元 %d 次.\n", cntrl);
	printf("輸入其他按鍵 %d 次.\n", celse);
    printf("\n");
    system("PAUSE");	
    return 0;
}
