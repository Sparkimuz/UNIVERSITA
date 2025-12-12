#include<stdio.h>
#include<stdlib.h>
#include<math.h>


//STRUTTURE

typedef struct punto{
  float x;
  float y;
}PUNTO;

typedef struct rombo{
  PUNTO a;
  PUNTO b;
  float d;
}ROMBO;
typedef struct nodo{
  ROMBO r;
  struct nodo* next;
}NODO;

//INSERIMENTO IN TESTA
//Creazione nuovo rombo

ROMBO NewRom(){
  ROMBO r;
  printf("Caro utente, inserisci le misure del rombo:\n");
  printf("Lunghezza della diagonale orizzontale: ");
  scanf("%f", &(r.d));
  printf("Ascissa del vertice in basso e del vertice in alto: ");
  scanf("%f", &(r.a.x));
  printf("Ordinata del vertice in alto: ");
  scanf("%f", &(r.a.y));
  printf("Ordinata del vertice in basso: ");
  scanf("%f", &(r.b.y));
  r.b.x=r.a.x;

  return r;
}

NODO* Inserimento(NODO* lista, ROMBO r){
  NODO* nuovoNodo=malloc(sizeof(NODO));

  nuovoNodo->r=r;
  nuovoNodo->next=lista;

  return nuovoNodo;
}
//CANCELLAZIONE IN CODA

NODO* Cancellazione(NODO* lista){
  if (lista==NULL) {
    printf("Non ci sono elementi da cancellare nella lista!\n\n");
  }
  else{
    if (lista->next==NULL) {
      free(lista);
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
//VISUALIZZAZIONE
void Visualizza(NODO* lista){
if (lista==NULL) {
  printf("La lista e' vuota!\n\n");
}
else{
  while (lista!=NULL) {
    printf("Vertice in alto: %.2f, %.2f\n", lista->r.a.x,lista->r.a.y);
    printf("Vertice in basso: %.2f, %.2f\n", lista->r.a.x,lista->r.b.y);
    printf("Diagonale orizzontale: %.2f\n", lista->r.d);
    printf("Perimetro: %.2f\n", (sqrt(((lista->r.d/2)*(lista->r.d/2)) + (((lista->r.a.y-lista->r.b.y)/2)*(lista->r.a.y-lista->r.b.y)/2))) * 4);
    printf("Area: %.2f\n", ((lista->r.d)*(lista->r.a.y-lista->r.b.y))/2);
    if ((lista->r.d)==(lista->r.a.y-lista->r.b.y)) {
      printf("Il rombo e' un quadrato!\n\n");
    }
    else
      printf("Il rombo non e' un quadrato!\n\n");

    lista=lista->next;
  }

}

}
//ACQUISIZIONE
NODO* acquisizione(){
  FILE* fp=fopen("rombi.txt", "rb");
  NODO* testa;
  NODO* lista;
  ROMBO r;

  if (fp==NULL) {
    printf("Apertura file non riuscita!\n\n");
  }
  else{
    if (fscanf(fp, "%f %f %f %f\n", &r.d, &r.a.x, &r.a.y, &r.b.y)==0) {
      printf("Il file non contiene elementi!\n\n");
    }
    else{
      testa=malloc(sizeof(NODO));
      testa->r=r;
      lista=testa;


    while (fscanf(fp, "%f %f %f %f\n", &r.d, &r.a.x, &r.a.y, &r.b.y)>0) {
      lista->next=malloc(sizeof(NODO));
      lista=lista->next;
      lista->r=r;

    }
    lista->next=NULL;
    fclose(fp);
    }
  }
  return testa;
}
//SALVATAGGIO

void Salvataggio(NODO* lista){
  FILE* fp=fopen("rombi.txt", "wb");
  if (fp==NULL) {
    printf("Apertura file non riuscita!\n\n");
  }
  else{
    while (lista!=NULL) {
      fprintf(fp, "%f %f %f %f\n", lista->r.d, lista->r.a.x, lista->r.a.y, lista->r.b.y);
      lista=lista->next;
    }
    printf("Salvataggio effettuato!\n\n");

    }
    fclose(fp);
  }



  int main() {
  	/* inizializza la lista */
    NODO* lista=acquisizione();

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
      lista=Inserimento(lista, NewRom());

  		else if(risposta==3)
      lista=Cancellazione(lista);

  		else if(risposta==0)
  			printf("Finito!\n\n");
  		else printf("Selezione non valida!\n\n");
  	}

    Salvataggio(lista);
  }
