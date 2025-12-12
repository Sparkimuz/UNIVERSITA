#include<stdio.h>
#include<string.h>

int ContaCaratteriStringaRic(char b, char c){
  int presente=0;
  if (b==c) {
    presente=1;
  }
  else{
    presente=0;
  }


  return presente;
}

int ContaCaratteriStringa(char string[30], char c, int i){

  int volte;
  if (string[i]=='\0') {
    volte=0;
  }
  else{
    volte=ContaCaratteriStringaRic(string[i], c) + ContaCaratteriStringa(string, c, i+1);
  }
  return volte;
}

int main() {
  char stringa[30];
  printf("Caro utente, inserisci una stringa: ");
  fgets(stringa, 30, stdin);

  char c;
  printf("Caro utente, inserisci il carattere da contare: ");
  scanf("%c%*c", &c);


  int indice=0;

  int volte=0;

  volte=ContaCaratteriStringa(stringa, c, indice);

  printf("Il carattere e' ripetuto %d volte nella stringa!\n\n", volte);


  return 0;
}
