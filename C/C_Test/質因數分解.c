//
//  main.c
//  test1
//
//  Created by wahaha on 2016/3/29.
//  Copyright 2016年 wahaha. All rights reserved.
//

#include <stdio.h>

int main(void) {
    int i,n;
    printf("請輸入一個數:");
    scanf("%d",&n);
    for(i=2; i<=n; i++)
    {
        while(i<n){
            if(n%i==0)
            {
                printf("%d*",i);
                n=n/i;
            }
            else
                break;
        }
    }
    printf("%d\n",n);
    return 0;

}
