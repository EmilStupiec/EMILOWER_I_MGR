#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <stdlib.h>
#include <limits.h>
#include <math.h>//only for INFINITY NAN HUGE_VAL HUGE_VALF HUGE_VALL

void check_if_permutation(int *permutation,int n);
void generate_all_permutation_of_n(int n);
void sort(int *array,int n);

int main(int argc, char *argv[]){
	int n,*permutation,i;
	char *endptr;
	if(argc<2){
		perror("Usage: ./zad3 int int int ... int\n");
        exit(EXIT_FAILURE);
	}
	n=argc-1;
	permutation=(int*)malloc(n*sizeof(int));
	for(i=0;i<n;i++){
		permutation[i]=strtol(argv[i+1],&endptr,10);
		if ((errno == ERANGE && (permutation[i] == LONG_MAX || permutation[i] == LONG_MIN)) || (errno != 0 && permutation[i] == 0)) {
       		perror("strtol error");
        	exit(EXIT_FAILURE);
    	}
    	if (endptr == argv[i+1]) {
        	fprintf(stderr, "No digits were found\n");
        	exit(EXIT_FAILURE);
    	}
    }
    if(n==1 && permutation[0]==1){
    	printf("1 is a permutation and it's only one permutation\n");
    	return 0;
    }else if(n==1 && permutation[0]!=1){
    	printf("%d is not a permutation and only permutation for one elmement is (1)\n",permutation[0]);
    	return 0;
    }
    printf("Given sequence\n(");
	for(i=0;i<n;i++)
		printf("%d,",permutation[i]);
	printf("\b)\n");
	check_if_permutation(permutation,n);
	generate_all_permutation_of_n(n);
	return 0;
}

void check_if_permutation(int *permutation,int n){
	int i;
	sort(permutation,n);
	printf("Given sequence\n(");
	for(i=0;i<n;i++)
		printf("%d,",permutation[i]);
	printf("\b)\n");
}

void generate_all_permutation_of_n(int n){
	
}

void sort(int *array,int n){
	int i,j,temp,swaped;
	swaped=0;
	while(swaped==0)
		for(i=1;i<n;i++){
			if(array[i-1]>array[i]){
				temp=array[i-1];
				array[i-1]=array[i];
				array[i]=temp;
				swaped=1;
			}
		}
}
