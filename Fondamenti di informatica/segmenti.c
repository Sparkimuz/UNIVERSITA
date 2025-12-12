#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct punto{
  float x;
  float y;
}PUNTO;

typedef struct segmento{
  PUNTO s;
  PUNTO d;
} SEGM;

typedef struct nodo{
  SEGM seg;
  struct nodo* next;
}NODO;
//FUNZIONI SUPPORTO
float lunghezza(SEGM seg){
  float lun;
  lun= sqrt(pow(seg.d.x-seg.s.x, 2) + pow(seg.d.y-seg.s.y, 2));
  return lun;
}
//INSERIMENTO IN TESTA
SEGM NewSeg(){
  SEGM seg;

  printf("Caro utente inserisci le coordinate degli estremi del segmento: \n");
  printf("Ascissa dell'estremo sinistro: ");
  scanf("%f", &(seg.s.x));
  printf("Ordinata dell'estremo sinistro: ");
  scanf("%f", &(seg.s.y));
  printf("Ascissa dell'estremo destro: ");
  scanf("%f", &(seg.d.x));
  printf("Ordinata dell'estremo destro: ");
  scanf("%f", &(seg.d.y));

  return seg;
}
NODO* Inserisci(NODO* lista, SEGM segmento){
  NODO* nuovoNodo=malloc(sizeof(NODO));

  nuovoNodo->seg=segmento;
  nuovoNodo->next=lista;


  return nuovoNodo;
}
//CANCELLAZIONE IN TESTA

NODO* Cancellazione(NODO* lista){
  if (lista==NULL) {
    printf("Non ci sono elementi da cancellare nella lista!\n\n");
  }
  else{
    lista=lista->next;
  }
  return lista;
}
//VISUALIZZAZIONE
void Visualizza(NODO* lista){

  if (lista==NULL) {
    printf("La lista non contiene elementi!\n\n");
  }
  else{
    while (lista!=NULL) {
      printf("Estremo sinistro: %.2f, %.2f\n", lista->seg.s.x, lista->seg.s.y);
      printf("Estremo destro: %.2f, %.2f\n", lista->seg.d.x, lista->seg.d.y);
      printf("Lunghezza del segmento: %.2f\n\n", lunghezza(lista->seg));
      lista=lista->next;
    }
  }
}
//PARALLELI
int Paralleli(NODO* lista, SEGM a, SEGM b){





}
//PRIMI DUE PERPENDICOLARI
//SALVATAGGIO
void Salvataggio(NODO* lista){
  FILE* fp=fopen("segmenti.txt", "wb");

  while (lista!=NULL) {
    fprintf(fp, "%f %f %f %f\n", lista->seg.s.x, lista->seg.s.y, lista->seg.d.x, lista->seg.d.y);
    lista=lista->next;
  }
}
//ACQUISIZIONE
NODO* Acquisizione(){
  FILE* fp=fopen("segmenti.txt", "rb");
  NODO* testa=malloc(sizeof(NODO));
  if (fp==NULL) {
    printf("Apertura file non riuscita!\n\n");
  }
  else{
    SEGM seg;
    if (fscanf(fp, "%f %f %f %f\n", &seg.s.x, &seg.s.y, &seg.d.x, &seg.d.y)==0) {
      printf("Nel file non ci sono elementi!\n\n");
    }
    else{
      testa->seg=seg;
      NODO* nodo=testa;
      while (fscanf(fp, "%f %f %f %f\n", &seg.s.x, &seg.s.y, &seg.d.x, &seg.d.y)>0) {
        nodo->next=malloc(sizeof(NODO));
        nodo=nodo->next;
        nodo->seg=seg;
    }
    nodo->next=NULL;
  }
  printf("Segmenti recuperati!\n\n");

}
fclose(fp);
return testa;
}

int main(){
	int op;  //numero corrispondente all'operazione del menu
	NODO* head=Acquisizione();

	printf("Caro utente, quale operazione vuoi eseguire?\n");
	do{
		printf("1) Inserimento di un intero in testa alla lista\n");
		//printf("2) Inserimento di un intero in coda alla  lista\n");
		printf("2) Cancellazione di un intero in testa alla lista\n");
		//printf("4) Cancellazione di un intero in coda alla lista\n");
	//	printf("5) Cancellazione per valore di un elemento nella lista\n");
		//printf("6) Calcolo del massimo valore nella lista\n");
		printf("3) Stampa la lista\n");
		printf("0) Per terminare\n");
		scanf("%d",&op);
		if (op==1)
			head = Inserisci(head, NewSeg());
		//else if(op==2) head = inserisciInCoda(head);
		else if(op==2) head= Cancellazione(head);
		//else if(op==4) printf("ancora no!\n");
		//else if(op==5) printf("ancora no!\n");
		//else if(op==6) printf("ancora no!\n");
		else if(op==3) Visualizza(head);
		else if (op!=0) printf("operazione non prevista");
	}
	while(op!=0); // quando op==0 esco dal ciclo

  Salvataggio(head);

	printf("*** Programma Terminato! ***\n");
}
