//
//  main.c
//  text
//
//  Created by wahaha on 2016/5/9.
//  Copyright  2016年 wahaha. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void bubble(int [],int);
int binary_search(int [],int,int,int);
int main(int argc, const char * argv[])
{
    int n, i, c;
    printf("請輸入要排序幾項數值:");
    scanf("%d",&c);
    int data[c];
    int target, num=-1, low=0, high=c-1; /* searchNum:搜尋值*/
    printf(" 連續輸入數字(數字間空一格) : \n\n");
    /*輸入排序前的資料*/
    printf(" 排序前：");
    for(i=0;i<c;i++)
    {
        scanf("%d", &n);
        data[i]=n;
    }
    
    bubble(data,c);
    printf(" 排序後：\n");
    for(i=0;i<c;i++)
    {
        printf("%d ", data[i]);
    }
    printf("======  二分搜尋法 ======\n\n");
    printf("請輸入要搜尋的數字");
    scanf("%d",&target);
    num=binary_search(data,low,high,target);
    if(num==-1)
        printf("無此數\n");
    else
        printf("第%d個數",num+1);
}
void bubble(int a[],int size)
{
    int i,j,temp,flag=0;
    for(i=1;i<size && !flag;i++)
    {
        flag=1;
        for(j=0;j<size-1;j++)
            if(a[j]>a[j+1])
            {
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                flag=0;
            }
    }
}
int binary_search(int a[],int low,int high,int target)
{
    int mid;
    while(low<=high)
    {
        mid=(low+high)/2;
        if(a[mid]>target)
            high=mid-1;
        else if (a[mid]<target)
            low=mid+1;
        else
            return mid;
    }
    return -1;
}