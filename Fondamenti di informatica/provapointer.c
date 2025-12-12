#include<stdio.h>

int main(){


struct nigga {
  int brain;
  struct nigga *prossimo;
};


struct nigga n;

n.brain= 5;


struct nigga x;


n.prossimo= &x;

x.brain= 10;


printf("Prossimo brain= %d\n", (n.prossimo->brain));

printf("Nigga brain= %d\n", n.brain);


}
