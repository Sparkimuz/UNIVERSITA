#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//STRUTTURE

typedef struct punto{
  float x;
  float y;
} PUNTO;

typedef struct triangolo{
  PUNTO as;
  PUNTO bd;
} TRI;

typedef struct nodo{
  TRI t;
  struct nodo* next;
}NODO;

//FUNZIONI SUPPORTO

float Area(TRI t){
  float area;
  area= ((t.as.y-t.bd.y)*(t.bd.x-t.as.x))/2;
  return area;
}

//INSERIMENTO ORDINATO
TRI NewTri(){
  TRI t;
  printf("Caro utente inserisci le coordinate dei vertici in alto a sinsitra e in basso a destra:\n");
  printf("Ascissa as: ");
  scanf("%f", &t.as.x);
  printf("Ordinata as: ");
  scanf("%f", &t.as.y);
  printf("Ascissa bd: ");
  scanf("%f", &t.bd.x);
  printf("Ordinata bd: ");
  scanf("%f", &t.bd.y);

  return t;
}
NODO* Inserimento(NODO* lista, TRI tri){
  NODO* nuovoNodo=malloc(sizeof(NODO));

  nuovoNodo->t=tri;
  if (lista==NULL) {
    nuovoNodo->next=NULL;
    lista=nuovoNodo;
  }
  else{
    if(Area(lista->t)>Area(nuovoNodo->t)){
      nuovoNodo->next=lista;
      lista=nuovoNodo;
    }
    else{
      NODO* prec=lista;
      NODO* succ=lista->next;
      int trovato=0;
      while (succ!=NULL && !trovato) {
        if (Area(succ->t)>Area(nuovoNodo->t)) {
          trovato=1;
        }
        else{
        prec=prec->next;
        succ=succ->next;
      }
      }
      nuovoNodo->next=succ;
      prec->next=nuovoNodo;
      //nuovoNodo=prec->next;


    }
  }
  printf("Ci arrivo!finale\n");
  return lista;
}
//VISUALIZZAZIONE

void Visualizza(NODO* lista){
  if (lista==NULL) {
    printf("La lista non contiene elementi!\n\n");
  }
  else{
    while (lista!=NULL) {
      printf("Vertice as: %.2f, %.2f  Vertice bd: %.2f, %.2f \n", lista->t.as.x, lista->t.as.y, lista->t.bd.x, lista->t.bd.y);
      printf("                 Area: %.2f\n\n", Area(lista->t));
      lista=lista->next;
    }
    printf("********** Lista finita! **********\n\n");
  }
}

//MAIN
int main(){
	int op;  //numero corrispondente all'operazione del menu
	NODO* head=NULL;//Acquisizione();

	printf("Caro utente, quale operazione vuoi eseguire?\n");
	do{
		printf("1) Inserimento ordinato di un triangolo rettangolo\n");
		//printf("2) Inserimento di un intero in coda alla  lista\n");
		//printf("2) Cancellazione di un intero in testa alla lista\n");
		//printf("4) Cancellazione di un intero in coda alla lista\n");
	//	printf("5) Cancellazione per valore di un elemento nella lista\n");
		//printf("6) Calcolo del massimo valore nella lista\n");
		printf("2) Stampa la lista\n");
		printf("0) Per terminare\n");
		scanf("%d",&op);
		if (op==1)
			head = Inserimento(head, NewTri());
		//else if(op==2) head = inserisciInCoda(head);
		//else if(op==2) head= Cancellazione(head);
		//else if(op==4) printf("ancora no!\n");
		//else if(op==5) printf("ancora no!\n");
		//else if(op==6) printf("ancora no!\n");
		else if(op==2) Visualizza(head);
		else if (op!=0) printf("operazione non prevista");
	}
	while(op!=0); // quando op==0 esco dal ciclo

  //Salvataggio(head);

	printf("*** Programma Terminato! ***\n");
}
