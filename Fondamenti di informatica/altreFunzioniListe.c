/* operazioni con la prima modalita' */
#include <stdio.h>
#include <stdlib.h>

struct Nodo{
	int info;
	struct Nodo *next;
};


/*********** 7) STAMPA RICORSIVA **********************/
void stampaListaRic(struct Nodo* head) {
	if (head==NULL)
		printf("\n");
	else{
		stampaListaRic(head->next);
		printf("%d ",head->info);
	}
}

/*********** 1) INSERIMENTO IN TESTA ************************/
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
/*********** 2) CALCOLO DELLA LUNGHEZZA DELLA LISTA *************************/
int lunghezza(struct Nodo *head){
	int l;					// la lunghezza
	if(head==NULL)
		l=0;
	else
		l = 1+lunghezza(head->next);
	return l;
}

/*********** 3) NUMERO DI OCCORRENZE DI UN ELEMENTO NELLA LISTA ***************/
int numeroOccorrenze(struct Nodo *head,int valore){
	int numero;  //quante volte il valore e' presente nella lista
	if (head==NULL)
		numero=0;
	else
		numero = (head->info==valore)+numeroOccorrenze(head->next,valore);
	return numero;
}
/*********** 4) COPIA RICORSIVA DI UNA LISTA ***********************/
struct Nodo* copia(struct Nodo* head){
	struct Nodo* nuova=NULL;
	if (head==NULL) 
		nuova=NULL;
	else {
		nuova = malloc(sizeof(struct Nodo));
		nuova->info = head->info;
		nuova->next=copia(head->next);
	}
	return nuova;
}
/*********** CANCELLAZIONE RICORSIVA DELLA LISTA ********************/
/*********** CALCOLO DEL MASSIMO *************************/



int main(){
	int op;  //numero corrispondente all'operazione del menu
	struct Nodo *head=NULL;
	int valore; //per la ricerca di un numero nella lista
	struct Nodo *nuova=NULL; //nuova lista 

	printf("Caro utente, quale operazione vuoi eseguire?\n");
	do{
		printf("1) Inserimento di un intero in testa alla lista\n");
		printf("2) Calcolo della lunghezza della lista\n");
		printf("3) Numero di occorrenze di un elemento in una lista\n");
		printf("4) Copia ricorsiva di una lista\n");
		printf("5) Cancellazione ricorsiva di una lista lista\n");
		printf("6) Concatenazione di due liste\n");
		printf("7) Stampa ricorsiva della lista\n");
		printf("0) Per terminare\n");
		scanf("%d",&op);
		if (op==1)
			head = inserisciInTesta(head);
		else if(op==2) 
			printf("La lista ha %d elementi\n",lunghezza(head));
		else if(op==3) {
			printf("quale numero vuoi cercare? "); 
			scanf("%d",&valore); 
			printf("il numero %d e' presente %d volte nella lista\n\n",valore,numeroOccorrenze(head,valore));
		}
		else if(op==4) {
			nuova=copia(head); 
			printf("Lista copiata!\n"); 
			stampaListaRic(nuova); 
			printf("\n");
		}
		else if(op==5) printf("ancora no!\n");
		else if(op==6) printf("ancora no!\n");
		else if(op==7) {
			stampaListaRic(head); 
			printf("\n");
		}
		else if (op!=0) printf("operazione non prevista");
	}
	while(op!=0); // quando op==0 esco dal ciclo

	printf("*** Programma Terminato! ***\n");
}

