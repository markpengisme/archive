//
//  main.c
//  test1
//
//  Created by wahaha on 2016/3/29.
//  Copyright 2016年 wahaha. All rights reserved.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    int i,j,n,flag=0;
    printf("請輸入一個正整數");
    scanf("%d",&n);
    for (i=2;i<n;i++)
    {
        for(j=2;j<=i;j++)
        {
            if (i==j)
                flag=1;
            else if(i%j==0)
                break;
        }
        if (flag==1)
            printf("%d\t",i);
        flag=0;
    }
    printf("Hello, World!\n");
    return 0;
}
