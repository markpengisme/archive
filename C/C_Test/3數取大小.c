//
//  main.c
//  test2
//
//  Created by wahaha on 2016/3/22.
//  Copyright  2016¦~ wahaha. All rights reserved.
//

#include <stdio.h>
#define MAX_2(x,y) (x>y ? x:y)
#define MAX_3(x,y,z) MAX_2(MAX_2(x,y),z)
#define MIN_2(x,y) (x<y ? x:y)
#define MIN_3(x,y,z) MIN_2(MIN_2(x,y),z)
int main(int argc, const char * argv[])
{
    int a,b,c;
    printf("input 3 int:");
    scanf("%d,%d,%d",&a,&b,&c);
    printf("max is:%d\n",MAX_3(a,b,c));
    printf("min is:%d\n",MIN_3(a,b,c));
    
    
    return 0;
}
