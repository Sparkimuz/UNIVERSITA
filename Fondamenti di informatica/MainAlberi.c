#include<stdio.h>
#include<stdlib.h>

int main() {
  int valore = 0;
  int scelta = 0;
  printf("Caro utente, scegli che azione fare sugli alberi:\n");
  printf("1: Aggiungi un nodo \n");
  printf("2: Rimuovi un nodo\n");
  printf("3: Cerca il valore di un nodo\n");
  printf("4: Conta altezza/numero dei nodi\n");
  scanf("%d", &scelta);
  if (scelta == 1){

    printf("Inserisci il valore del nodo da aggiungere\n");
    scanf("%d", &valore);
  }
  if (scelta == 2){
    printf("Inserisci il valore del nodo da cancellare\n");
    scanf("%d", &valore);
  }
  if (scelta == 3){
    printf("Inserisci il valore del nodo da cercare\n");
    scanf("%d", &valore);
  }

  return 0;
}
