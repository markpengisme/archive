#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <conio.h>
#include <io.h>
#define LEN 100

typedef struct 			/*book���c*/
{
	char bookid[6];		/*�Ѹ�*/
	char bookname[30];	/*�ѦW*/
	int price;			/*���*/
	int qty;			/*�w�s*/
	char flag[3];		/*�R���X��*/
}book;

void showfiledata(char[]);

int main(int argc, char *argv[])
{
  	FILE *fptr;
	char fpath[LEN];
	char search_bookid[6], t_price[10], t_qty[10];
	book mybook;
	int fno, fsize, rectot;
	int recno=0;		/*��ưO���s��*/
	char ch;
	printf("�п�J���}�Ҫ��ɮ׸��|�G");
	gets(fpath);
	fptr=fopen(fpath, "r+");
	if(fptr==NULL)
	{
		printf("\n�}�ɥ���, %s �i�ण�s�b\n", fpath);
		exit(0);
	}
	showfiledata(fpath);
	while(1)//�s�W��� 
	{
		printf("\n�аݬO�_�n�~��s�W���(Y/N)�G");
		if(toupper(getche())=='Y')
		{
			printf("\n�п�J�n�s�W�����->\n");
			printf("�Ѹ��G");
			gets(mybook.bookid);		
			printf("�ѦW�G");
			gets(mybook.bookname );
			printf("����G");
			gets(t_price);
			mybook.price = atoi(t_price);
			printf("�w�s�G");
			gets(t_qty);
			mybook.qty = atoi(t_qty);
            /*�N���c�g�J�ɮ�*/
			fwrite(&mybook, sizeof(mybook), 1, fptr);
		}
		else
		{
			fclose(fptr);
			break;	
		}
	}
	fptr=fopen(fpath, "r");	
	fno=fileno(fptr);
	fsize=filelength(fno);
    /*���o�O���`����*/
	rectot=filelength(fileno(fptr))/sizeof(book);	
	printf("\n��Ƨ�s����...");
	printf("\n%s �ثe�ɮפj�p %d Bytes\n", fpath, fsize);
	printf("%s ����ɤ��e�p�U\n", fpath);
	printf("\n�O���`���ơG%d\n", rectot);
	/* �P�_�O�_�٦����*/
	while(fread(&mybook, sizeof(mybook), 1, fptr)!=NULL)
	{	/*���X�@���O���A�ɮ׫��ЦA���Ჾ�ʤ@���O��������*/
		printf("%6s %30s %5d %5d\n", 
			mybook.bookid, mybook.bookname, mybook.price, mybook.qty);
	}
	fclose(fptr);
	printf("\n");
	printf("\n�п�ܶ���->1.�ק�  2.�R��  3.���}�G");
	ch=getche();
	if(ch=='3' && ch !='1' && ch != '2')		/*��ܥ\��M��*/
	{	
		printf("\n\n�����{��...\n");
		exit(0);
	}
	printf("\n�п�J�n���ʰO�����Ѹ��G");
	gets(search_bookid);				/*��J�n�d�ߪ��Ѹ�*/
	rewind(fptr);					/*�ɮ׫��в����ɮ׳̶}�Y*/
	while(1)
	{
		/* �ɮ׫��в���̫ᵲ���|�Ǧ^NULL�A��ܧ䤣���� */
		if(fread(&mybook, sizeof(mybook), 1, fptr)==NULL)
		{
			printf("\n�S���Ѹ� %s �o���O��...\n", search_bookid);
			exit(0);
		}
		else
		/*�����*/
		{
			/*�P�_��ƬO�_�Q�R��*/
			if(strcmp(mybook.bookid, search_bookid)==0 && 
			   strcmp(mybook.flag, "*")!=0)
			{
				if(ch=='1')
				{	/*��J�n�ק諸���*/
					printf("�ק�@�~...\n");
					printf("�ѦW�אּ->");
					gets(mybook.bookname );
					printf("����אּ->");
					gets(t_price);
					mybook.price = atoi(t_price);
					printf("�w�s�אּ->");
					gets(t_qty);
					mybook.qty = atoi(t_qty);
				}
				else if(ch=='2')
				{	
					/*�Nmybook.flag�]��"*"�A��ܳ]�w�R���X��*/
					printf("�R���@�~...\n");
					strcpy(mybook.flag , "*");
				}
				printf("�T�w�n�����(Y/N)�H");
				/*�߰ݬO�_���沧�ʸ�ƪ��@�~*/
				if(toupper(getche())=='Y')
				{
					/*�ɮ׫��в����recno����Ʀ�}*/
					fseek(fptr, sizeof(mybook)*recno, 0);
					/*�Nmybook�g�J�ɮ׫��Хثe�ҫ�����Ʀ�}*/
					fwrite(&mybook, sizeof(mybook), 1, fptr);
					fclose(fptr);
					break;
				}
				else
				{
					printf("\n\n������...\n");
					exit(0);
				}
			}
			else
			{
				/*recno�O���s���[1�A��ܲ���U�@�����*/
				recno++;
			}
		}
	}
	printf("\n��Ʋ��ʧ���...\n");
	showfiledata(fpath);
	printf("\n");
    system("PAUSE");	
    return 0;
}

void showfiledata(char vfpath[])
{	
  int rectot=0;
  book vbook;
  FILE *vfptr;
  vfptr=fopen(vfpath, "r");	
  printf("\n%s ����ɤ��e�p�U\n", vfpath);
  while(fread(&vbook, sizeof(vbook), 1, vfptr) != NULL)
  {
 	if(strcmp(vbook.flag, "*") != 0)
 	{
 		printf("%6s %30s %5d %5d\n", 
			 vbook.bookid, vbook.bookname, vbook.price, vbook.qty);
 		rectot++;
		}
  }
  printf("�O���`���ơG%d\n", rectot);
  fclose(vfptr);
 }

