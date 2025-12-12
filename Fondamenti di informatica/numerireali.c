#include<stdio.h>
#include<stdlib.h>

//STRUTTURE
typedef struct numeroReale{
  int re;
  int de;
}REAL;

typedef struct nodo{
  REAL r;
  struct nodo* next;
}NODO;


//CREAZIONE NUOVO NUMERO REALE
REAL NewReal(){
  REAL r;

  printf("Caro utente inserisci la parte reale e decimale del tuo numero reale:\n");
  printf("Parte reale: ");
  scanf("%d", &r.re);
  printf("Parte decimale: ");
  scanf("%d", &r.de);

  return r;
}


//INSRIMENTO IN TESTA

NODO* inserisciT(NODO* lista, REAL real){
  NODO* nuovoNodo=malloc(sizeof(NODO));

  nuovoNodo->r=real;
  nuovoNodo->next=lista;

  printf("Inserimento effettuato\n\n");

  return nuovoNodo;
}
//INSERIMENTO IN CODA
NODO* inserisciC(NODO* lista, REAL real){
  NODO* nuovoNodo=malloc(sizeof(NODO));
  NODO* app=lista;


  nuovoNodo->r=real;

  if (lista==NULL) {

    nuovoNodo->next=NULL;
    lista=nuovoNodo;
  }
  else{
  while (app->next!=NULL) {
    app=app->next;
  }
  app->next=nuovoNodo;
  nuovoNodo->next=NULL;
  //free(app);//potrebbe creare problemi
}
printf("Inserimento effettuato\n\n");

return lista;
}

//VISUALIZZAZIONE

void Visualizza(NODO* lista){
  if (lista==NULL) {
    printf("la lista non contiene elementi\n\n");
  }
  else{
    printf("Ecco la lista di numeri reali:  ");
    while (lista!=NULL) {
      printf("%d,%d; ", lista->r.re, lista->r.de);
      lista=lista->next;
    }
    printf("\n\n");
  }
}

//SALVATAGGIO
void salvataggio(NODO* lista){
  FILE* fp=fopen("numerir.txt", "w");

  while (lista!=NULL) {
    fprintf(fp, "%d %d\n", lista->r.re, lista->r.de);
    lista=lista->next;
  }

  printf("Salvataggio riuscito!\n");
  fclose(fp);


}

//ACQUISIZIONE

NODO* acquisizione(){
  FILE* fp=fopen("numerir.txt", "r");
  NODO* testa=malloc(sizeof(NODO));
  NODO* lista=testa;
  REAL real;

  if (fp==NULL) {
    printf("Apertura del file non riuscita!\n\n");
    }
  else{
    if (fscanf(fp, "%d %d", real.re, real.de)==0) {
      printf("Il file non contiene numeri reali\n\n");
    }
    else{
      while (fscanf(fp, "%d %d", real.re, real.de)>0) {
        lista->r=real;
        lista=lista->next;
      }
      printf("Numeri reali recuperati!\n\n");
    }

  }
  return testa;
}


//MAIN

int main() {
  NODO* lista=acquisizione();
  int scelta=-1;

  while (scelta!=0) {
    printf("Che cosa vuoi fare?\n");
    printf("1) Inserisci un numero reale in testa\n");
    printf("2) Inserisci un numero reale in coda\n");
    printf("3) Visualizza la lista dei numeri reali\n");
    printf("0) Esci dall'applicazione\n");
    scanf("%d", &scelta);

    if (scelta==1) {
      lista=inserisciT(lista, NewReal());
    }
    else if (scelta==2){
      lista=inserisciC(lista, NewReal());

    }
    else if (scelta==3){
      Visualizza(lista);
    }
  }
  salvataggio(lista);
  return 0;
}
