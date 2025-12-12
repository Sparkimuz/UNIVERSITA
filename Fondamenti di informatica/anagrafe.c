#include<stdio.h>
#include<string.h>

/*Realizzare un programma per gestire un'anagrafe. L'utente di questo programma sarà un addetto del comune, ù
il quale userà le funzionalità messe a disposizione dal programma per gestire l'anagrafe.

Il programma deve gestire l'anagrafe come un array di 30 elementi di tipo PERSONA.

Ciascun elemento di tipo PERSONA ha 4 campi: un nome ed un cognome (che sono array di 30 caratteri),
una data di nascita ed un indirizzo.
Una data di nascita è un elemento di tipo DATA, che ha 3 campi: un giorno,
un mese ed un anno (che sono valori di tipo int).
Un indirizzo è un elemento di tipo INDIRIZZO, che ha 3 campi:
una via (che è un array di 30 caratteri),
un numero civico (che è un valore di tipo int),
ed una città (che è un array di 30 caratteri).

Il programma deve permettere all'utente di svolgere le seguenti operazioni:

Inserimento di una persona nell'anagrafe (l'inserimento deve avvenire nella prima posizione libera dell'array).
Cancellazione dei dati anagrafici di una persona (la cancellazione comporta
lo spostamento verso l'inizio dell'array di tutte le persone che seguivano la persona cancellata).
Ricerca della presenza di una persona con un certo nome e cognome e visualizzazione dei dati completi della persona,
nel caso in cui questa esista.
Visualizzazione dell'intera anagrafe.
Dopo aver realizzato il programma, crearne due nuove versioni.
In entrambe queste versioni l'anagrafe viene importata da file all'avvio del programma
e salvata su file al termine dell'esecuzione del programma.
In una versione il file per gestire l'anagrafe è testuale, nell'altra versione è binario.*/

//STRUTTURE
typedef struct indirizzo{
  char via[30];
  int civico;
  char citta[30];
}IND;

typedef struct datanascita {
  int g;
  int m;
  int a;
}DATA;

typedef struct persona{
  char nome[30];
  char cognome[30];
  DATA nascita;
  IND indirizzo;
} PERS;


PERS* cerca(PERS* arrAna){
  int individuato;
  int i=0;
  PERS* pe=NULL;
  printf("Inserisci il nome e il cognome della persona da ricercare: \n");
  printf("Nome: ");
  fgets(&(pe->nome), 30, stdin);
  printf("Cognome: ");
  fgets(&(pe->cognome), 30, stdin);

  while (pe==NULL && !individuato) {
    if (strcmp(pe->nome, (arrAna+i)->nome)==0 && strcmp(pe->cognome, (arrAna+i)->cognome)==0) {
      individuato=1;
      pe= (arrAna+i);
    }
    else{
      i++;
    }

  }
  return pe;
}


PERS* Inserisci(PERS* arrAna, PERS p){

  while (arrAna!=NULL) {
    arrAna=arrAna+1;
  }
  arrAna=&p;
}
