#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <limits.h>
#include <stdlib.h>

int Floor(float x);
int Ceiling(float x);
int Fractional_part(float x); 
int XmodY(float x,float y);

int main(int argc, char *argv[]){
	errno = 0;
	char *endptr;
	if(argc==3 && (strcmp(argv[1],"floor"))==0){
		int x=strtol(argv[2], &endptr, 10);
   		if ((errno == ERANGE && (x == LONG_MAX || x == LONG_MIN))|| (errno != 0 && x == 0)) {
        	perror("strtol error");
        	return EXIT_FAILURE;
    	}
		Floor(x);
	}else if(argc==3 && (strcmp(argv[1],"ceiling"))==0){
		int x=atoi(argv[2]);
		Ceiling(x);
	}else if(argc==3 && (strcmp(argv[1],"fractal"))==0){
		int x=atoi(argv[2]);
		Fractional_part(x);
	}else if(argc==4 && (strcmp(argv[1],"mod"))==0){
		int x,y;
		x=atoi(argv[2]);
		y==atoi(argv[3]);
		XmodY(x,y);
	}else
		printf("Wrog arguments amount\nUsage:\n./zad1 function_name value_x value_y(opt)\nFunctions names:\nfloor\nceiling\nfractal\nmod\n");
	return 0;
}

int Floor(float x){
	
}

int Ceiling(float x){
	
}

int Fractional_part(float x){
	
}

int XmodY(float x,float y){

}
