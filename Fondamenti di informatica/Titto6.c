#include <stdio.h>  /* ora puoi usare NULL */
#include <stdlib.h>
/* scrivi qui la definizione del tipo "elist" (elemento della lista)
   che e' una struttura con i campi "info" (intero). "prev" (puntatore
   all'elemento precedente) e "next" (puntatore al prossimo elemento). */
typedef struct elem{
    struct elem *prev;
    int info;

    struct elem *next;
}elist;

/* scrivi qui la definizione del tipo "plist" che e' un riferimento
   ad un oggetto di tipo "elist" */
typedef elist *plist;

/* funzione che prende in input un parametro di tipo plist*
   (cioè un puntatore ad un plist che è a sua volta
   un puntatore ad un elemento elist della lista) e
   un puntatore ad un elemento della lista. La funzione
   rimuove l'elemento puntato. */

void rimuovi_elemento(plist* p, elist* e){
    int rimo=1;

    while((*p)!=NULL && rimo==1){
        if((*p) == e){

            ((*p)->next)->prev=(*p)->prev;
            ((*p)->prev)->next=(*p)->next;
            free((*p));
            rimo=0;
            }
        else{
            (*p)=(*p)->next;
        }
    }
}

int main() {


// LISTA CON 5 ELEMENTI RIMUOVI ELEMENTO NEL MEZZO
int size = 5;
int A[] = {0,1,2,3,4};
plist lista = NULL;
int i;
for(i=0; i<size; i++) {
   plist elem = (plist)malloc(sizeof(elist));
   elem->info = A[size-i-1]; // inserisco in testa ma in ordine inverso
   elem->prev = NULL;
   elem->next = lista;
   if( lista != NULL ) {
      lista->prev = elem;
   }
   lista = elem;
}

rimuovi_elemento(&lista, lista->next->next);
int rimosso = 1;
int coerente = 1;

/* verifica che l'elemento sia rimosso */
if( lista == NULL && size == 0) {
   rimosso = 1;
} else if (lista == NULL && size == 1) {
   rimosso = 1;
} else {
    plist elem = lista;  // è diverso da NULL
    for(i=0; i<size; i++) {
       if( i == 2) i++; // skip index 2
       if(elem->info != A[i]) {
           printf("trovato %d invece di %d\n", elem->info, A[i]);
           rimosso = 0;
       }
       elem = elem->next;
    }
}
/* verifica dei puntatori prev e next */
{
   if( lista == NULL) {
      coerente = 1;
   } else {
      plist elem = lista;  // diverso da NULL
      if( elem->prev != NULL ) {
         coerente = 0;
      }
      while( elem != NULL ) {
         if( elem->prev != NULL ) {
             if(elem->prev->next != elem) {
                 coerente = 0;
             }
         }
         if( elem->next != NULL ) {
             if(elem->next->prev != elem) {
                 coerente = 0;
             }
         }
         elem = elem->next;
      }
   }
}
/* fine verifica */

if( coerente && rimosso) printf("1");
else if ( !coerente ) {
   printf("Soluzione errata: puntatori prev e next incoerenti!");
} else {
   printf("Soluzione errata: rimozione elemento non corretta!");
}

return 0;
}
