#include<stdio.h>

int valore_massimo_array(int *A, int len){
    int massimo=0;
    for(int t=0; t<len; t++){
        if(A[t]>massimo){
            massimo=A[t];
        }

    }
return massimo;
}


int main() {
  int len;
  printf("Caro utente, inserisci la lunghezza dell'array: ");
  scanf("%d", &len);
  int A[len];
  printf("Caro utente inserisci i valori dell'array: ");
  for(int i=0; i<len; i++){
      printf("inserisci un intero: ");
      scanf("%d", &A[i]);
      }
  int max = valore_massimo_array(A, len);
 printf("Il valore massimo della sequenza: %d\n", max);

}
