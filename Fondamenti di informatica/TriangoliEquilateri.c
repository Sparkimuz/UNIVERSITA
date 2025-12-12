#include<stdio.h>
#include<stdlib.h>
#include<math.h>
//strutture
typedef struct Punto{
  float x;
  float y;

}PUNTO;

typedef struct Tri{
  float lato;
  PUNTO p;
}TRI;

struct Nodo {
  TRI t;
  struct Nodo* next;
};
//Creazione triangolo
TRI NewTri(){
  TRI t;
  float vertx;
  float verty;
  float lat;
  printf("Caro utente inserisci le coordinate di un vertice: \n");
  printf("X=");
  scanf("%f", &vertx);
  printf("Y=");
  scanf("%f", &verty);
  printf("Caro utente inserisci la lunghezza di un lato: \n");
  scanf("%f", &lat);

  t.p.x=vertx;
  t.p.y=verty;
  t.lato=lat;


  return t;
}


//INSERIMENTO E ORDINAMENTO
struct Nodo* Inserimento(struct Nodo* head, TRI t){
  struct Nodo* prec;
  struct Nodo* succ;
  struct Nodo* nuovoNodo = malloc(sizeof(struct Nodo));
  nuovoNodo->t= t;

  if(head==NULL || nuovoNodo->t.lato < head->t.lato){
    nuovoNodo->next=head;
    head=nuovoNodo;
  }

  prec=head;
  succ=prec->next;

  while(succ!=NULL && nuovoNodo->t.lato > succ->t.lato) {
    prec=prec->next;
    succ=succ->next;


  }
  prec->next=nuovoNodo;
  nuovoNodo->next=succ;

  printf("Inserimento effettuato\n\n");




  return head;
}




//Visualizzazione
void Visualizza(struct Nodo* lista){
  if(lista==NULL)
    printf("La lista non contiene triangoli!\n\n");
  else{
    while (lista!=NULL) {
      printf("Perimetro = %.2f\n", lista->t.lato*3);
      printf("Vertice bs=%.2f,%.2f\n", lista->t.p.x-(lista->t.lato/2), lista->t.p.y-(sqrt((lista->t.lato*lista->t.lato)-lista->t.lato/2)));
      printf("Vertice a=%.2f,%.2f\n", lista->t.p.x, lista->t.p.y);
      printf("Vertice bd=%.2f,%.2f\n\n\n", lista->t.p.x+(lista->t.lato/2), lista->t.p.y-(sqrt((lista->t.lato*lista->t.lato)-lista->t.lato/2)));
      lista=lista->next;
    }
  }
}

//CANCELLAZIONE

struct Nodo* cancellazione(struct Nodo* lista){
  float p;
  struct Nodo* prec = lista;
  struct Nodo* succ = lista->next;

  printf("Dammi il perimetro del triangolo da cancellare: ");
  scanf("%f", &p);

  //lista vuota
  if(lista==NULL){
    printf("La lista è vuota!\n\n");

  }

  else{
    //Cancellazione in TESTA
    if (lista->t.lato*3 == p) {
      struct Nodo* dealloca = lista;
      lista = lista->next;
      free(dealloca);
      printf("Cancellazione eseguita!\n\n");

      /* code */
    }
    //cancellazione non in testa
    else{
      int trovato = 0;
      while (succ!=NULL && !trovato) {
        if ((succ->t.lato*3) == p) {
          trovato=1;
        }
        else{
          prec= succ;
          succ= succ->next;

        }
      }
      if (trovato==0) {
        printf("Il triangolo con perimetro %.2f non esiste!\n\n", p);
      }
      else{
        succ = succ->next;
        free(succ);
        printf("Cancellazione eseguita!\n\n");
      }

    }
  }
  return lista;
}



//SALVATAGGIO


void salvataggio(struct Nodo* lista){
  //apri il FILE
  FILE* fp = fopen("triangoli.dat", "wb");
	/* file non aperto */
	if(fp==NULL)
		printf("Salvataggio non riuscito!\n");
	/* file aperto */
	else {
		/* salva un triangolo alla volta */
		while(lista!=NULL) {
			fwrite(&lista->t, sizeof(TRI), 1, fp);
			lista = lista->next;
		}
		fclose(fp);
		printf("Salvataggio riuscito!\n");

  }


}

//ACQUISIZIONE
struct Nodo* acquisizione(){
  struct Nodo* head = NULL;
  //apro il FILE
  FILE* fp = fopen("triangoli.dat", "rb");
  if (fp == NULL) {
    printf("File apertura non riuscita!\n\n");
  }
  else{
    TRI t;
    if(fread(&t, sizeof(TRI), 1, fp)==0)
      printf("Il file non contiene triangoli!\n\n");
    else{
        //Primo triangolo
        head = malloc(sizeof(struct Nodo));
        head->t = t;
        struct Nodo* nodo = head;
        //Triangoli successivi
        while (fread(&t,sizeof(TRI), 1, fp)>0) {
          nodo->next = malloc(sizeof(struct Nodo));
          nodo=nodo->next;
          nodo->t=t;
        }
        //per l'ultimo nodo della Lista
        nodo->next = NULL;
        printf("Triangoli recuperati!\n\n");
    }
    fclose(fp);
  }
  return head;

}


//MAIN

int main() {

  int scelta=-1;
  struct Nodo* lista = acquisizione();

  do {
    printf("1) Inserisci un nuovo rettangolo\n");

    printf("2) Cancella un rettangolo\n");

    printf("3) Visualizza la lista di rettangoli\n");
    printf("0) Esci dall'applicazione\n");
    scanf("%d", &scelta);
    if(scelta==1)
      lista=Inserimento(lista, NewTri());
    else if(scelta==2)
      lista=cancellazione(lista);
    else if(scelta==3)
      Visualizza(lista);
  } while(scelta!=0);

  salvataggio(lista);

  return 0;
}
