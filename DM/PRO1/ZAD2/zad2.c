//Sieve of Atkin
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <limits.h>
#include <stdlib.h>
#include <math.h>//only for INFINITY NAN HUGE_VAL HUGE_VALF HUGE_VALL

struct list{
   long value;
   struct list * next;
};

typedef struct list primes;
   
int main(int argc, char *argv[]){
	char *endptr;
	long limit;
	int i;
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
    for(i=1;i<=limit;i++) {
		current=(primes*)malloc(sizeof(primes));
		current->value=i;
		current->next=head;
    	head=current;
   	}
	current=head;
	while(current) {
    	printf("%ld\n", current->value);
     	current = current->next ;
   	}
	return 0;
}
