#include <stdio.h>
#include <stdlib.h>

void bubble(int[],int);
int main(int argc, char *argv[])
{
    int c,n,i;
    printf("�п�J�n�ƧǴX���ƭ�:");
    scanf("%d",&c);
    int data[c];
    printf("== ��w�Ʈ�k,�p��j�Ƨ�==\n\n");
    printf("...�гs���J�ƭ�(��ƶ��Ť@��)...\n\n");
    /*��J�Ƨǫe�����*/
    printf(" �Ƨǫe�G");
    for(i=0;i<c;i++) /* �ϥΪ̿�J����Ʒ|�̧Ǧs��bdata[0]~data[c-1] */
    {
        scanf("%d", &n);
        data[i]=n;
    }
    /*��w�ƧǪk*/
    bubble(data,c);
    for(i=0;i<c;i++)
    {
        printf("%d ",data[i]);
    }
}
void bubble(int a[],int size)
{
    int i,j,temp,flag=0;
    for(i=1;(i<size) && (!flag);i++)
    {
        flag=1;
        for(j=0;j<size-i;j++)
            if(a[j]>a[j+1])
            {
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                flag=0;
            }
    }
}
