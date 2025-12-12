NODO* Inserimento(NODO* lista, INFO info){
  NODO* nuovoNodo=malloc(sizeof(NODO));

  nuovoNodo->i=info;
  if(lista==NULL){
    nuovoNodo->next=NULL;
    lista=nuovoNodo;
  }
  else{
    if(nuovoNodo->i<=lista->i){
      nuovoNodo->next=lista;
      lista=nuovoNodo;
    }
    else{
      NODO* prec=lista;
      NODO* succ=lista->next;
      int trovato=0;
      while(succ!=NULL && !trovato){
        if(nuovoNodo->i<=succ->i){
          trovato=1
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
