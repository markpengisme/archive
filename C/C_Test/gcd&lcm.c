#include <stdio.h>
#include <stdlib.h>

int gcd(int m, int n) {
    while(n != 0) {
        int r = m % n;
        m = n;
        n = r;
    }
    return m;
}

int lcm(int m, int n) {
    return m * n / gcd(m, n);
}

int main(void) {
    int m, n;
    
    printf("輸入兩數：");
    scanf("%d %d", &m, &n);
    
    printf("Gcd：%d\n", gcd(m, n));
    printf("Lcm：%d\n", lcm(m, n));
    system("pause");
    return 0;
}