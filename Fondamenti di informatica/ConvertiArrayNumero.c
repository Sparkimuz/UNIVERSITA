#include<stdio.h>
#include<string.h>


int ConvertiArrayNumeroRic(int i){
  int valore;

  if (i==0) {
    valore=1;
  }
  else{
    valore= 10 * ConvertiArrayNumeroRic(i-1);
  }
  return valore;
}
int ConvertiArrayNumero(int *array, int i, int lunghezza){
  int intero;
  if (lunghezza==-1) {
    intero=0;
  }
  else{
    intero = (array[lunghezza]*ConvertiArrayNumeroRic(i)) + ConvertiArrayNumero(array, i+1 , lunghezza-1);
  }
  return intero;
}


int main() {
  int lun;
  int intero;
  int i=0;
  printf("Caro utente, inserisci la lunghezza dell'array: ");
  scanf("%d", &lun);

  int sequenza[lun];

  for (int i = 0; i < lun; i++) {
    printf("Caro utente, inserisci una cifra: ");
    scanf("%d", &sequenza[i]);
  }

  intero = ConvertiArrayNumero(sequenza, i, lun-1);


  printf("L'intero e' %d!\n\n", intero);


  return 0;
}
