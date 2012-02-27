#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <stdlib.h>
#include <limits.h>
#include <math.h>//only for INFINITY NAN HUGE_VAL HUGE_VALF HUGE_VALL

void check_if_permutation(int *permutation,int n);
void generate_all_permutation_of_n(int *permutation,int n);
void sort(int *array,int n);
long factorial(int n);
void swap(int *a,int *b);
void print_permutation(int *permutation,int n);
void req_perm_gen(int *permutation,int n,int req);

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
	printf("All permutations for %d elements\n",n);
	generate_all_permutation_of_n(permutation,n);
	return 0;
}

void check_if_permutation(int *permutation,int n){
	int i,if_perm;
	sort(permutation,n);
	if_perm=0;
	for(i=0;i<n;i++){
		if(permutation[i]!=i+1){
			if_perm=1;
			break;
		}
	}
	if(if_perm==1)
		printf("is not permutation\n");
	else
		printf("is permutation\n");
}

void generate_all_permutation_of_n(int *permutation,int n){
	int i;
	for(i=0;i<n;i++){
    	permutation[i]=0;
  	}
  	req_perm_gen(permutation,n,0);
}
	/*int i,j,*last_pointer,*first_pointer;
	last_pointer=permutation+n-1;
	/*for(i=0;i<factorial(n);i++){
		if(one_pointer!=&permutation[n-1]){
			swap(one_pointer,one_pointer+1);
			one_pointer++;
		}else{
			swap(one_pointer,permutation);
			one_pointer=permutation;
		}
		print_permutation(permutation,n);
	}
	//printf("%d\n",*last_pointer);
	for(i=0;i<n-1;i++){
		swap(last_pointer,last_pointer--);
		print_permutation(permutation-zero,n+zero);
	}
	if(n>1)
		generate_all_permutation_of_n(++zero,++permutation,n-1);
	else
		return;
	//printf("%d %d %d\n",*last_pointer,n,zero);
	for(i=0;i<n-1;i++){
		swap(last_pointer,last_pointer++);
		print_permutation(permutation-zero,n+zero-1);
	}*/
//}

void sort(int *array,int n){
	int i,j,swaped;
	do{
		swaped=0;
		for(i=1;i<n;i++){
			if(array[i-1]>array[i]){
				swap(&array[i-1],&array[i]);
				swaped=1;
			}
		}
	}while(swaped==1);
}

long factorial(n){
	if(n>1)
		return n*factorial(n-1);
	else
		return 1;
}

void swap(int *a,int *b){
	int c;
	c=*a;
	*a=*b;
	*b=c;
}

void print_permutation(int *permutation,int n){
	int i;
	printf("(");
	for(i=0;i<n;i++)
		printf("%d,",permutation[i]);
	printf("\b)\n");
}

void req_perm_gen(int *permutation,int n,int req){
 	static int level = -1;
 	int i;
  	level = level+1;
  	permutation[req]=level;
  	if (level==n)
    	print_permutation(permutation,n);
    else
    	for (i=0;i<n;i++)
      		if (permutation[i]==0)
         		req_perm_gen(permutation,n,i);
  	level=level-1;
  	permutation[req]=0;
}
