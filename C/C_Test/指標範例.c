#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    int a=3, b=6, c=9, *ptr;
    printf(" Expression   (Address) = Content \n ");
    printf("===========  =========   ======= \n");
    printf("      &a      (%d) = %d\n",&a,a);	/* ���a��} */
    printf("      &b      (%d) = %d\n",&b,b);  /* ���b��} */
    printf("      &c      (%d) = %d\n",&c,c);  /* ���c��} */
    ptr=&a;		/* ptr�̭��s��a ����} */
    /* ���ptr�����e */
    printf("     ptr=&a     (ptr)   = %d\n",ptr);
    /* ptr����a��}�A���3*/
    printf("     *ptr       (*ptr)  = %d\n", *ptr);
    ptr-=2;	/* ptr�s�񪺦�}��8 */
    /* ���ptr�����e */
    printf("     ptr-=2     (ptr)   = %d\n",ptr);
    /* ptr����c��}�A���9*/
    printf("     *ptr       (*ptr)  = %d\n", *ptr);
    ptr++;  	/* ptr�s�񪺦�}�[4 */
    /* ���ptr�����e */
    printf("     ptr++      (ptr)   = %d\n", ptr);
    /* ptr����b��}�A���6*/
    printf("     *ptr       (*ptr)  = %d\n", *ptr);
    system("PAUSE");	
    return 0;
}
