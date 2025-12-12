#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct disco{
  char tit[30];
  char aut[30];
  int anno;
} DISC;

typedef struct nodo{
  DISC d;
  struct nodo* next;

}NODO;


void Visualizza(NODO* lista){
  if (lista==NULL) {
    printf("La lista non contiene dischi!\n\n");
  }
  else{
    while (lista!=NULL) {
      printf("Titolo: %s", lista->d.tit);
      printf("Autore: %s", lista->d.aut);
      printf("Anno: %d\n\n", lista->d.anno);
      lista=lista->next;
    }
  }
}
DISC NewDisc(){
  DISC d;
  printf("Caro utente inserisci un nuovo disco:\n");
  printf("Titolo: ");
  fgets(d.tit, 30, stdin);
  printf("Autore: ");
  fgets(d.aut, 30, stdin);
  printf("Anno di pubblicazione: ");
  scanf("%d%*c", &(d.anno));

  return d;
}


int precede(char* titolo1, char* titolo2){
  int risultato;
  risultato= strcmp(titolo1, titolo2);

  return risultato;

}


NODO* inserisci(NODO* lista, DISC di){
  NODO* nuovoNodo = malloc(sizeof(NODO));

  nuovoNodo->d=di;

  if (lista == NULL) {
    lista=nuovoNodo;
    lista->next=NULL;
    }
  else{

    if(precede(lista->d.tit, nuovoNodo->d.tit)>0){
      nuovoNodo->next=lista;
      lista=nuovoNodo;
    }
    else{
      NODO* prec=lista;
      NODO* succ=lista->next;
      int trovato=0;
      while (succ!=NULL && !trovato) {
        if (precede(succ->d.tit, nuovoNodo->d.tit)>0) {
          trovato=1;
        }
        else{
          prec=prec->next;
          succ=succ->next;

        }
        prec->next=nuovoNodo;
        nuovoNodo->next=succ;
      }
    }
  }
  printf("Inserimento effettuato!\n\n");

  return lista;
}




//CANCELLAZIONE

NODO* Cancella(NODO* lista){
  if(lista==NULL){
    printf("Non ci sono dischi da cancellare!\n\n");
  }
  else{
    if (lista->next==NULL) {
      lista=NULL;
    }
    else{
    NODO* prec=lista;
    NODO* succ=lista->next;
    while (succ->next!=NULL) {
      prec=prec->next;
      succ=succ->next;
    }
    prec->next=NULL;
    free(succ);
  }
  }
  return lista;
}


int main() {
	/* inizializza la lista */
  NODO* lista=NULL;

	int risposta = -1;			// per interazione con utente

	while(risposta != 0) {
		/* richiedi un'operazione all'utente */
		printf("Che operazione vuoi svolgere?\n");
		printf("1 -> Inserimento\n");
		printf("2 -> Cancellazione\n");
		printf("3 -> Visualizzazione\n");
		printf("0 -> Termina il programma\n");
		scanf("%d%*c", &risposta);

		/* gestisci le operazioni dell'utente */
		if(risposta==1)
    lista=inserisci(lista, NewDisc());
		else if(risposta==2)
		lista=Cancella(lista);
		else if(risposta==3)
		Visualizza(lista);
		else if(risposta==0)
			printf("Finito!\n\n");
		else
			printf("Selezione non valida!\n\n");
	}
}
