#include<stdio.h>



float potenza(float base, int esponente){

  float risultato=0;

  if(esponente==0){
    risultato=1;
  }
  else{
    risultato = (base * potenza(base, esponente-1));
  }
  return risultato;
}

float polinomio(float array[], int grd, float valx){

  float ris=0;

  if(grd==0){
    ris = array[grd];
  }
  else{
    ris = (array[0]* potenza(valx, grd)) + polinomio(array+1, grd-1, valx);
  }

  return ris;
}

int main() {

  float x;
  int n;


  printf("Caro utente sono un programma che calcola il valore di un polinomio:\n");
  printf("Inserisci il valore della variabile:\n");
  scanf("%f", &x);
  printf("Inserisci il grado massimo del polinomio:\n");
  scanf("%d", &n);

  float coeff[n+1];

  for (int i=0; i<=n; i++) {
    printf("Inserisci il coefficiente del polinomio (dal grado più alto)\n");
    scanf("%f", &coeff[i]);
  }

  printf("Il valore della base %.2f, alla %d, vale %.2f\n", x, n, potenza(x, n));

  printf("Il polinomio vale: %.2f\n", polinomio(coeff, n, x));


}
