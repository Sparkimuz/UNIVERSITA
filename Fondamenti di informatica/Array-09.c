/*

  Dati di input: Sequenza di interi
  Pre-requisiti: Gli elementi della sequenza devono essere interi

  Dati di output: 1, se l'istanza è positiva, 0 se l'istanza è negativa
  Post-requisiti: L'istanza è positiva se la sequenza di interi è palindroma, viceversa se non lo è.

  TIPO DI PROBLEMA: Verifica universale.


*/

#include<stdio.h>

int palindroma(int sequenza[], int lunghezza){

  int verificato=1;

  for(int i=0; i<=(lunghezza/2); i++){
    if(sequenza[i]!=sequenza[lunghezza-i-1])
      verificato=0;

  }

  return verificato;
}


int main() {
  int lun, ver;

  printf("Caro utente, quanti interi vuoi introdurre: ");
  scanf("%d", &lun);

  int seq[lun];

  for(int i=0; i<lun; i++){
    printf("Caro utente, introdurre un intero: ");
    scanf("%d", &seq[i]);
  }

  ver= palindroma(seq, lun);
  if(ver==1)
    printf("Caro utente, la sequenza da lei introdotta %c palindroma!\n", 138);
  else
    printf("Caro utente, la sequenza da lei introdotta non %c palindroma!\n", 138);

  return 0;
}
