#include<stdio.h>


int TuttiAlternati(int array[], int lun){

  int esiste=0;

  if (lun<=1){
    esiste=1;
  }
  else
    esiste = ((array[lun-1]<0 && array[lun-2]>=0) || (array[lun-1]>= && array[lun-2]<0)) && TuttiAlternati(array[], )


}
