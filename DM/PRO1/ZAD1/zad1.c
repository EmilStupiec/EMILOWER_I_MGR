#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <limits.h>
#include <stdlib.h>
#include <math.h>//only for INFINITY NAN HUGE_VAL HUGE_VALF HUGE_VALL

int Floor(float x,int res);
int Ceiling(float x,int res);
float Fractional_part(float x); 
int XmodY(int x,int y);
void strtol_error_check(float x);

int main(int argc, char *argv[]){
	errno = 0;
	char *endptr;
	if(argc==3 && (strcmp(argv[1],"floor"))==0){
		float x=strtof(argv[2], &endptr);
		strtol_error_check(x);
		printf("Floor function result for x=%f is %d\n",x,Floor(x,0));
	}else if(argc==3 && (strcmp(argv[1],"ceiling"))==0){
		float x=strtof(argv[2], &endptr);
		strtol_error_check(x);
		printf("Celiing function result for x=%f is %d\n",x,Ceiling(x,0));
	}else if(argc==3 && (strcmp(argv[1],"fract"))==0){
		float x=atof(argv[2]);
		printf("Fractional part function result for x=%f is %f\n",x,Fractional_part(x));
	}else if(argc==4 && (strcmp(argv[1],"mod"))==0){
		int x,y;
		x=strtol(argv[2], &endptr, 10);
		strtol_error_check(x);
		errno = 0;
		y=strtol(argv[3], &endptr, 10);
		strtol_error_check(x);
		printf("%dmod%d=%d\n",x,y,XmodY(x,y));
		XmodY(x,y);
	}else
		printf("Wrog arguments amount\nUsage:\n./zad1 function_name value_x value_y(opt)\nFunctions names:\nfloor\nceiling\nfract\nmod\n");
	return 0;
}

int Floor(float x,int res){
	if(x>=0)
		if(x<1)
			return res;
		else
			Floor(x-=1.0,++res);
	else
		if(x>-1)
			return --res;
		else
			Floor(x+=1.0,--res);
}

int Ceiling(float x,int res){
	if(x>0)
		if(x<1)
			return ++res;
		else
			Ceiling(x-=1.0,++res);
	else
		if(x>-1)
			return res;
		else
			Ceiling(x+=1.0,--res);
}

float Fractional_part(float x){
	return x-(float)Floor(x,0);
}

int XmodY(int x,int y){
	return x-y*(Floor((float)x/y,0));
}
void strtol_error_check(float x){
	if ((errno == ERANGE && (x == HUGE_VAL))|| (errno != 0 && x == 0)) {
        perror("strtol error");
        exit(EXIT_FAILURE);
    }
}
