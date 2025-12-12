
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*****************************/
/********* STRUTTURE *********/
/*****************************/


typedef struct punto{
  float x;
  float y;
}PUNTO;

typedef struct  paralle{
  PUNTO bs;
  PUNTO ad;
  float b;
}PARA;

typedef struct nodo{
  PARA p;
  struct nodo* next;
}NODO;


/***************************************/
/***************CALCOLI****************/
/**************************************/

float peri(NODO* lista){
  float perimetro;
  perimetro= (sqrt(pow(((lista->p.ad.x-lista->p.bs.x)-lista->p.b), 2) + pow(lista->p.ad.y-lista->p.bs.y, 2)))*2 + 2*lista->p.b;
  return perimetro;
}
/**************************************/
/*********** VISUALIZZAZIONE **********/
/**************************************/
void Visualizza(NODO* lista){
  if(lista==NULL){
    printf("La lista non contiene elementi!\n");
  }
  else{
    while (lista!=NULL) {
      printf("Vertice bs: (%.2f,%.2f); vertice ad: (%.2f,%.2f)\n", lista->p.bs.x, lista->p.bs.y, lista->p.ad.x, lista->p.ad.y);
      printf("Lunghezza della base: %.2f\n", lista->p.b);
      printf("Perimetro: %.2f\n", peri(lista));
      printf("Area: %.2f\n", (lista->p.ad.y-lista->p.bs.y) * lista->p.b);
      if (lista->p.b == sqrt(pow(((lista->p.ad.x-lista->p.bs.x)-lista->p.b), 2) + pow(lista->p.ad.y-lista->p.bs.y, 2))) {
        printf("Il parallelogramma è un rettangolo!\n\n");
      }
      else
        printf("Il parallelogramma non e' un rettangolo!\n\n");
      lista=lista->next;
    }

  }
}
/**********************************************
 **************** INSERIMENTO *****************
 **********************************************/
 PARA NewPara(){
   PARA pa;

   printf("Caro utente inserisci la lunghezza della base e le coordinate dei vertici in basso a sinistra e in alto a destra:\n");
   printf("Base: ");
   scanf("%f", &pa.b);
   printf("X del vertice in basso a destra: ");
   scanf("%f", &pa.bs.x);
   printf("Y del vertice in basso a destra: ");
   scanf("%f", &pa.bs.y);
   printf("X del vertice in alto a sinistra: ");
   scanf("%f", &pa.ad.x);
   printf("Y del vertice in alto a sinistra: ");
   scanf("%f", &pa.ad.y);

   return pa;

 }


NODO* inserisci(NODO* lista, PARA p){
  NODO* nuovoNodo=malloc(sizeof(NODO));
  nuovoNodo->p=p;

  nuovoNodo->next=lista;
  printf("Inserimento effettuato!\n\n");

  return nuovoNodo;

}
/**********************************************
 ******* CANCELLAZIONE ************************
 **********************************************/

void cancella(NODO* lista){
  if(lista==NULL)
    printf("La lista non contiene parallelogrammi da cancellare! \n\n");
  else{
    while (lista->next!=NULL) {
      lista=lista->next;

    }
    lista=NULL;
  }
}
/***********************************************
**************SALVATAGGIO***********************
***********************************************/
void salvataggio(NODO* lista){
  FILE* fp=fopen("parallelogrammi.dat", "wb");

  if(fp==NULL){
    printf("Salvataggio file non riuscito\n\n");
  }
  else{
    while (lista!=NULL) {
      fwrite(&(lista->p), sizeof(PARA), 1, fp);
      lista=lista->next;

    }
  }
}
/**********************************************
***************ACQUISIZIONE********************
**********************************************/


NODO* acquisizione(){
  FILE* fp= fopen("parallelogrammi.dat", "rb");
  NODO* head=NULL;
  NODO* nodo;
  PARA p;

  if (fp==NULL) {
    printf("Apertura file non riuscita\n\n");

  }
  else{
    if (fread(&p, sizeof(PARA), 1, fp)==0) {
      printf("Il file non contiene parallelogrammi!\n\n");
      }
    else{
      head=malloc(sizeof(NODO));
      head->p=p;
      nodo=head;
      while (fread(&p, sizeof(PARA), 1, fp)>0) {
        nodo->next=malloc(sizeof(NODO));
        nodo=nodo->next;
        nodo->p=p;
      }
      nodo->next=NULL;
      printf("Acquisizione dal file riuscita!\n\n");
    }


  }
  return head;
}
/**********************************************
 ************ FUNZIONE PRINCIPALE ************
 **********************************************/

int main() {
	/* inizializza la lista */
  NODO* lista=acquisizione();

	int risposta = -1;			// per interazione con utente

	while(risposta != 0) {
		/* richiedi un'operazione all'utente */
		printf("Che operazione vuoi svolgere?\n");
		printf("1 -> Visualizzazione\n");

		printf("2 -> Inserimento\n");
		printf("3 -> Cancella l'ultimo parallelogramma\n");
		printf("0 -> Termina il programma\n");
		scanf("%d", &risposta);

		/* gestisci le operazioni dell'utente */
		if(risposta==1)
      Visualizza(lista);
		else if(risposta==2)
      lista=inserisci(lista, NewPara());

		else if(risposta==3)
      cancella(lista);

		else if(risposta==0)
			printf("Finito!\n\n");
		else printf("Selezione non valida!\n\n");
	}

  salvataggio(lista);
}
