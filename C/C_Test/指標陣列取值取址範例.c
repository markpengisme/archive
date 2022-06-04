#include <stdio.h>
#include <stdlib.h>
void swap(int*,int *);	 /* 函式原型宣告中引數的資料型別加上*符號 */
int main(int argc, char *argv[])
{
    int myarray[]={1,2,3,4};
    printf("%d\n%d\n%d\n%d\n",*(myarray+3),myarray[3],&myarray[3],myarray+3);//取值、取值、取址、取址
    myarray[3]=*(myarray+2)+5;//=8
    printf("%d\n%d\n%d\n%d\n",*(myarray+3),myarray[3],&myarray[3],myarray+3);
    system("PAUSE");
    return 0;
}

