//
//  main.c
//  text
//
//  Created by wahaha on 2016/5/9.
//  Copyright  2016�~ wahaha. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void bubble(int [],int);
int binary_search(int [],int,int,int);
int main(int argc, const char * argv[])
{
    int n, i, c;
    printf("�п�J�n�ƧǴX���ƭ�:");
    scanf("%d",&c);
    int data[c];
    int target, num=-1, low=0, high=c-1; /* searchNum:�j�M��*/
    printf(" �s���J�Ʀr(�Ʀr���Ť@��) : \n\n");
    /*��J�Ƨǫe�����*/
    printf(" �Ƨǫe�G");
    for(i=0;i<c;i++)
    {
        scanf("%d", &n);
        data[i]=n;
    }
    
    bubble(data,c);
    printf(" �Ƨǫ�G\n");
    for(i=0;i<c;i++)
    {
        printf("%d ", data[i]);
    }
    printf("======  �G���j�M�k ======\n\n");
    printf("�п�J�n�j�M���Ʀr");
    scanf("%d",&target);
    num=binary_search(data,low,high,target);
    if(num==-1)
        printf("�L����\n");
    else
        printf("��%d�Ӽ�",num+1);
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