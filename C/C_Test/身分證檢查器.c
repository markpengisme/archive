#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
void checkid(char *);	/*checkid�禡�쫬�ŧi*/

int main(int argc, char *argv[])
{
    /*�ŧiid�r���}�C�A�ΨӦs�񨭤��Ҹ��X*/
    char id[10];
    printf(" == �����Ҹ��X���ҵ{�� ==\n");
    printf(" �п�J�����Ҹ��X�G");
    /* ��J�����Ҹ��X�æs���keyinid�}�C */
    gets(id);
    /* �I�scheckid()�禡�ˬdid�r��O�_���X�k���X */
    checkid(id);
    system("PAUSE");
    return 0;
}

void checkid(char *idptr)		/* �w�qcheckid�禡 */
{
    int first_no,n;
    int head[] ={               /* �����r���Ĥ@�Ӧr���ഫ��  */
        10,11,12,13,14,15,16,17,
        34,18,19,20,21,22,35,23,24,
        25,26,27,28,29,32,30,21,33
    };
    /*���oidptr�ҫ��r��ζǤJ�������Ҧr�������� */
    if(strlen(idptr)!=10)
    {
        printf(" �����Ҹ��X���X�k�I@_@\n");
        return ;			/*���}�禡*/
    }
    /* ���o�Ĥ@�Ӧr�������ƭ�*/
    first_no=head[toupper(idptr[0])-'A'];
    n = (first_no/10)+       /* �N�J�����p���`�M */
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
    if((n%10)==0)          /* ���H10���l�ơA�P�_�O�_��0  */
    {
        printf(" �����Ҹ��X���T�I^_^\n");
    }
    else
    {
        printf(" �����Ҹ��X�����T�I@_@\n");
    }
}
