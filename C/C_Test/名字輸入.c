#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argc, char *argv[])
{
    int i,count=0;
    char name[10][15];
    for(i=0; i<10; i++)
    {
        printf("�п�J %d ���P�Ǫ��^��W�r�G", i+1);
        gets(name[i]); /* ��J��i��P�Ǫ��^��W�٨é�Jname[i] */
        if (strcmp(name[i],"stop")==0)	/*�P�_�O�_��J "stop" �r��*/
        {
            count=--i;
            break;
        }
        count++;
    }
    printf("\n  �@��J %d ��P�Ǫ��^��W�r ",count);
    printf("\n==============================");
    for (i=0;i<count;i++)  /* ��ܩҦ��ǥͪ��m�W */
    {
        printf("\n ==> �y�� %d ���P�Ǫ��^��W�r : %s\n\n",i+1,name[i]);
    }
    system("PAUSE");
    return 0;
}
