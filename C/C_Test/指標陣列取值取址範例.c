#include <stdio.h>
#include <stdlib.h>
void swap(int*,int *);	 /* �禡�쫬�ŧi���޼ƪ���ƫ��O�[�W*�Ÿ� */
int main(int argc, char *argv[])
{
    int myarray[]={1,2,3,4};
    printf("%d\n%d\n%d\n%d\n",*(myarray+3),myarray[3],&myarray[3],myarray+3);//���ȡB���ȡB���}�B���}
    myarray[3]=*(myarray+2)+5;//=8
    printf("%d\n%d\n%d\n%d\n",*(myarray+3),myarray[3],&myarray[3],myarray+3);
    system("PAUSE");
    return 0;
}

