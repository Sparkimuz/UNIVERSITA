Autovalutazione Homework2 AcmePizza:

1:

Per quanto riguarda il modello di dominio semplificato, avrei dovuto chiamare l’associazione tra Titolare e PortaleAcmePizza ‘sta usando’ per rispecchiare meglio l’effettivo scopo di quell’interazione, ovvero che il Titolare utilizza il portale per inserire nuove pizzerie. Inoltre, questa denominazione è pratica perché si presterebbe bene anche come parte delle pre-condizioni nei contratti del caso d'uso UC1: ad esempio, 'il Titolare t sta usando il sistema' risulta più chiaro.

Dovrei rivedere anche la disposizione grafica del diagramma per evitare eccessivi incroci tra le linee e rendere più evidente come sono collegate le diverse classi. Un layout ordinato, con spazi adeguati, aiuta chi legge a capire immediatamente la struttura complessiva e il senso delle relazioni.

2:

Nel diagramma di sequenza di sistema, conviene rivedere i nomi delle operazioni di sistema per esprimere meglio le intenzioni dell’utente e la reale funzione di ciascun passaggio. In particolare:

- creaOrdine

Andrebbe rinominata in iniziaInserimentoOrdine, perché in quel momento l’ordine non è ancora definitivo e può ancora essere annullato. L’uso di “iniziaInserimento” trasmette chiaramente che stiamo solo avviando il processo di compilazione.

- selezionaPizza

È preferibile il nome aggiungiPizzaAll’Ordine, poiché rende esplicito che si sta aggiungendo effettivamente un articolo (pizza) all’ordine in corso. Questo nome riflette al meglio l’azione compiuta dall’attore principale.

- selezionaProdottoAggiuntivo

Qui si applica la stessa logica di aggiungiPizzaAll’Ordine, con la differenza che il prodotto aggiuntivo va collegato all’ultima pizza ordinata. Per questo il nome proposto è aggiungiProdottoAggiuntivoAll’UltimaPizzaOrdinata, evidenziando l’intenzione di aggiungerlo ad una pizza già presente nell’ordine.

- terminaSelezionePizza

Considerando che stiamo completando l’inserimento della pizza, chiamarla terminaInserimentoPizza rispecchia meglio l’intenzione dell’attore, che in quel momento sta ultimando la selezione di quella specifica pizza.

- terminaSelezioneProdottoAggiuntivo

Allo stesso modo, è più coerente terminaInserimentoProdottoAggiuntivo, perché segnala il passaggio a uno stato di completamento per l’aggiunta del prodotto extra, con lo stesso tipo di dinamica vista per la pizza.

Per quanto riguarda i nomi delle risposte del sistema:

- Elenco città/Elenco pizzerie nella città: per entrambi non è necessario scrivere elenco dato che è un termine troppo generico che non è rilevante.

I parametri dell'operazione di sistema loginCliente sono "username, pwd", ma dato che nei contratti li ho chiamati "username, password" dovrei cambiare il nome di "pwd" in "password" nel diagramma per rendere più chiaro che si tratta dello stesso parametro.

Inoltre avrei dovuto scrivere i numeri indicativi del caso d'uso per ogni operazione di sistema accanto al diagramma di sequenza di sistema, per rendere più chiaro a quali sezioni del caso d'uso si riferiscono. Mentre non era necessario inserire le parentesi per le operazioni di sistema senza parametri

3:

Per quanto riguarda i contratti, i cambiamenti sui loro nomi rispecchiano quelli già applicati al diagramma di sequenza di sistema.

Nelle pre-condizioni di quasi tutti i contratti, ho scritto "il cliente c sta effettuando l'ordine o", mentre sarebbe più corretto dire "il cliente c sta effettuando un ordine o", poiché in questa fase non esiste ancora un ordine confermato o identificato univocamente.

- iniziaInserimentoOrdine:

La post-condizione "è stato formato un collegamento tra il cliente c e l'ordine o" va eliminata e aggiunta invece in confermaOrdine, dato che l'associazione fra Cliente e Ordine, chiamata "ha effettuato", ha più senso essere creata quando l'Ordine viene effettivamente confermato.

- aggiungiPizzaAll’Ordine(idPizza):

Nella post-condizione "è stato formato un collegamento tra VoceOrdine vo e l’Ordine o", dovrei precisare che si tratta dell'ordine corrente. Pertanto, la formulazione migliore è: "è stato formato un collegamento tra l’Ordine corrente o e la VoceOrdine vo".

- aggiungiProdottoAggiuntivoAll’UltimaPizzaOrdinata(idProdAgg)

Per la post-condizione "è stato formato un collegamento tra la voce ordine vo e una DescrizioneProdottoAggiuntivo dpa sulla base di idProdAgg", è preferibile specificare che questa voce appartiene all’ordine corrente e che il prodotto aggiuntivo è legato all’ultima pizza ordinata. Quindi, sarebbe meglio: "è stato formato un collegamento tra l’ultima voce ordine v dell’Ordine corrente o e una DescrizioneProdottoAggiuntivo dpa sulla base di idProdAgg".

- confermaOrdine(indirizzo, data, ora):

Come accennato sopra, qui va inserita la post-condizione "è stato formato un collegamento tra il cliente c e l'ordine o", perché senza di essa il contratto si limiterebbe a un semplice aggiornamento di attributi; invece, la conferma dell’Ordine è una delle operazioni più importanti.

Infine, la post-condizione che avevo inizialmente scritto, ossia "è stato rotto il collegamento transiente tra l'Ordine o e il portaleAcmePizza", non è necessaria.

4:

Un primo miglioramento riguarderebbe l’ordine con cui vengono presentate le operazioni di sistema nei contratti, tenendo conto dell’esatta sequenza dei passi prevista dal caso d’uso. In particolare, le operazioni “terminaInserimentoPizza” e “terminaInserimentoProdottoAggiuntivo” dovrebbero comparire prima di “confermaOrdine”. Questo evita ambiguità nella lettura dei contratti e rende più chiaro quali azioni avvengono prima della conferma finale dell’Ordine.

Un secondo aspetto migliorabile riguarda la coerenza e la leggibilità dei nomi scelti per le operazioni ed i contratti del sistema tramite una scrittura più chiara, a livello di calligrafia,  contribuirebbe a evitare fraintendimenti. Ad esempio, potrebbe aiutare a distinguere correttamente le iniziali minuscole da quelle maiuscole.

Infine, dovrei fare più attenzione ai nomi dei contratti e delle operazioni, concentrandomi sull’intenzione dell’attore principale piuttosto che sull’azione. In questo modo risulta subito chiaro l’obiettivo che l’utente vuole raggiungere, allineandosi meglio ai casi d’uso.