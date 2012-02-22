#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <limits.h>
#include <stdlib.h>
#include <math.h>//only for INFINITY NAN HUGE_VAL HUGE_VALF HUGE_VALL
#include <float.h>

struct list{
   long value;
   struct list * next;
};

typedef struct list primes;
   
double power(double m,int exp);
double root(double a,int n);
double absolute(double x);
int XmodY(int x,int y);
int Floor(float x,int res);

int main(int argc, char *argv[]){
	char *endptr;
	long limit,j,x,y,n;
	int i,*is_prime;
	primes *current,*head;
	errno = 0;
	head = NULL;
	if(argc==2){
		limit=strtol(argv[1],&endptr,10);
	}else
		printf("Wrog arguments amount\nUsage:\n./zad2 limit_number");
	if ((errno == ERANGE && (limit == LONG_MAX || limit == LONG_MIN)) || (errno != 0 && limit == 0)) {
        perror("strtol error");
        exit(EXIT_FAILURE);
    }
	if (endptr == argv[1]) {
        fprintf(stderr, "No digits were found\n");
        exit(EXIT_FAILURE);
    }
    //Sieve of Atkin
    is_prime = (int*) malloc(limit*sizeof(int));
    for(i=0;i<limit;i++)
		is_prime[i]=0;
    for(x=1;x<=root(limit,2);x++)
    	for(y=1;y<=root(limit,2);y++){
    		n=4*x*x+y*y;
    		if(n<=limit && (XmodY(n,12)==1 || XmodY(n,12)==5))
    			is_prime[n]=absolute(--is_prime[n]);
    		n=3*x*x+y*y;
    		if(n<=limit && (XmodY(n,12)==7))
    			is_prime[n]=absolute(--is_prime[n]);
    		n=3*x*x-y*y;
    		if(x>y && n<=limit && (XmodY(n,12)==11))
    			is_prime[n]=absolute(--is_prime[n]);
    	}
    for(i=5;i<=root(limit,2);i++){
    	if(is_prime[i]==1){
    		long s=i*i;
    		for(j=s;j<=limit;j+=s)
    			is_prime[j]=0;
    	}
    }
    current=(primes*)malloc(sizeof(primes));
	current->value=2;
	current->next=head;
    head=current;
    current=(primes*)malloc(sizeof(primes));
	current->value=3;
	current->next=head;
    head=current;
    for(i=5;i<=limit;i+=2){
    	if(is_prime[i]==1){
			current=(primes*)malloc(sizeof(primes));
			current->value=i;
			current->next=head;
    		head=current;
    	}
   	}
   	current=head;
	while(current){
    	printf("%ld\n", current->value);
     	current = current->next ;
   	}
	return 0;
}

double power(double m,int exp){
	double power=m;
	int i;
	if(exp==0)
		return 1;
	else
		for(i=0;i<exp-1;i++)
			power*=m;
	return power;
}

double root(double a,int n){
	double x0, x = 1;
	if (!a) return 0;
	if (n < 1 || (a < 0 && !(n&1))) return 0./0.;
	do {	
		x0 = x;
		x = ((n - 1) * x + a / power(x,(n-1)))/n;
	}while(absolute(x0-x)>=absolute(x)*(DBL_EPSILON*10));
	return x;
}

double absolute(double x){ 
	return x >= 0 ? x : -x;
}

int XmodY(int x,int y){
	return x-y*(Floor((float)x/y,0));
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
