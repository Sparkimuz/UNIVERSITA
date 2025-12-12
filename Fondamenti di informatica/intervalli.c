#include<stdio.h>
#include<stdlib.h>


//STRUTTURE
typedef struct intervallo{
  int a;
  int b;
}INT;

typedef struct Nodo{
  INT i;
  struct Nodo* next;
}NODO;

//CREAZIONE NUOVO INTERVALLO
INT NewInt(){
  int a, b;
  INT i;
  printf("Caro utente inserisci gli estremi dell'intervallo:\n");
  printf("Estremo sinistro: ");
  scanf("%d", &a);
  printf("Estremo destro: ");
  scanf("%d", &b);

  i.a=a;
  i.b=b;

  return i;
}
//INSERIMENTO IN TESTA
NODO* inserisci(NODO* lista, INT i){
  NODO* nuovoNodo=malloc(sizeof(NODO));

  nuovoNodo->i=i;
  nuovoNodo->next=lista;

  printf("Inserimento effettuato!\n\n");

  return nuovoNodo;

}

//CANCELLAZIONE IN FONDO ALLA LISTA
NODO* Cancellazione(NODO* lista){
  NODO* prec= lista;
  NODO* succ= lista->next;
  if (lista==NULL) {
    printf("La lista non contiene Intervalli!\n\n");

  }
  else{
    //se succ=NULL Perchè c'è un solo elemento nella lista
    if(succ==NULL){
      lista=NULL;

    }
    else{
    while (succ->next!=NULL) {
      prec=prec->next;
      succ=succ->next;
      }//Perchè sono uscito dal while?
      //Sono arrivato all'ultimo nodo con succ, ora lego
      //il penultimo a NULL così diventa l'ultimo della lista
      free(succ);
      prec->next=NULL;
    }

      printf("Cancellazione effettuata!\n\n");
}
return lista;
}


//VISUALIZZAZIONE
void Visualizza(NODO* lista){
  if (lista==NULL) {
    printf("La lista non contiene intervalli\n\n");
  }
  else{
  while (lista!=NULL) {
    printf("Intervallo: [%d, %d]\n\n", lista->i.a, lista->i.b);

    lista=lista->next;

    }
  }
}

//ORDINAMENTO

void scambia(NODO* prec, NODO* succ){
  INT p= prec->i;
  prec->i=succ->i;
  succ->i=p;

}
void Ordina(NODO* lista){
  NODO* prec= lista;
  NODO* succ= lista->next;
  int i=1;
  int nonOrd=2;
  //se c'è un solo elemento la lista è già ordinata
  if (succ==NULL) {
    printf("La lista e' già ordinata!\n\n");
    }
  else{
    int pasval = 1; //passata valida
  for (int t=0; t < nonOrd+1; t++) {
      prec=lista;
      succ=lista->next;
      nonOrd = i;
      i=0;
      while (succ!=NULL) {
        if (prec->i.a==succ->i.a && prec->i.b>succ->i.b) {
          scambia(prec, succ);
        }
        else if(prec->i.a>succ->i.a){
          scambia(prec, succ);
        }
        prec=prec->next;
        succ=succ->next;

        printf("nigga: %d\n", i);
        i++;

    }
  }
    printf("lista ordinata!\n\n");
  }


}
//ACQUISIZIONE
NODO* acquisizione(){
  FILE* fp=fopen("intervalli.txt", "r");
  NODO* testa= NULL;

  if(fp==NULL)
    printf("Apertura del file non riuscita\n");
  else{
    INT i;
    if (fscanf(fp,"%d %d\n", &i.a, &i.b)==0) {
      printf("La lista non contiene intervalli\n");
    }
    else{

      testa=malloc(sizeof(NODO));
      testa->i=i;
      NODO* lista=testa;

      while (fscanf(fp,"%d %d\n", &i.a, &i.b)>0) {
        lista->next=malloc(sizeof(NODO));
        lista=lista->next;
        lista->i=i;
      }

      lista->next=NULL;
      printf("Intervalli recuperati!\n\n");


    }

  }
  fclose(fp);
  return testa;
}


//SALVATAGGIO

void salvataggio(NODO* lista){
  FILE* fp=fopen("intervalli.txt", "w");
  if (lista==NULL)
    printf("Salvataggio del file non riuscito\n\n");
  else{
    while (lista!=NULL) {
      fprintf(fp, "%d %d\n", lista->i.a, lista->i.b);
      lista=lista->next;
    }
  fclose(fp);
  }
}
//MAIN
int main() {

  int scelta=0;
  NODO* lista=acquisizione();

  do {
    printf("1) Inserisci un nuovo intervallo\n");

    printf("2) Cancella l'ultimo intervallo\n");

    printf("3) Visualizza la lista di intervalli\n");

    printf("4) Ordina la lista\n");

    printf("0) Esci dall'applicazione\n");
    scanf("%d", &scelta);
    if (scelta==1) {
      lista=inserisci(lista, NewInt());
    }
    else if(scelta==2) {
      lista= Cancellazione(lista);
    }
    else if(scelta==3){
      Visualizza(lista);
    }
    else if(scelta==4){
      Ordina(lista);
    }
  } while(scelta!=0);

  salvataggio(lista);

  return 0;
}
