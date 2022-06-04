#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
void checkid(char *);	/*checkid函式原型宣告*/

int main(int argc, char *argv[])
{
    /*宣告id字元陣列，用來存放身分證號碼*/
    char id[10];
    printf(" == 身分證號碼驗證程式 ==\n");
    printf(" 請輸入身分證號碼：");
    /* 輸入身分證號碼並存放到keyinid陣列 */
    gets(id);
    /* 呼叫checkid()函式檢查id字串是否為合法號碼 */
    checkid(id);
    system("PAUSE");
    return 0;
}

void checkid(char *idptr)		/* 定義checkid函式 */
{
    int first_no,n;
    int head[] ={               /* 身份字號第一個字母轉換表  */
        10,11,12,13,14,15,16,17,
        34,18,19,20,21,22,35,23,24,
        25,26,27,28,29,32,30,21,33
    };
    /*取得idptr所指字串及傳入的身份證字號的長度 */
    if(strlen(idptr)!=10)
    {
        printf(" 身分證號碼不合法！@_@\n");
        return ;			/*離開函式*/
    }
    /* 取得第一個字母的兩位數值*/
    first_no=head[toupper(idptr[0])-'A'];
    n = (first_no/10)+       /* 代入公式計算總和 */
    (first_no%10)*9+
    (idptr[1]-'0')*8+
    (idptr[2]-'0')*7+
    (idptr[3]-'0')*6+
    (idptr[4]-'0')*5+
    (idptr[5]-'0')*4+
    (idptr[6]-'0')*3+
    (idptr[7]-'0')*2+
    (idptr[8]-'0')+
    (idptr[9]-'0');
    if((n%10)==0)          /* 除以10取餘數，判斷是否為0  */
    {
        printf(" 身分證號碼正確！^_^\n");
    }
    else
    {
        printf(" 身分證號碼不正確！@_@\n");
    }
}
