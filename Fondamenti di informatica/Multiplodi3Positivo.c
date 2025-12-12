#include<stdio.h>
#include<string.h>


int Multiplodi3Positivo(int *array, int lunghezza){
  printf("Blocco\n");
  printf("intero corrente: %d\n", array[lunghezza]);
  int verificato;
  if (lunghezza<0) {
    verificato=0;
  }

  else{
    verificato = ((array[lunghezza]%3)==0 && array[lunghezza]>0) || Multiplodi3Positivo(array, lunghezza-1);
    printf("Blocco3\n");
  }
  return verificato;
}
//SALVATAGGIO
void salvataggio(int *array){
  FILE* fp=fopen("sequenze.txt", "wb");
  if (fp==NULL) {
    printf("Salvataggio su file non riuscito!\n\n");
  }
  else{
    fprintf(fp, "%d\n", array);
  }
}
//ACQUISIZIONE
int* acquisizione(){
  FILE* fp= fopen("sequenze.txt", "rb");
  int *seq;

  if (fp == NULL) {
    printf("Apertura file non riuscita!\n\n");
  }
  else{
    while (fscanf(fp, "%d\n", seq)>0) {

    }

  }
}

//CONTATORE
int ContaNumeri(){
  FILE* fp= fopen("sequenze.txt", "rb");
  int conta;
  int i;
  if (fp==NULL) {
    printf("Apertura file non riuscita!\n\n\n\n\n");
  }
  else{
    while (fscanf(fp, "%d\n", i)>0) {
      conta++;
      i++;
    }
  }

  return conta;
}
int main() {
  int lun;//=ContaNumeri();
  int verificato;
  //int *sequenza=acquisizione();
  printf("Caro utente, inserisci la lunghezza dell'array: ");
  scanf("%d", &lun);

  int sequenza[lun];

  for (int i = 0; i < lun; i++) {
    printf("Caro utente, inserisci una cifra: ");
    scanf("%d", &sequenza[i]);
  }

  printf("La sequenza ha lunghezza %d\n\n", lun);

  verificato = Multiplodi3Positivo(sequenza, lun-1);
  printf("Qua mi sono bloccato\n");
  if (verificato==1) {
    printf("La sequenza contiene un Multiplo di 3 Positivo!\n\n");
  }
  else
    printf("La sequenza non contiene un Multiplo di 3 Positivo!\n\n");

  //salvataggio(sequenza);

  return 0;
}
