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
	printf(" �п�J���Ѫ����(�榡yy/mm/dd)�G");
	scanf("%d/%d/%d", &year, &month, &day);	/* �ϥΪ̿�J��� */

	printf("\n\n ���ѬO : %d�~ %d�� %d�� ! ... ^_^\n\n", year, month, day);
	switch(month)
	{
	case January:
		printf(" %2d�� �S�O�s���@�~�}�l ...", January);
		break;
	case February:
		printf(" ��v���H�`�b %2d ��A�O�o�e§����������", February);
		break;
	case March:
		printf(" %2d ���H������ , �s�Ǵ��}�l ! ....", March);
		break;
	case April:
		printf(" %2d �릳�K���A�n�n�𮧧a ! ....", April);
		break;
	case May:
		printf(" %2d / 1 �Ұʸ`�A�Ҥu���S�̺֮�� ! ....", May);
		break;
	case June:
		printf(" %2d �� �����Ҩ�F ! ...... #_#", June);
		break;
	case July:
	case August:
		printf(" 7, 8 ��O�������� .....^_^" );
		break;
	case September:
	case October:
	case November:
		printf(" 9, 10, 11����n ..." );
		break;
	case December:
	printf(" %2d ����{�A�t�ϸ`�֨�F", December);
	break;
	}
	printf("\n\n");
    system("PAUSE");	
    return 0;
}
