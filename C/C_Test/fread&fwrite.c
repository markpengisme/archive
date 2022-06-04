#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <conio.h>
#include <io.h>
#define LEN 100

typedef struct 			/*book結構*/
{
	char bookid[6];		/*書號*/
	char bookname[30];	/*書名*/
	int price;			/*單價*/
	int qty;			/*庫存*/
	char flag[3];		/*刪除旗標*/
}book;

void showfiledata(char[]);

int main(int argc, char *argv[])
{
  	FILE *fptr;
	char fpath[LEN];
	char search_bookid[6], t_price[10], t_qty[10];
	book mybook;
	int fno, fsize, rectot;
	int recno=0;		/*資料記錄編號*/
	char ch;
	printf("請輸入欲開啟的檔案路徑：");
	gets(fpath);
	fptr=fopen(fpath, "r+");
	if(fptr==NULL)
	{
		printf("\n開檔失敗, %s 可能不存在\n", fpath);
		exit(0);
	}
	showfiledata(fpath);
	while(1)//新增資料 
	{
		printf("\n請問是否要繼續新增資料(Y/N)：");
		if(toupper(getche())=='Y')
		{
			printf("\n請輸入要新增的資料->\n");
			printf("書號：");
			gets(mybook.bookid);		
			printf("書名：");
			gets(mybook.bookname );
			printf("單價：");
			gets(t_price);
			mybook.price = atoi(t_price);
			printf("庫存：");
			gets(t_qty);
			mybook.qty = atoi(t_qty);
            /*將結構寫入檔案*/
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
    /*取得記錄總筆數*/
	rectot=filelength(fileno(fptr))/sizeof(book);	
	printf("\n資料更新完成...");
	printf("\n%s 目前檔案大小 %d Bytes\n", fpath, fsize);
	printf("%s 資料檔內容如下\n", fpath);
	printf("\n記錄總筆數：%d\n", rectot);
	/* 判斷是否還有資料*/
	while(fread(&mybook, sizeof(mybook), 1, fptr)!=NULL)
	{	/*取出一筆記錄，檔案指標再往後移動一筆記錄的長度*/
		printf("%6s %30s %5d %5d\n", 
			mybook.bookid, mybook.bookname, mybook.price, mybook.qty);
	}
	fclose(fptr);
	printf("\n");
	printf("\n請選擇項目->1.修改  2.刪除  3.離開：");
	ch=getche();
	if(ch=='3' && ch !='1' && ch != '2')		/*選擇功能清單*/
	{	
		printf("\n\n結束程式...\n");
		exit(0);
	}
	printf("\n請輸入要異動記錄的書號：");
	gets(search_bookid);				/*輸入要查詢的書號*/
	rewind(fptr);					/*檔案指標移到檔案最開頭*/
	while(1)
	{
		/* 檔案指標移到最後結尾會傳回NULL，表示找不到資料 */
		if(fread(&mybook, sizeof(mybook), 1, fptr)==NULL)
		{
			printf("\n沒有書號 %s 這筆記錄...\n", search_bookid);
			exit(0);
		}
		else
		/*找到資料*/
		{
			/*判斷資料是否被刪除*/
			if(strcmp(mybook.bookid, search_bookid)==0 && 
			   strcmp(mybook.flag, "*")!=0)
			{
				if(ch=='1')
				{	/*輸入要修改的資料*/
					printf("修改作業...\n");
					printf("書名改為->");
					gets(mybook.bookname );
					printf("單價改為->");
					gets(t_price);
					mybook.price = atoi(t_price);
					printf("庫存改為->");
					gets(t_qty);
					mybook.qty = atoi(t_qty);
				}
				else if(ch=='2')
				{	
					/*將mybook.flag設為"*"，表示設定刪除旗標*/
					printf("刪除作業...\n");
					strcpy(mybook.flag , "*");
				}
				printf("確定要執行嗎(Y/N)？");
				/*詢問是否執行異動資料的作業*/
				if(toupper(getche())=='Y')
				{
					/*檔案指標移到第recno筆資料位址*/
					fseek(fptr, sizeof(mybook)*recno, 0);
					/*將mybook寫入檔案指標目前所指的資料位址*/
					fwrite(&mybook, sizeof(mybook), 1, fptr);
					fclose(fptr);
					break;
				}
				else
				{
					printf("\n\n放棄執行...\n");
					exit(0);
				}
			}
			else
			{
				/*recno記錄編號加1，表示移到下一筆資料*/
				recno++;
			}
		}
	}
	printf("\n資料異動完成...\n");
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
  printf("\n%s 資料檔內容如下\n", vfpath);
  while(fread(&vbook, sizeof(vbook), 1, vfptr) != NULL)
  {
 	if(strcmp(vbook.flag, "*") != 0)
 	{
 		printf("%6s %30s %5d %5d\n", 
			 vbook.bookid, vbook.bookname, vbook.price, vbook.qty);
 		rectot++;
		}
  }
  printf("記錄總筆數：%d\n", rectot);
  fclose(vfptr);
 }

