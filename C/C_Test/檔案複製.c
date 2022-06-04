#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <io.h>
#define LEN 100

int main(int argc, char *argv[])
{
  	FILE *fptrsource, *fptrtarget;
	char paths[LEN], patht[LEN];
	char keyin[LEN], temp[LEN];
	int fno, fsize;

	printf("請輸入欲複製的來源檔案：");
	gets(paths);
	fptrsource=fopen(paths, "r");
	printf("請輸入欲複製的目地檔案：");
	gets(patht);
	fno=fileno(fptrsource);
	fsize=filelength(fno);
	fptrtarget=fopen(patht, "w");
	if(fptrsource==NULL || fptrtarget==NULL)
	{
		printf("\n開檔失敗, 無法複製\n");
		exit(0);
	}
	while(fgets(temp, LEN, fptrsource)!=NULL)
	{
		fputs(temp, fptrtarget);
	}
	fclose(fptrsource);
	fclose(fptrtarget);
	printf("\n%s 檔案複製完成...\n", patht, fsize);

    system("PAUSE");	
    return 0;
}

