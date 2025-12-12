/* operazioni con la seconda modalita': passaggio di parametri per riferimento */
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
void inserisciInTesta(struct Nodo **puntaHead){ //puntaHead e' il puntatore a *head, head e' la struct del primo nodo
	struct Nodo *nuovoNodo;                     // *puntaHead e' il puntatore al primo nodo della lista
	nuovoNodo = malloc(sizeof(struct Nodo));

	//preparo il nodo da inserire
	printf("inserisci l'intero \n");
	scanf("%d",&(nuovoNodo->info));

	nuovoNodo->next=*puntaHead; //inserisco il nodo in testa

	*puntaHead=nuovoNodo; //nuovoNodo e' la nuova testa della lista
}

/*********** INSERIMENTO IN CODA *************************/

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
			inserisciInTesta(&head);
		else if(op==2) printf("ancora no!\n");
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

