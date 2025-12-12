/*

Dati di input: Sequenza di interi
Pre-condizioni: Elementi tutti interi

Dati di output: Un indice "i" della sequenza, se non esiste una soluzione
                ha -1 come valore di output
Post-condizioni: Gli interi con indice i, i+1, i+2, devono essere uguali

TIPO DI PROBLEMA: Verifica esistenziale.
*/


#include<stdio.h>

int uguali3(int interi[], int lunghezza){
    int minimo=-1;

    for(int i=0; i<lunghezza-2 && minimo==-1; i++){
      if((interi[i] == interi[i+1]) && (interi[i] == interi[i+2])){
        minimo = i;
      }

    }

return minimo;
}



int main() {
  int lun;
  int indice;
  printf("Caro utente, quanti interi vuoi inserire? ");
  scanf("%d", &lun);
  int sequenza[lun];


  for (int i=0; i<lun ; i++) {
    printf("Caro utente, inserisci un intero nella sequenza: ");
    scanf("%d", &sequenza[i]);
    }

  indice = uguali3(sequenza, lun);

  if(indice == -1)
    printf("Non esistono tre interi consecutivi uguali\n");
  else
    printf("Gli indici dei tre interi consecutivi uguali sono: %d, %d, %d,\n", indice, indice+1, indice+2);


}
