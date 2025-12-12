#include<stdio.h>
#include<stdlib.h>

int esattamenteDue(int *array, int lun){
  int verificato=1;
  if (lun<3) {
    verificato=1;
  }
  else{
    verificato =((array[lun-1]>0 && array[lun-2]>0 && array[lun-3]<=0 || array[lun-1]>0 && array[lun-2]<=0 && array[lun-3]>0 || array[lun-1]<=0 && array[lun-2]>0 && array[lun-3]>0) && esattamenteDue(array, lun-1));
      }
  return verificato;
}


int main() {
  int lun;


  printf("Caro utente, sono una funzione che riceve una sequenza di numeri e ti dice se ogni tripla di quella sequenza ha esattamente due positivi\n");



  printf("Inserisci la lunghezza della sequenza: \n");
  scanf("%d", &lun);

  int array[lun];


  for(int i=0;  i<lun; i++) {
    printf("Caro utente inserisci un intero nella sequenza: \n");
    scanf("%d", &array[i]);
  }

  int vero = esattamenteDue(array, lun);

  if (vero==1){
    printf("La funzione contiene solamente triple con esattamente due positivi\n\n");
  }
  else{
    printf("La funzione non contiene solamente triple con esattamente due positivi\n\n");
  }
  return 0;
}
