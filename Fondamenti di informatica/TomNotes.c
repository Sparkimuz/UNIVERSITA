#include<stdio.h>
#include<math.h>

//FUNZIONI

int richiesta(int req){
  printf("Caro utente, inserisci il numero dell'azione che vorresti eseguire:\n");
  printf("1) Crea una nuova nota;\n");
  printf("2) Leggi e/o modifica una nota\n;");
  printf("3) Cancella una nota;\n");
  scanf("%d", &req);
}

//STRUTTURE


struct nota {
  char title[20];
  char array[100];

} NOTA;
//MAIN

int main(){
  NOTA listaNote[25];
  int cho;
  int ini;
  printf("Caro utente, benvenuto nelle tue note!\n");
  printf("[Inizia a scrivere(1)]\n");
  printf("[Esci dalle note(0)]\n");
  scanf("%d", &ini);

  if (ini==1) {
    richiesta(cho);
    if (cho==1) {
      printf("Inserisci il titolo della nota\n");
      scanf("%s\n", listaNote(1).title);
      listaNote(1).title = ""

    }
  }
  else
    return 0;


  return 0;
}
