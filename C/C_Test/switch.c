
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int num;
    printf("½Ð¿é¤J´X¤ë: ");
    scanf(" %d",&num);
    
    
    switch(num)
    {
        case 1:
            printf("¥V");
            break;
        case 2:
            printf("¬K");
            break;
        case 3:
            printf("¬K");
            break;
        case 4:
            printf("¬K");
            break;
        case 5:
            printf("®L");
            break;
        case 6:
            printf("®L");
            break;
        case 7:
            printf("®L");
            break;
        case 8:
            printf("¬î");
            break;
        case 9:
            printf("¬î");
            break;
        case 11:
            printf("¬î");
            break;
        case 12:
            printf("¥V");
            break;
        default:
            printf("¿é¤J¿ù»~!!\n");		
    }
    system("pause");
    return 0;
}

