#include<stdio.h>
#include<string.h>

int minuscola(char i){
  int min;
  if ('a'<=i && 'z'>=i) {
    min=1;
  }
  else{
    min=0;
  }
  return min;
}
int AlmenoUnaMinuscola(char string[30], int i){
  printf("%c\n", string[i]);
  int verificato=0;
  if (string[i]=='\0' && verificato==0) {
    verificato=0;
  }
  else{
    verificato = (minuscola(string[i])==1) || AlmenoUnaMinuscola(string, i+1);
  }
  return verificato;
}



int main() {
  char stringa[30];
  printf("Caro utente, inserisci una stringa: ");
  fgets(stringa, 30, stdin);

  int indice=0;

  int verificato;

  verificato=AlmenoUnaMinuscola(stringa, indice);
  if (verificato==1) {
    printf("La stringa contiene almeno una minuscola!\n\n");
  }
  else
    printf("La stringa non contiene almeno una minuscola!\n\n");


  return 0;
}
