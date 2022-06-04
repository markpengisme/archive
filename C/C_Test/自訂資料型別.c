#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char STRING[10];
typedef int INTEGER;
typedef float REAL;
struct score
{
	STRING name;		/* char name[10];	*/
	INTEGER hw;  	/* int hw;    		*/
	INTEGER mid;    /* int mid;   		*/
	INTEGER final;  	/* int final;		*/
	REAL avg;      	/* float avg;		*/
};

typedef struct score COURSE;	/* COURSE 取代 struct score	*/
COURSE bcc;				/* typdef struct score bcc	*/
COURSE average(STRING tname,int thw,int tmid,int tfinal)
{
	COURSE tbcc;
	strcpy(tbcc.name,tname);
	tbcc.hw = thw;
	tbcc.mid = tmid;
	tbcc.final=tfinal;
	tbcc.avg=(tbcc.hw*0.3+tbcc.mid*0.3+tbcc.final*0.4);
	return tbcc;
}

int main(int argc, char *argv[])
{
	COURSE no1;
	no1 = average("David", 81, 80, 80);
	printf("  姓名     作業    期中考   期末考    平  均 \n");
	printf(" =======  =======  =======  =======   ======= \n");
	printf("  %s     %d       %d       %d     %7.2f \n", 
		no1.name, no1.hw, no1.mid, no1.final, no1.avg);
    system("PAUSE");	
    return 0;
}
