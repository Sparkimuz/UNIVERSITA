#include<stdio.h>
#include<stdlib.h>

//STRUTTURE
typedef struct Punto{
  float x;
  float y;
} PUNTO;

typedef struct rettangolo {
  PUNTO bs;
  PUNTO ad;
} RETT;

typedef struct Nodo{
  RETT r;
  struct Nodo *next;
}NODO;


//CREO IL NUOVO RETTANGOLO

RETT NewRect(){
  float x,y;
  float latoH, latoV;
  PUNTO bs,ad;
  RETT r;

  printf("ascissa del vertice in basso a sinistra?\n");
  scanf("%f", &x);
  printf("ordinata del vertice in basso a sinistra?\n");
  scanf("%f", &y);

  printf("Lunghezza del lato orizzontale:\n");
  scanf("%f", &latoH);
  printf("Lunghezza del lato verticale:\n");
  scanf("%f", &latoV);

  bs.x = x;
  bs.y = y;

  ad.x= x + latoH;
  ad.y= y + latoV;

  r.bs=bs;
  r.ad=ad;


  return r;
}


//INSERIMENTO IN TESTA
NODO* Inserisci(NODO* lista, RETT r){
  NODO* head = malloc(sizeof(NODO));
  head->r = r;
  head->next = lista;

  printf("Inserimento effettuato!\n\n");

  return head; //return testa sostituisce le ultime due istruzioni
}


// CALCOLI
  float Peri(RETT r){
    float peri = ((r.ad.x-r.bs.x)*2) + ((r.ad.y-r.bs.y)*2);
    return peri;
    }

  float Area(RETT r){
    float area = (r.ad.y-r.bs.y)*(r.ad.x-r.bs.x);
    return area;
    }

//VISUALIZZAZIONE
void Visualizza(NODO* lista){
  if (lista==NULL) {
    printf("La lista è vuota!\n\n");
  }
  else
    while (lista!=NULL) {
      printf("RETTANGOLO:\n");
      printf("as=%.2f, %.2f;  ad=%.2f, %.2f;  bs=%.2f, %.2f;  bd=%.2f, %.2f. \n", lista->r.bs.x, lista->r.ad.y, lista->r.ad.x, lista->r.ad.y, lista->r.bs.x, lista->r.bs.y, lista->r.ad.x, lista->r.bs.y);
      printf("Area=%.2f       Perimetro=%.2f \n\n", Area(lista->r), Peri(lista->r));
      if(lista->r.ad.x-lista->r.bs.x == lista->r.ad.y-lista->r.bs.y)
        printf("Questo rettangolo è un quadrato!\n\n");
      lista=lista->next;
    }


}
//ACQUISIZIONE

  NODO* acquisizione() {
    NODO* head=NULL;

    FILE* fp=fopen("rettangoli.txt", "r");

    if(fp==NULL)
      printf("Apertura del file non riuscita\n\n");
    else{
      RETT ret;
      if(fscanf(fp,"%f %f %f %f", &ret.bs.x,&ret.bs.y,&ret.ad.x,&ret.ad.y)==0){
        printf("Il file non contiene rettangoli\n");

      }

      else{ //costruisco il primo nodo della lista (head)

        head = malloc(sizeof(NODO));
        head -> r = ret;
        NODO* nodo = head;

        //Per gli altri nodi metto come condizione l'esistenza di
        //dati nel file, se non esistono, smetto di creare altri nodi
        while(fscanf(fp,"%f %f %f %f", &ret.bs.x,&ret.bs.y,&ret.ad.x,&ret.ad.y)>0){
          nodo->next=malloc(sizeof(NODO));
          nodo = nodo->next;
          nodo->r= ret;
        }
        //Per l'ultimo nodo della lista, uscito dal while, l'ultimo puntatore ottenuto
        //da esso punta ad un nodo con un rettangolo e il next che definisco ora
        nodo->next = NULL;
        printf("Rettangoli recuperati!\n");

    }
    fclose(fp);
  }
  return head;
}

  //SALVATAGGIO
void salvataggio(NODO* lista){
  FILE* fp=fopen("rettangoli.txt","w"); //Per la scrittura di un file .txt
  if(fp==NULL)
    printf("salvataggio del file non riuscito\n");
  else{
    while(lista!=NULL){
    (fprintf(fp,"%f %f %f %f\n", lista->r.bs.x, lista->r.bs.y, lista->r.ad.x, lista->r.ad.y));
    lista=lista->next;
  }
  fclose(fp);
  printf("salvataggio riuscito\n");

  }
}

//MAIN
int main() {

  int scelta=0;
  NODO* lista=acquisizione();

  do {
    printf("1) Inserisci un nuovo rettangolo\n");

    printf("2) Cancella un rettangolo\n");

    printf("3) Visualizza la lista di rettangoli\n");

    printf("0) Esci dall'applicazione\n");
    scanf("%d", &scelta);
    if (scelta==1) {
      lista=Inserisci(lista, NewRect());
    }
    else if(scelta==2) {
      printf("Not yet nigga\n\n");
    }
    else if(scelta==3){
      Visualizza(lista);
    }
  } while(scelta!=0);

  salvataggio(lista);

  return 0;
}
