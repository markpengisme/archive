#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    char x;
    float a,b,c,d;
    printf("請輸入性別：");
    scanf(" %c",&x);
    printf("請輸入體重(kg)和身高(cm):(逗點隔開)");
    fflush(stdin);
    scanf(" %f,%f",&b,&a);
    c=pow(a/100,2);
    printf("bmi=%.2f\n",b/c);
    d=b/c;
    if (x=='b')
    {
        if(d>=25 )
            printf("過重\n");
        else
            printf("正常\n");
    }
    else if (x=='g')
    {
        if(d>=20)
            printf("過重\n");
        else
            printf("正常\n");
    }
    else
        printf("性別不明");
    return 0;
        
}