#include<stdio.h>


int PariPositivo(int seq[], int lun){

  int i=0;

  int risultato=0;

  if (lun<2) {
    risultato=0;
  }
  else {
    risultato = ((seq[lun]%2 && seq[lun-1]>0) || (seq[lun]>0 && seq[lun-1]%2)) || PariPositivo(seq, lun-1)

  }

  return risultato;
}
