#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    int a=3, b=6, c=9, *ptr;
    printf(" Expression   (Address) = Content \n ");
    printf("===========  =========   ======= \n");
    printf("      &a      (%d) = %d\n",&a,a);	/* 顯示a位址 */
    printf("      &b      (%d) = %d\n",&b,b);  /* 顯示b位址 */
    printf("      &c      (%d) = %d\n",&c,c);  /* 顯示c位址 */
    ptr=&a;		/* ptr裡面存放a 的位址 */
    /* 顯示ptr的內容 */
    printf("     ptr=&a     (ptr)   = %d\n",ptr);
    /* ptr指到a位址，顯示3*/
    printf("     *ptr       (*ptr)  = %d\n", *ptr);
    ptr-=2;	/* ptr存放的位址減8 */
    /* 顯示ptr的內容 */
    printf("     ptr-=2     (ptr)   = %d\n",ptr);
    /* ptr指到c位址，顯示9*/
    printf("     *ptr       (*ptr)  = %d\n", *ptr);
    ptr++;  	/* ptr存放的位址加4 */
    /* 顯示ptr的內容 */
    printf("     ptr++      (ptr)   = %d\n", ptr);
    /* ptr指到b位址，顯示6*/
    printf("     *ptr       (*ptr)  = %d\n", *ptr);
    system("PAUSE");	
    return 0;
}
