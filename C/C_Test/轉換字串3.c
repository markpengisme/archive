#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    /* 宣告字元陣列用來存放字串 */
	char str[15]="Hello!您好";	
	printf(" ==|123456789012345|==\n");
	printf("1. |%s|\n",str);
	printf("2. |%5s|\n",str);//設定長度比實際短以實際顯示 
	printf("3. |%15s|\n",str);
	printf("4. |%-15s|\n",str);
	printf("5. |%10.2s|\n",str);//小數兩位,只顯示兩位元 
	printf("6. |%-10.2s|\n\n",str);
    system("PAUSE");	
    return 0;
}
