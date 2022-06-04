#include <stdio.h>
#include <stdlib.h>
enum month
{
    January=1,February,March,April,May,June,July,
    August,September,October,November,December
};
int main(int argc, char *argv[])
{

  	int year=0,month=0,day=0;
	printf(" 請輸入今天的日期(格式yy/mm/dd)：");
	scanf("%d/%d/%d", &year, &month, &day);	/* 使用者輸入日期 */

	printf("\n\n 今天是 : %d年 %d月 %d日 ! ... ^_^\n\n", year, month, day);
	switch(month)
	{
	case January:
		printf(" %2d月 又是新的一年開始 ...", January);
		break;
	case February:
		printf(" 西洋情人節在 %2d 月，記得送禮物給阿那答", February);
		break;
	case March:
		printf(" %2d 月初寒假結束 , 新學期開始 ! ....", March);
		break;
	case April:
		printf(" %2d 月有春假，好好休息吧 ! ....", April);
		break;
	case May:
		printf(" %2d / 1 勞動節，勞工的兄弟福氣啦 ! ....", May);
		break;
	case June:
		printf(" %2d 月 期末考到了 ! ...... #_#", June);
		break;
	case July:
	case August:
		printf(" 7, 8 月是暑假期間 .....^_^" );
		break;
	case September:
	case October:
	case November:
		printf(" 9, 10, 11月秋高氣爽 ..." );
		break;
	case December:
	printf(" %2d 月來臨，聖誕節快到了", December);
	break;
	}
	printf("\n\n");
    system("PAUSE");	
    return 0;
}
