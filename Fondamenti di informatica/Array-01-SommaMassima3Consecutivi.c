 /* SPECIFICA
  * Input: Una sequenza s di interi e la sua lunghezza l
  * Pre-condizione: l è la lunghezza di s e l>=3 
  * Output: Un intero somma
  * Post-condizione: somma è pari alla somma massima di tre interi consecutivi in s
  * TIPO DI PROBLEMA: Massimo
  */
#include <stdio.h>

/* funzione che prende come parametro un array di interi (e la sua lunghezza) 
 * e restituisce la somma massima di tre interi consecutivi nella sequenza */
int sommaMassima(int interi[], int lunghezza) {
	// pre: lunghezza è la lunghezza di interi, lunghezza>=3
	int somma;			// la somma massima
	
	/* inizializza la somma a quella dei primi tre interi */
	somma = interi[0]+interi[1]+interi[2];
	
	/* guarda tutte le altre triple di interi */
	for(int i=3; i<lunghezza; i++) {
		/* la tripla attuale ha somma maggiore del massimo corrente? */
		if(interi[i-2]+interi[i-1]+interi[i]>somma)
			somma = interi[i-2]+interi[i-1]+interi[i];
	}
	
	return somma;
}
 
/* funzione principale */
int main() {
	int lunghezza;		// numero di elementi dell'array
	
	/* INPUT */
	printf("Ciao utente, sono un programma che legge una sequenza di interi ");
	printf("e calcola la somma massima di tre interi consecutivi nella sequenza.\n\n");
	printf("Quanti interi vuoi introdurre? ");
	scanf("%d", &lunghezza);
	
	int sequenza[lunghezza];
	printf("\n");
	for(int i=0; i<lunghezza; i++) {
		printf("Introduci un intero: ");
		scanf("%d", &sequenza[i]);
	}

	/* OUTPUT */
	printf("\nLa somma massima di tre interi consecutivi vale %d.\n", sommaMassima(sequenza, lunghezza));
}
