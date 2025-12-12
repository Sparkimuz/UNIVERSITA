#include <stdio.h>
#include <math.h>

/*int TuttiAlternatiRic(int *array, int lun, int i){
  int alternati;
  if ((array[i]<0 && array[i+1]>0) || (array[i]>0 && array[i+1]<0)) {
    alternati=1;
  }
  else{
    alternati=0;
  }
  return alternati;
}*/
int TuttiAlternati(int *array, int lun){
  int verificato;
  if (lun=0) {
    printf("%d \n\n", verificato);
  }
  else{
    verificato = ((array[lun]<0 && array[lun-1]>0) || (array[lun]>0 && array[lun-1]<0)) && TuttiAlternati(array, lun-1);
  }
  return verificato;
}

void scriviNumeri(int* array, int lun){
  FILE* fp= fopen("tuttialternat.dat", "w");

  if (fp==NULL) {
    printf("Salvataggio non riuscito!\n\n");
  }
  else{
    fwrite(array, sizeof(int), lun, fp);
    fclose(fp);
  }
}

int quantiNumeri(){
  FILE* fp=fopen("tuttialternati.dat", "r");

  int conta=0;
  if (fp==NULL) {
    printf("Enumerazione interi non riuscita!\n\n");
  }
  else{
    int i;
    while (fread(&i, sizeof(int), 1, fp)){
      conta++;
    }
    fclose(fp);
  }
  return conta;
}

void leggiNumeri(int *array, int lunghezza){
  FILE* fp=fopen("tuttialternati.dat", "r");

  if (fp==NULL) {
    printf("Lettura array non riuscita!\n\n");
  }
  else{
    for (int i; i < lun; i++) {
      fread(&array[i], sizeof(int), 1, fp);
      }
    fclose(fp);

}
}

int main() {
    int lunghezza; 		//	lunghezza dell'array
	  int scelta;				//	scelta dell'utente

    /* acquisizione dati e lettura dell'array da input */
    printf("Vuoi introdurre una nuova sequenza (premi 1) oppure recuperarla da file (premi 2)? ");
    scanf("%d",&scelta);

	/* introduzione sequenza da input */
	if(scelta==1) {
		/* determina la lunghezza della sequenza */
		printf("Introduci la lunghezza della sequenza: ");
		scanf("%d",&lunghezza);

		/* crea l'array e leggine i valori degli elementi */
		int array[lunghezza];
		printf("Scrivi %d elementi \n",lunghezza);
		for(int i=0;i<lunghezza;i++)
			scanf("%d",&array[i]);

		/* invoca la funzione ricorsiva e stampa il risultato */
		if(minimoDispari(array,lunghezza))
			printf("Ogni tripla di interi consecutivi %c tale che il minimo fra i tre interi %c dispari!\n",138,138);
		else
			printf("Non tutte le triple di interi consecutivi sono tali che il minimo fra i tre interi sia dispari!\n");

		/* salva la sequenza su file */
		scriviNumeri(array,lunghezza);
	}
	/* recupero sequenza da file */
	else {
		/* determina la lunghezza della sequenza */
		lunghezza = quantiNumeri();

		/* crea l'array e leggine i valori degli elementi da file */
		int array[lunghezza];
		leggiNumeri(array,lunghezza);
		printf("Ecco la sequenza recuperata\n");
		for(int i=0;i<lunghezza;i++)
			printf("%d ", array[i]);
		printf("\n");

		/* invoca la funzione ricorsiva e stampa il risultato */
		if(minimoDispari(array,lunghezza))
           printf("Ogni tripla di interi consecutivi %c tale che il minimo fra i tre interi %c dispari!\n",138,138);
		else
			printf("Non tutte le triple di interi consecutivi sono tali che il minimo fra i tre interi sia dispari!\n");
		/* salva la sequenza su file */
		scriviNumeri(array,lunghezza);
	}
}
