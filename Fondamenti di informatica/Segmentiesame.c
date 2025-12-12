#include<stdio.h>
#include<stdlib.h>
#include<math.h>


//STRUTTURE
typedef struct punto{
  float x;
  float y;
}PUNTO;

typedef struct segmento{
  PUNTO s;
  float lun;
}SEG;

typedef struct nodo{
  SEG seg;
  struct nodo* next;
}NODO;
//VISUALIZZAZIONE
void Visualizzazione(NODO* lista) {
  if (lista==NULL) {
    printf("La lista non contiene elementi!\n\n");
  }
  else{
    while (lista!=NULL) {
      printf("Estremo sinistro: %.2f, %.2f\n", lista->seg.s.x, lista->seg.s.y);
      printf("Estremo destro: %.2f, %.2f\n", lista->seg.s.x + lista->seg.lun, lista->seg.s.y);
      printf("Lunghezza del segmento: %.2f\n\n", lista->seg.lun);
      lista=lista->next;
    }
  }
}
SEG NewSeg(){
  SEG seg;

  printf("Caro utente inserisci le coordinate dell'estremo sinistro e la lunghezza del segmento: \n");
  printf("Ascissa dell'estremo sinistro: ");
  scanf("%f", &(seg.s.x));
  printf("Ordinata dell'estremo sinistro: ");
  scanf("%f", &(seg.s.y));
  printf("Lunghezza del segmento: ");
  scanf("%f", &(seg.lun));


  return seg;
}
//INSERIMENTO IN CODA
NODO* Inserimento(NODO* lista, SEG segmento){
  NODO* nuovoNodo=malloc(sizeof(NODO));

  nuovoNodo->seg=segmento;
  nuovoNodo->next=NULL;
  if (lista==NULL) {
    lista=nuovoNodo;
  }
  else{
      NODO* nodo=lista;
      while (nodo->next!=NULL) {
        nodo=nodo->next;
      }
      nodo->next=nuovoNodo;

    }
    return lista;
  }
//CANCELLAZIONE PER VALORE
/*NODO* Cancellazione12(NODO* lista){

  if (lista==NULL) {
    printf("Non c'e' nessun segmento da cancellare!\n\n");
  }
  else{
    if (lista->seg.lun==12) {
      lista=lista->next;
    }
    else{
    NODO* prec=lista;
    NODO* succ=lista->next;
    int cancellato=0;
    while (succ!=NULL && !cancellato) {
      if (succ->seg.lun==12) {
        prec->next=succ->next;
        free(succ);
        cancellato=1;
      }
        prec=prec->next;
        succ=succ->next;
    }
    if (cancellato==0) {
      printf("Non esistono segmenti di lunghezza 12 da cancellare!\n\n");
    }
    else{
      printf("Cancellazione riuscita\n\n");
    }
  }
  return lista;
}
}
*/
NODO* cancellaValore(NODO* lista){

NODO* prec;
NODO* succ;

  if(lista==NULL)
    printf("lista vuota, niente da cancellare\n\n");
  else{
    while(lista!=NULL && lista->seg.lun==12){
      free(lista);
      lista=lista->next;
    }
      if (lista==NULL) {
        printf("Lista completamente cancellata\n\n");
      }
      else{
        prec=lista;
        succ=lista->next;
        while (succ!=NULL) {
        if (succ->seg.lun==12) {
          prec->next=succ->next;
          free(succ);
          succ=prec->next;
        }
        else{
          succ=succ->next;
          prec=prec->next;
        }

      }

      }
  }
  return lista;
}

int main() {
	/* inizializza la lista */
	NODO* head = NULL;

	int risposta = -1;			// per interazione con utente
	while(risposta != 0) {
		/* richiedi un'operazione all'utente */
		printf("Che operazione vuoi svolgere?\n");
		printf("1 -> Inserimento\n");
		printf("2 -> Cancellazione\n");
		printf("3 -> Visualizzazione\n");
		printf("0 -> Termina il programma\n");
		scanf("%d", &risposta);

		/* gestisci le operazioni dell'utente */
		if(risposta==1)
			head = Inserimento(head, NewSeg());
		else if(risposta==2)
			head = cancellaValore(head);
		else if(risposta==3)
			Visualizzazione(head);
		else if(risposta==0)
			printf("Finito!\n\n");
		else printf("Selezione non valida!\n\n");
	}
}
