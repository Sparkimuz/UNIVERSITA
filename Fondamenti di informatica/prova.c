#include <stdio.h>

/* SPECIFICA DEL PROBLEMA:

   Input: Una sequenza di interi.
   Pre-condizione: La sequenza deve contenere almeno tre interi.

   Output: La somma massima tra tutte le terne della sequenza.
   Post-condizione: Il risultato deve essere maggiore di ogni possibile
   somma di terne della sequenza.

   TIPO DI PROBLEMA: Minimo/Massimo
*/
int sommaMassima(int lunghezza, int interi[]) {
  int Somma;
  int maxSomma;

  for(int i=0; i<(lunghezza-2); i++){
    Somma = interi[i] + interi[i+1] + interi[i+2];
    if(Somma > maxSomma) {
      maxSomma = Somma;
    }
  }
return Somma;
}


int main() {
  int len=0;
  int maxSum=0;

  printf("Caro utente, quanti interi vuoi inserire?\n");
  scanf("%d", &len);

  int seqInt[len];

  for(int i=0; i<len; i++){
    printf("Caro utente, inserisci un numero nella sequenza:");
    scanf("%d", &seqInt[i]);
  }


  printf("La somma massima della sequenza è %d\n", sommaMassima(len, seqInt));


}
