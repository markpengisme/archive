//
//  main.c
//  test1
//
//  Created by wahaha on 2016/3/21.
//  Copyright  2016年 wahaha. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#define ABS(x) ((x)<0 ? -(x):(x))//絕對值
#define SQR(x) ((x)*(x))//平方
#define fuck(x,y) (x-y)//相減
int main(int argc, const char * argv[]) {
    long double x=-1.23456765432134567;
    printf("Hello, World!\n%.12Lf\n",ABS(x));
    printf("%.17Lf\n",SQR(x));
    printf("%.17Lf",fuck(SQR(x),0.4130461819853987229));
    return 0;
}
