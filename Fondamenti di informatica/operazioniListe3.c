/* operazioni con il nodo fittizio (soluzione 3) */
#include <stdio.h>
#include <stdlib.h>

struct Nodo{
	int info;
	struct Nodo *next;
};

/*********** STAMPA **********************/
void stampaLista(struct Nodo* head) {
	struct Nodo *nodo = head->next;	// primo elemento della lista
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

/*********** INSERIMENTO IN CODA *************************/
/*********** CANCELLAZIONE IN TESTA **********************/
/*********** CANCELLAZIONE IN CODA ***********************/
/*********** CANCELLAZIONE PER VALORE ********************/
/*********** CALCOLO DEL MASSIMO *************************/



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

