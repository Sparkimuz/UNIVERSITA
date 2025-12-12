#include<stdio.h>
#include<stdlib.h>

//STRUTTURE
typedef struct data{
  int g;
  int m;
  int a;
}DATA;

typedef struct persona{
  char nome[20];
  char cognome[20];
  DATA nascita;
}PERS;

typedef struct nodo{
  PERS p;
  struct nodo* next;
}NODO;

//CREA UNA NUOVA PERSONA
PERS NewPers(){
  PERS pp;

  //printf("Caro utente, inserisci il nome, il cognome e la data di nascita:\n");
  printf("Nome: ");
  fgets(pp.nome, 20, stdin);
  printf("Cognome: ");
  fgets(pp.cognome, 20, stdin);
  printf("Giorno: ");
  scanf("%d%*c", &pp.nascita.g);
  printf("Mese: ");
  scanf("%d%*c", &pp.nascita.m);
  printf("Anno: ");
  scanf("%d%*c", &pp.nascita.a);



  return pp;
}
//VISUALIZZA
void visualizzaLista(NODO* lista){
  if (lista==NULL)
    printf("La lista non contiene persone!\n");
  else{
  while (lista!=NULL) {
    printf("Nome: %s Cognome: %s ", lista->p.nome, lista->p.cognome);
    printf(" Data di nascita: %d/%d/%d\n\n", lista->p.nascita.g, lista->p.nascita.m, lista->p.nascita.a);
    lista=lista->next;
  }
}
}
//INSERISCI IN CODA
NODO* inserisciCoda(NODO* lista, PERS pp){
    NODO* nuovoNodo= malloc(sizeof(NODO));
    NODO* app = lista;



    nuovoNodo->p=pp;


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
    }

    printf("Inserimento effettuato!\n\n");
    return lista;
}
//CANCELLA TESTA
NODO* eliminaTesta(NODO* lista){
  NODO* testaNuova=NULL;

  if (lista==NULL) {
    printf("La lista non contiene elementi da eliminare!\n\n");

  }
  else{
    testaNuova=lista->next;

    printf("Primo elemento della lista cancellato!\n\n");

  } //if(lista->next)
  return testaNuova;
  }

//SALVATAGGIO
void salvataggio(NODO* lista){
  FILE* fp=fopen("persone.txt", "w");
  if (fp==NULL) {
    printf("Salvataggio del file non riuscito\n\n");
  }
  else{
    while (lista!=NULL) {
      fprintf(fp, "%s %s %d %d %d\n", lista->p.nome, lista->p.cognome, lista->p.nascita.g, lista->p.nascita.m, lista->p.nascita.a);
      lista=lista->next;
  }
  fclose(fp);
  printf("Salvataggio del file riuscito\n\n");
}
}
//ACQUISIZIONE

NODO* acquisizione(){
  FILE* fp=fopen("persone.txt", "r");
  NODO* testa= NULL;
  //NODO* nodo=malloc(sizeof(NODO));

  if(fp==NULL){
    printf("Apertura del file non riuscita!\n\n");
  }
  else{
    PERS pp;
    if(fscanf(fp, "%s %s %d %d %d\n", &pp.nome, &pp.cognome, &pp.nascita.g, &pp.nascita.m, &pp.nascita.a)==0) {
      printf("Il file non contiene elementi\n\n");
    }
    else{//costruisco la testa della lista
      testa=malloc(sizeof(NODO));
      testa->p=pp;
      NODO* lista=testa;
      while (fscanf(fp, "%s %s %d %d %d\n", &pp.nome, &pp.cognome, &pp.nascita.g, &pp.nascita.m, &pp.nascita.a)>0) {
        lista->next=malloc(sizeof(NODO));
        lista=lista->next;
        lista->p=pp;

    }//ultimo nodo
    lista->next=NULL;
    printf("Acqusizione dal file riuscita!\n\n");


  }
}
fclose(fp);
return testa;
}
//MAIN
int main() {

  int scelta=0;
  NODO* lista=acquisizione();

  do {
    printf("1) Inserisci una nuova persona\n");

    printf("2) Cancella la prima persona nella lista\n");

    printf("3) Visualizza la lista di persone\n");

    printf("0) Esci dall'applicazione\n");
    scanf("%d%*c", &scelta);
    if (scelta==1) {
      lista=inserisciCoda(lista, NewPers());
    }
    else if(scelta==2) {
      lista=eliminaTesta(lista);
    }
    else if(scelta==3){
      visualizzaLista(lista);
    }
  } while(scelta!=0);

  salvataggio(lista);

  return 0;
}
