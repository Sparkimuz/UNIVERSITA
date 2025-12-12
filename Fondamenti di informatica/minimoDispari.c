#include<stdio.h>

//funzione ricorsiva minimoDispari che verifica se, in un array di numeri interi,
//ogni tripla di interi consecutivi nella sequenza è tale che il minimo fra i tre interi è dispari.
//di interi consecutivi nella sequenza è tale che il minimo fra i tre interi è dispari.


int minimoDispariRic(int *seq){
  int minimo;
  if((seq[0]<seq[1])&&(seq[0]<seq[2]))
    minimo= seq[0];
  else{
    if ((seq[1]<seq[0])&&(seq[1]<seq[2])) {
      minimo= seq[1];

    }
    else
    minimo= seq[2];

  }
  return minimo;
}
int minimoDispari(int *array, int lun){
  int verificato=1;
  //passo Base
  if (lun<=2) {
    verificato=1;
  }
  else{
    verificato= (minimoDispariRic(&array[0])%2==1) && minimoDispari(array+1, lun-1);
  }
  return verificato;
}



int main() {
  int lun;
  printf("Quanto è lunga la sequenza?\n");
  scanf("%d", &lun);

  int array[lun];
  printf("Caro utente, inserisci gli interi nella sequenza:\n");
  for (int i=0;  i< lun; i++) {
    printf("Insersci un intero: ");
    scanf("%d", &array[i]);
  }

  int risultato=minimoDispari(array, lun);

  if (risultato==1)
    printf("Nella sequenza per ogni tripla il minimo è dispari!\n\n");
  else
    printf("Nella sequenza per ogni tripla il minimo non è dispari!\n\n");

  return 0;
}
