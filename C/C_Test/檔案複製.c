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

	printf("�п�J���ƻs���ӷ��ɮסG");
	gets(paths);
	fptrsource=fopen(paths, "r");
	printf("�п�J���ƻs���ئa�ɮסG");
	gets(patht);
	fno=fileno(fptrsource);
	fsize=filelength(fno);
	fptrtarget=fopen(patht, "w");
	if(fptrsource==NULL || fptrtarget==NULL)
	{
		printf("\n�}�ɥ���, �L�k�ƻs\n");
		exit(0);
	}
	while(fgets(temp, LEN, fptrsource)!=NULL)
	{
		fputs(temp, fptrtarget);
	}
	fclose(fptrsource);
	fclose(fptrtarget);
	printf("\n%s �ɮ׽ƻs����...\n", patht, fsize);

    system("PAUSE");	
    return 0;
}

