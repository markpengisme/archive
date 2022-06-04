#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char *argv[])
{
    int i,count=0;
    char name[10][15];
    for(i=0; i<10; i++)
    {
        printf("請輸入 %d 號同學的英文名字：", i+1);
        gets(name[i]); /* 輸入第i位同學的英文名稱並放入name[i] */
        if (strcmp(name[i],"stop")==0)	/*判斷是否輸入 "stop" 字串*/
        {
            count=--i;
            break;
        }
        count++;
    }
    printf("\n  共輸入 %d 位同學的英文名字 ",count);
    printf("\n==============================");
    for (i=0;i<count;i++)  /* 顯示所有學生的姓名 */
    {
        printf("\n ==> 座號 %d 號同學的英文名字 : %s\n\n",i+1,name[i]);
    }
    system("PAUSE");
    return 0;
}
