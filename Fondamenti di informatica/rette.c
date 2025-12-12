#include<stdio.h>
#include<stdlib.h>


//STRUTTURE
typedef struct razionale{
  float num;
  float den;
}RAZ;

typedef struct retta{
  int vert;
  RAZ coAng;
  RAZ intx;
}RETTA;

typedef struct nodo{
  RETTA r;
  struct nodo* next;
}NODO;

//FUNZIONI DI SUPPORTO
RETTA NewRet(){
  RETTA r;
  printf("Caro utente, la retta da inserire è verticale? (1=si , 0=no): ");
  scanf("%d", &r.vert);
  if (r.vert==1) {
    printf("Perfetto, allora inserisci l'ascissa del punto in cui la retta intercede l'asse delle x: \n");
    printf("Numeratore: ");
    scanf("%f", &r.intx.num);
    printf("Denominatore: ");
    scanf("%f", &r.intx.den);
  }
  else{
    printf("Perfetto, allora inserisci il coefficiente angolare della retta: \n");
    printf("Numeratore: ");
    scanf("%f", &r.coAng.num);
    printf("Denominatore: ");
    scanf("%f", &r.coAng.num);
    printf("Inserisci l'ordinata del punto in cui la retta intercede con l'asse delle y: \n");
    printf("Numeratore: ");
    scanf("%f", &r.intx.num);
    printf("Denominatore: ");
    scanf("%f", &r.intx.den);

  }
  return r;
}

//INSERIMENTO ORDINATO

/*NODO* inserisci(NODO* lista, RETTA r){
  NODO* nuovoNodo= malloc(sizeof(NODO));

  nuovoNodo->r=r;
  if(lista==NULL || ((prec->r.vert==1 && nuovoNodo->r.vert==1)&&((lista->r.intx.num/lista->r.intx.den)>(nuovoNodo->r.intx.num/nuovoNodo->r.intx.den)))){
    lista->next=lista;
    lista=nuovoNodo;

  }
  else{
    if (nuovoNodo->r.vert==1 && lista->r.vert==0) {
    }
    if ((lista->r.coAng.num/lista->r.coAng.den)>(nuovoNodo->r.coAng.num/nuovoNodo->r.coAng.den)) {

    }
    NODO* prec=lista;
    NODO* succ=lista->next;
    while (succ!=NULL) {
      if (prec->r.vert==1 && nuovoNodo->r.vert==1) {
        if ((prec->r.intx.num/prec->r.intx.den)>(nuovoNodo->r.intx.num/nuovoNodo->r.intx.den)) {

        }
      }
      prec=prec->next;
      succ=succ->next
    }

  }
  return lista;

}*/

NODO* inserisci(NODO* lista, RETTA r){
  NODO* nuovoNodo= malloc(sizeof(NODO));
  printf("Prima volta?\n\n");
  nuovoNodo->r=r;
  if(lista==NULL || ((lista->r.vert==1 && nuovoNodo->r.vert==1)&&((lista->r.intx.num/lista->r.intx.den)>(nuovoNodo->r.intx.num/nuovoNodo->r.intx.den)))){
    NODO* app= lista;
    lista=nuovoNodo;
    lista->r=r;
    lista->next=app;
    }
    else{
      NODO* prec=lista;
      NODO* succ=lista->next;
      int messo=0;
      while (/*prec!=NULL ||*/ messo!=1) {
        if (prec->r.vert==1) {

          printf("prec e' verticale!\n\n");
          if (nuovoNodo->r.vert==1) {
            printf("Anche nuovoNodo e' verticale!\n\n");
            if ((((prec->r.intx.num/prec->r.intx.den)<(nuovoNodo->r.intx.num/nuovoNodo->r.intx.den))) && (((succ->r.intx.num/succ->r.intx.den)>(nuovoNodo->r.intx.num/nuovoNodo->r.intx.den)) || succ==NULL)){
              /*if (succ==NULL) {
                prec->next= nuovoNodo;
                nuovoNodo=NULL;
              }
              else if((succ->r.intx.num/succ->r.intx.den)>(nuovoNodo->r.intx.num/nuovoNodo->r.intx.den)){

              */
              printf("Ci sono arrivato!\n\n");
              prec->next=nuovoNodo;
              nuovoNodo->next=succ;
              messo=1;
              printf("Retta inserita!\n\n");

          }
          else
            printf("Qua sicuro non ci arrivo!\n\n");
        }
        else
          printf("Ma nuovoNodo non e' verticale!\n\n");
      }
      else{
        if(((prec->r.coAng.num/succ->r.coAng.den)<(nuovoNodo->r.coAng.num/nuovoNodo->r.coAng.den))&&(((succ->r.coAng.num/succ->r.coAng.den)>(nuovoNodo->r.coAng.num/nuovoNodo->r.coAng.den)) || succ==NULL)){
        prec->next=nuovoNodo;
        nuovoNodo->next=succ;
        messo=1;
        printf("Arrivato qua!\n\n");
      }
      }
      prec=prec->next;
      succ=succ->next;
      printf("Ci sono arrivato!\n\n");
      }
      }
      printf("Finito!\n\n");
      return lista;
    }




//CANCELLAZIONE

NODO* cancella(NODO* lista){
  NODO* succ=malloc(sizeof(NODO));
  if(lista==NULL)
    printf("Non c'è nessun elemento nella lista da cancellare!\n");
  else {
    succ=lista->next;
    lista->r=succ->r;
    lista=succ;
  }
  return lista;
}


//VISUALIZZAZIONE
void Visualizza(NODO* lista){
  if (lista==NULL) {
    printf("La lista non contiene rette!\n\n");
  }
  else{
    while (lista!=NULL) {
      if (lista->r.vert==1) {
        printf("L'ascissa dell'intercezione con l'asse delle x e' %.2f\n", (lista->r.intx.num/lista->r.intx.den));
        printf("La retta e' verticale!\n\n");
      }
      else{
        printf("Il coefficiente angolare della retta e' %.2f\n", (lista->r.coAng.num/lista->r.coAng.den));
        printf("L'intercetta con l'asse delle x e' %.2f\n", (lista->r.intx.num/lista->r.intx.den));
        printf("La retta non è verticale!\n\n");
      }
      lista=lista->next;
    }
  }
}

int main() {
	/* inizializza la lista */
  NODO* lista=NULL;

	int risposta = -1;			// per interazione con utente

	while(risposta != 0) {
		/* richiedi un'operazione all'utente */
		printf("Che operazione vuoi svolgere?\n");
		printf("1 -> Visualizzazione\n");
		printf("2 -> Inserimento\n");
		printf("3 -> Cancellazione\n");
		printf("0 -> Termina il programma\n");
		scanf("%d", &risposta);

		/* gestisci le operazioni dell'utente */
		if(risposta==1)
    Visualizza(lista);

		else if(risposta==2)
    lista=inserisci(lista, NewRet());

		else if(risposta==3)
    lista=cancella(lista);

		else if(risposta==0)
			printf("Finito!\n\n");
		else printf("Selezione non valida!\n\n");
	}
}
