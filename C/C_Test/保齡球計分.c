#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int g=0,j=0,p[22]={0},sum=0,keyin,ballnum=0;
	int score[11]={0};
	for(g=1;g<=10; g++)
	{
		if(g==10)//第十局 
		{
			ballnum++;
			j++;
			printf(" 第 %2d 局第 %2d 球：", g, ballnum);
			scanf("%d", &keyin);
			p[j]=keyin;
			if (keyin==10)//第一球10分 
			{
				ballnum++;
				j++;
				printf(" 第 %2d 局第 %2d 球：", g, ballnum);
				scanf("%d", &keyin);
				p[j]=keyin;
				if(keyin==10)//第二球10分 
				{
					ballnum++;
					j++;
					printf(" 第 %2d 局第 %2d 球：", g, ballnum);
					scanf("%d", &keyin);
					p[j]=keyin;
					break;
				}
				else//第二球非10分 
				{
					ballnum++;
					j++;
					printf(" 第 %2d 局第 %2d 球：", g, ballnum);
					scanf("%d", &keyin);
					p[j]=keyin;
					break;
				}
			}
			else//第一球非10分 
			{
				ballnum++;
				j++;
				printf(" 第 %2d 局第 %2d 球：", g, ballnum);
				scanf("%d", &keyin);
				p[j]=keyin;
				if(p[j]+p[j-1]==10)
				{
					ballnum++;
					j++;
					printf(" 第 %2d 局第 %2d 球：", g, ballnum);
					scanf("%d", &keyin);
					p[j]=keyin;
					break;
				}
			}
		}
		else//非第十局 
		{	
			ballnum++;
			j++;
			printf(" 第 %2d 局第 %2d 球：", g, ballnum);
			scanf("%d", &keyin);
			p[j]=keyin;
			if (keyin==10)//第一球10分 
			{
				ballnum=0;
				continue; 
			}
			else//第一球非10分
			{
				ballnum++;
				j++;
				printf(" 第 %2d 局第 %2d 球：", g, ballnum);
				scanf("%d", &keyin);
				p[j]=keyin;
				ballnum=0;
				continue;
			}
		}
	}
		/*計算每局的得分*/
		for(g=1, j=1; g<=10; g++)
		{
			if(p[j]==10)
			{
				score[g]=p[j]+p[j+1]+p[j+2];
				j++;
			}
			else if(p[j]+p[j+1]==10)
			{
				score[g]=p[j]+p[j+1]+p[j+2];
				j+=2;
			}
			else
			{
				score[g]=p[j]+p[j+1];
				j+=2;
			}
		}
		printf("\n");
		printf(" ====================\n");

		/*印出每局的得分，以及計算保齡球的總分*/
		for(g=1; g<=10; g++)
		{
			printf(" 第 %2d 局分數：%d\n", g, score[g]);
			sum+=score[g];
		}
		printf(" ====================\n");

		/*印出保齡球的總分*/
		printf(" 保齡球總分： %d\n\n", sum);


  system("PAUSE");
  return 0;
}

