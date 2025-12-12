NODO* Inserimento(NODO* lista, INFO info){
  NODO* nuovoNodo=malloc(sizeof(NODO));
  nuovoNodo->i=info;
  if(lista==NULL){
    nuovoNodo->next=NULL;
    lista=nuovoNodo;
  }
  else{
    if(lista->i>nuovoNodo->i){
      nuovoNodo->next=lista;
      lista=nuovoNodo;
    }
    else{
      NODO* prec=lista;
      NODO* succ=lista->next;
      int trovato=0;
      while(succ!=NULL && !trovato){
        if(succ->i>nuovoNodo->i){
          trovato=1;
        }
        else{
          prec=prec->next;
          succ=succ->next;
        }
      }
      nuovoNodo->next=succ;
      prec->next=nuovoNodo;
    }
  }
  return lista;
}


NODO* acquisizione(){
  FILE* fp=fopen("triangoli.dat", "r");
  NODO* lista;

  if(fp==NULL){
    printf("Apertura file non riuscita!")
  }
  else{
    TRI t;
    if(fread(&t, sizeof(TRI), 1, fp)==0){
      printf("Il file non contiene elementi!\n");

    }
    else{
       lista=malloc(sizeof(NODO));
      lista->t=t;
      NODO* nodo=lista;
      while(fread(&t, sizeof(TRI), 1, fp)>0){
        nodo->next=malloc(sizeof(NODO));
        nodo=nodo->next;
        nodo->t=t;
      }
      nodo->next=NULL;
    }
    printf("Triangoli recuperati!\n\n")
    fclose(fp);
  }

return lista;
}

void Salvataggio(NODO* lista){
  FILE* fp=fopen("triangoli.dat", "w");

  if(fp==NULL){
    printf("Salvataggio file non riuscito!");
      }
  else{
    while(lista!=NULL){
      fwrite(&(lista->t), sizeof(TRI), 1, fp);
      lista=lista->next;
    }
    printf("Triangoli salvati!\n\n");
    fclose(fp);
  }
}

NODO* cancellaValore(NODO* lista){

NODO* prec;
NODO* succ;

  if(lista==NULL)
    printf("lista vuota, niente da cancellare\n\n");
  else{
    while(lista!=NULL && lista->info==x){
      free(lista);
      lista=lista->next;
    }
      prec=lista;
      succ=lista->next;
      while (succ!=NULL) {
        if (succ->info==x) {
          prec->next=succ->next;
          free(succ);
          succ=prec->next;
        }
        else{
          succ=succ->next;
          prec=prec->next;
        }
      }
  }
  return lista;
}
