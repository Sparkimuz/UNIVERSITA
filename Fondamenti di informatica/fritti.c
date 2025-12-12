#include <stdio.h>
#include <stdlib.h>
#include <string.h>


/*********** INSERIMENTO IN CODA *************************/
/*********** STAMPA **********************/



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
