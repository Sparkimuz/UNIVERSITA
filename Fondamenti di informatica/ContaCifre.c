#include<stdio.h>
#include<string.h>

int ContaCifre(int n){
int cifre=1;
if (n/10==0) {
  cifre=1;
}
else{
  cifre=  cifre + ContaCifre(n/10);
}

return cifre;
}


int main() {
  int intero;
  printf("Caro utente, inserisci un intero: ");
  scanf("%d", &intero);


  int cifre=0;

  cifre=ContaCifre(intero);

  printf("L'intero e' formato da %d cifre!\n\n", cifre);


  return 0;
}
