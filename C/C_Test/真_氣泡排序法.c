//
//  main.c
//  text
//
//  Created by wahaha on 2016/5/9.
//  Copyright  2016¦~ wahaha. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void bubble(int [],int);
int main(int argc, const char * argv[])
{
    int a[10]={2,5,4,63,51,23,34,78,99,7},n=10,i;
    bubble(a,n);
    for(i=0;i<n;i++)
    {
        printf("%d~",a[i]);
    }
    return 0;
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