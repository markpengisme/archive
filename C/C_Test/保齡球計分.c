#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int g=0,j=0,p[22]={0},sum=0,keyin,ballnum=0;
	int score[11]={0};
	for(g=1;g<=10; g++)
	{
		if(g==10)//�ĤQ�� 
		{
			ballnum++;
			j++;
			printf(" �� %2d ���� %2d �y�G", g, ballnum);
			scanf("%d", &keyin);
			p[j]=keyin;
			if (keyin==10)//�Ĥ@�y10�� 
			{
				ballnum++;
				j++;
				printf(" �� %2d ���� %2d �y�G", g, ballnum);
				scanf("%d", &keyin);
				p[j]=keyin;
				if(keyin==10)//�ĤG�y10�� 
				{
					ballnum++;
					j++;
					printf(" �� %2d ���� %2d �y�G", g, ballnum);
					scanf("%d", &keyin);
					p[j]=keyin;
					break;
				}
				else//�ĤG�y�D10�� 
				{
					ballnum++;
					j++;
					printf(" �� %2d ���� %2d �y�G", g, ballnum);
					scanf("%d", &keyin);
					p[j]=keyin;
					break;
				}
			}
			else//�Ĥ@�y�D10�� 
			{
				ballnum++;
				j++;
				printf(" �� %2d ���� %2d �y�G", g, ballnum);
				scanf("%d", &keyin);
				p[j]=keyin;
				if(p[j]+p[j-1]==10)
				{
					ballnum++;
					j++;
					printf(" �� %2d ���� %2d �y�G", g, ballnum);
					scanf("%d", &keyin);
					p[j]=keyin;
					break;
				}
			}
		}
		else//�D�ĤQ�� 
		{	
			ballnum++;
			j++;
			printf(" �� %2d ���� %2d �y�G", g, ballnum);
			scanf("%d", &keyin);
			p[j]=keyin;
			if (keyin==10)//�Ĥ@�y10�� 
			{
				ballnum=0;
				continue; 
			}
			else//�Ĥ@�y�D10��
			{
				ballnum++;
				j++;
				printf(" �� %2d ���� %2d �y�G", g, ballnum);
				scanf("%d", &keyin);
				p[j]=keyin;
				ballnum=0;
				continue;
			}
		}
	}
		/*�p��C�����o��*/
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

		/*�L�X�C�����o���A�H�έp��O�ֲy���`��*/
		for(g=1; g<=10; g++)
		{
			printf(" �� %2d �����ơG%d\n", g, score[g]);
			sum+=score[g];
		}
		printf(" ====================\n");

		/*�L�X�O�ֲy���`��*/
		printf(" �O�ֲy�`���G %d\n\n", sum);


  system("PAUSE");
  return 0;
}

