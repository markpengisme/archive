#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char *argv[])
{
    char usr_id[7];//可存放7個字元,但字串本身後面必須放置'\0'空字元當結束字元 
    char pwd[5];
    printf("請輸入帳號 (限六個字元)：");
	scanf("%s", usr_id);
	printf("請輸入密碼 (限四個字元)：");
	scanf("%s", pwd);
	printf("\n");
	if (strcmp(usr_id , "gotop")==0 && strcmp(pwd,"i168")==0)
	{
		printf("帳號 和 密碼正確 ...  ^_^ !!\n");
		printf("歡迎進入本系統...\n\n");
	}
	else
	{
		printf("帳號 或 密碼輸入錯誤 ...  @_@ !!\n");
		printf("無法進入本系統...\n\n");
	}

  system("PAUSE");	
  return 0;
  /*strcpy(s1, s2)    將 s2 的內容複製到 s1
	strcmp(s1, s2)    比較 s1、s2 的內容，如果相等傳回 0
	strcat(s1, s2)    將 s2 串接到 s1 後面
	strstr(s1, s2)    傳回 s2 字串在 s1字串中第一次出現的位置
	strlen(s1)        傳回 s1 的長度(不含 '\0' 字元)
	strrev(s1)        將 s1 字串倒置*/
}
