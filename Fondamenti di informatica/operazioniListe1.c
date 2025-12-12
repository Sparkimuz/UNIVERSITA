/* operazioni con la prima modalita' */
#include <stdio.h>
#include <stdlib.h>

struct Nodo{
	int info;
	struct Nodo *next;
};

/*********** STAMPA **********************/
void stampaLista(struct Nodo* head) {
	struct Nodo *nodo = head;	// primo elemento della lista
	/* lista vuota? */
	if(nodo==NULL)
		printf("La lista non contiene elementi!\n\n");
	else {
		printf("Ecco la lista: ");
		/* stampa ciascun elemento della lista */
		while(nodo != NULL) {
			printf("%d ", nodo->info);
			nodo = nodo -> next;
		}
		printf("\n\n");
	}
}

/*********** INSERIMENTO IN TESTA ************************/
/* funzione che inserisce un nodo in testa alla lista: restituisce l'indirizzo del nuovo
 * primo elemento della lista */
struct Nodo *inserisciInTesta(struct Nodo *head) {
	struct Nodo *nuovoNodo;											// il nuovo nodo della lista
	nuovoNodo = malloc(sizeof(struct Nodo)); 				// allocazione nodo nell'heap

	/* leggi il campo dati */
	printf("Inserisci l'intero!\n");
	scanf("%d", &(nuovoNodo -> info));
	printf("\n");

	/* collega il nodo al successivo */
	nuovoNodo->next = head;

	printf("Inserimento effettuato!\n\n");

	/* restituisci l'indirizzo del nuovo primo elemento */
	return nuovoNodo;
}
/*********** INSERIMENTO IN CODA *************************/
struct Nodo*inserisciInCoda(struct Nodo *head){
	struct Nodo *nuovoNodo;						// il nuovo nodo della lista
	nuovoNodo = malloc(sizeof(struct Nodo)); 	// allocazione nodo nell'heap

	/* preparo il nodo da inserire */
	printf("Inserisci l'intero!\n");
	scanf("%d", &(nuovoNodo -> info));
	printf("\n");
	nuovoNodo->next=NULL;

	if (head==NULL)
		head=nuovoNodo;
	else{
		struct Nodo *nodoCorrente=head; //serve per scorrere la lista
		while(nodoCorrente->next!=NULL)
			nodoCorrente=nodoCorrente->next;
		//esco dal while con nodoCorrente che punta sull'ultimo nodo della lista
		nodoCorrente->next=nuovoNodo;
	}
	return head;
}

/*********** CANCELLAZIONE IN TESTA **********************/
/*********** CANCELLAZIONE IN CODA ***********************/
/*********** CANCELLAZIONE PER VALORE ********************/
/*********** CALCOLO DEL MASSIMO *************************/



int main(){
	int op;  //numero corrispondente all'operazione del menu
	struct Nodo *head=NULL;

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
			head = inserisciInTesta(head);
		else if(op==2) head = inserisciInCoda(head);
		else if(op==3) printf("ancora no!\n");
		else if(op==4) printf("ancora no!\n");
		else if(op==5) printf("ancora no!\n");
		else if(op==6) printf("ancora no!\n");
		else if(op==7) stampaLista(head);
		else if (op!=0) printf("operazione non prevista");
	}
	while(op!=0); // quando op==0 esco dal ciclo

	printf("*** Programma Terminato! ***\n");
}

