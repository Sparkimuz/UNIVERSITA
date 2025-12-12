#include<stdio.h>
#include<stdlib.h>


typedef struct Centro {
  float x;
  float y;
} CENTRO;


typedef struct Cerchio {
  CENTRO Cen;
  float rag;
} CERCHIO;


struct Nodo {
  CERCHIO p;
  struct Nodo *next;

};

CERCHIO InsCer(){

  CERCHIO *p;


  printf("Caro utente inserisci le coordinate del centro del cerchio ed il suo raggio:\n");
  printf("X=");
  scanf("%f", &(p->Cen.x));
  printf("Y=");
  scanf("%f", &(p->Cen.y));
  printf("Raggio=");
  scanf("%f", &(p->rag));

  return *p;


}

struct Nodo *Inserisci(struct Nodo *head) {
  struct Nodo *nuovoNodo;
  nuovoNodo = malloc(sizeof(struct Nodo));

  nuovoNodo->p = InsCer();

  nuovoNodo->next = head;

  printf("Inserimento effettuato!\n\n");

  return nuovoNodo;

}




int main(){
	int op;  //numero corrispondente all'operazione del menu
	struct Nodo *head;
	head = malloc(sizeof(struct Nodo)); //creazione della lista vuota con il nodo fittizio
	head->next=NULL;

	printf("Caro utente, quale operazione vuoi eseguire?\n");
	do{
		printf("1) Inserimento di un intero in testa alla lista\n");
		printf("2) Inserimento di un intero in coda alla  lista\n");
		printf("3) Cancellazione di un intero in testa alla lista\n");
		printf("4) Cancellazione di un intero in coda alla lista\n");
		printf("5) Cancellazione per valore di un elemento nella lista\n");
		printf("6) Calcolo del massimo valore nella lista\n");
		printf("7) Stampa la lista\n");
		printf("0) Per terminare\n");
		scanf("%d",&op);
		if (op==1)
			printf("ancora no!\n");//inserisciInTesta(head);
		else if(op==2) Inserisci(head);
		else if(op==3) printf("ancora no!\n");
		else if(op==4) printf("ancora no!\n");
		else if(op==5) printf("ancora no!\n");
		else if(op==6) printf("ancora no!\n");
		else if(op==7) printf("ancora no!\n");
		else if (op!=0) printf("operazione non prevista");
	}
	while(op!=0); // quando op==0 esco dal ciclo

	printf("*** Programma Terminato! ***\n");
}
