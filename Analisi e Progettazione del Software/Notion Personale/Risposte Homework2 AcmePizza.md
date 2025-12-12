Contratti UC2 punto B4:

loginCliente(username, pwd)

pre: nessuna

post: - è stato formato un collegamento 

tra il portaleAcmePizza 

e un cliente c sulla base di username e pwd

creaOrdine

pre: il cliente c sta usando il sistema

post: - è stato creato un ordine o

    - è stato formato un collegamento 

tra il portaleAcmePizza 

e un ordine o 

    - è stato formato un collegamento 

tra il cliente c 

e un ordine o (da cancellare se il collegamento si fa nell’operazione di confermaInserimentoOrdine in rosso)

selezionaCittà(nomeCittà)

pre: il cliente c sta effettuando l’ordine o

post: - nessuna

selezionaPizzeria(idPizzeria)

pre: il Cliente c sta effettuando l’Ordine o

post: è stato formato un collegamento 

tra l’Ordine o 

e una Pizzeria p sulla base di idPizzeria

selezionaPizza(idPizza)

pre: il cliente c sta effettuando l’ordine o

post: - è stata creata una nuova voce ordine vo

    - è stato formato un collegamento fra l’Ordine o e la VoceOrdine vo del tipo contiene

    - è stato formato un collegamento fra la VoceOrdine vo e la DescrizionePizza dp del tipo “è relativa a” sulla base di idPizza

    - attributi di vo inizializzati

selezionaProdottoAggiuntivo(idProdAgg)

pre: il cliente c sta effettuando l’ordine o

post:- è stato formato un collegamento fra la voce ordine vo e la DescrizioneProdottoAggiuntivo dpa sulla base di idProdAgg

confermaOrdine(indirizzo, data, ora)

pre: il cliente c sta effettuando l’ordine o

post:  - attributi di o aggiornati

terminaSelezionePizza

pre: il cliente c sta effettuando l’ordine o

post: nessuna

terminaSelezioneProdottoAggiuntivo

pre: il cliente c sta effettuando l’ordine o

post: nessuna

annullaOrdine

pre: il cliente sta effettuando l’ordine o

post: - è stato rotto l’ordine o con tutte le sue voci d’ordine e sono stati rotti tutti i collegamenti che riguardano l’ordine o e tutte le sue voci d’ordine

**Ecco un elenco di errori gravi che alcuni studenti hanno commesso nello svolgimento del secondo homework sulle operazioni di sistema, soprattutto con riferimento alla scrittura dei contenuti delle operazioni di sistema:**

- aver dimenticato la creazione di un nuovo Ordine o di una nuova Riga d'Ordine (molto grave)
- aver formato un percorso di collegamenti tra Cliente, Ordine, Riga d'Ordine e Piatto (molto grave)
- aver specificato la creazione di oggetti già esistenti nel caso d'uso, come ad esempio un nuovo Cliente, un nuovo Ristorante oppure un nuovo Piatto (grave)
- aver specificato la formazione di collegamenti tra oggetti già esistenti, come ad esempio tra un Piatto ed il suo Menu (grave)
- aver specificato la creazione di un nuovo oggetto, senza collegare quell'oggetto ad almeno un altro oggetto (grave)

**Ed inoltre:**

- aver formato dei collegamenti di tipo "corrente" (ad esempio, {Ordine corrente}) con riferimento al Cliente anziché al Portale DeliverEat
- aver usato una sintassi imprecisa: ad esempio non dicendo nulla alla base di quali dati viene collegata una Riga d'Ordine con un Piatto (più brutto che grave)
- aver usato una sintassi imprecisa: ad esempio dicendo che è stato selezionato un Piatto sulla base di un {piatto più brutto che grave, ma grave se non si dice perché è stato selezionato il Piatto}
- aver usato una sintassi imprecisa: ad esempio dicendo che una Riga d'Ordine è stata aggiunta alla lista delle righe di un Ordine (grave)
- aver usato una sintassi imprecisa: ad esempio specificando le pre-condizioni come azioni da eseguire (all'imperativo o all'infinito, anziché al passato) (più brutto che grave)
- avere usato una sintassi completamente inventata e, soprattutto, completamente scorrelata con quanto insegnato sui contenuti delle operazioni (molto grave)
- aver usato male le pre-condizioni, scrivendole in modo incompleto o in modo da prevedere quello che succederà durante l'operazione di sistema
- non aver scritto post-condizioni per operazioni che hanno parametri di cui bisogna ricordare i valori (e che dunque sono interrogazioni)

Correzione contratti homework 2 14/04

I collegamenti con il portale sono sempre 1 ad 1, se sono 1 a molti molto probabilmente è sbagliato 

loginCliente(username, pwd)

pre: nessuna

post: - è stato formato un collegamento 

tra il portaleAcmePizza 

e un cliente c sulla base di username e pwd

iniziaInserimentoOrdine

pre: il cliente c sta usando il sistema

post: - è stato creato un ordine o

    - è stato formato un collegamento 

tra il portaleAcmePizza 

e l’ordine o 

     - attributi dell’ordine inizializzati

collegamento tra cliente e ordine da fare in confermaOrdine, perché l’associazione si chiama “ha effettuato” quindi ha senso metterlo solo alla fine perché ora non è confermato

selezionaCittà(nomeCittà)

pre: il cliente c sta effettuando un ordine

post: - nessuna

selezionaPizzeria(idPizzeria)

pre: il Cliente c sta effettuando un Ordine o

post: è stato formato un collegamento 

tra l’Ordine o 

e una Pizzeria p sulla base di idPizzeria

aggiungiPizzaAll’Ordine(idPizza)

pre: il cliente c sta effettuando un ordine o

post: - è stata creata una nuova voce ordine v

    - è stato formato un collegamento tra l’Ordine corrente o e la VoceOrdine v

-SERVE COLLEGAMENTO TRA VOCE ORDINE E PORTALEACMEPIZZA “E’ CORRENTE”(NON SERVE DATO CHE è ORDINATA L’ASSOCIAZIONE TRA ORDINE E VOCEORDINE

    - è stato formato un collegamento tra la VoceOrdine v e una DescrizionePizza dp sulla base di idPizza

    - attributi di vo inizializzati

aggiungiProdottoAggiuntivoAll’UltimaPizzaOrdinata(idProdAgg)

pre: il cliente c sta effettuando un ordine o

post:- è stato formato un collegamento tra l’ultima voce ordine v dell’ordine corrente o e una DescrizioneProdottoAggiuntivo dpa sulla base di idProdAgg

terminaInserimentoPizze

pre: il cliente c sta effettuando un ordine o

post: nessuna

terminaInserimentoProdottoAggiuntivo

pre: il cliente c sta effettuando un ordine o

post: nessuna

confermaOrdine(indirizzo, data, ora)

pre: il cliente c sta effettuando l’ordine o

post:  - è stato formato un collegamento tra il cliente c e l’ordine o 

           - attributi di o aggiornati

(Se avessimo messo il collegamento tra c e o nell’iniziaInserimentoOrdine avremmo questa operazione vuota, ed è paradossale perché è una delle operazioni più importanti del sistema)

(Avremmo potuto inserire anche il collegamento con la Pizzeria all’interno di questa confermaOrdine, allora avrebbe senso perché la pizzeria riceve l’ordine solamente alla conferma)

annullaOrdine

pre: il cliente sta effettuando l’ordine o

post: - è stato rotto l’ordine o con tutte le sue voci d’ordine e sono stati rotti tutti i collegamenti che riguardano l’ordine o e tutte le sue voci d’ordine