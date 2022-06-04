#include <stdio.h>
#include <stdlib.h>

void bubble(int[],int);
int main(int argc, char *argv[])
{
    int c,n,i;
    printf("請輸入要排序幾項數值:");
    scanf("%d",&c);
    int data[c];
    printf("== 氣泡排氣法,小到大排序==\n\n");
    printf("...請連續輸入數值(資料間空一格)...\n\n");
    /*輸入排序前的資料*/
    printf(" 排序前：");
    for(i=0;i<c;i++) /* 使用者輸入的整數會依序存放在data[0]~data[c-1] */
    {
        scanf("%d", &n);
        data[i]=n;
    }
    /*氣泡排序法*/
    bubble(data,c);
    for(i=0;i<c;i++)
    {
        printf("%d ",data[i]);
    }
}
void bubble(int a[],int size)
{
    int i,j,temp,flag=0;
    for(i=1;(i<size) && (!flag);i++)
    {
        flag=1;
        for(j=0;j<size-i;j++)
            if(a[j]>a[j+1])
            {
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                flag=0;
            }
    }
}
