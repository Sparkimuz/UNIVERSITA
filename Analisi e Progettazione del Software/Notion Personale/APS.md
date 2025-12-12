APS

Interazioni con il sistema (Ci interessano solo queste):

- Che cosa chiediamo al sistema?
- Come risponde il sistema?

Azioni del sistema

Variazioni al sistema

Per eseguire delle operazioni di sistema, il sistema deve prima ricevere gli eventi di sistema che sono le interazioni che richiedono l’esecuzione delle operazioni (cassiere che mette il codice identificativo per ricevere il prodotto associato)

In UML:
- un evento è qualcosa di importante o degno di nota che avviene
durante l’esecuzione di un sistema
- un’operazione rappresenta una trasformazione oppure
un’interrogazione che un oggetto o componente può essere
chiamato a eseguire
Inoltre:

- un evento di sistema è un evento esterno al sistema, di input,
generato da un attore per interagire con il sistema
- un’operazione di sistema è una trasformazione oppure
un’interrogazione che il sistema può essere chiamato a eseguire

Un diagramma di sequenza di sistema (SSD) mostra, per uno
specifico scenario di un caso d’uso, gli eventi di sistema generati da
attori esterni e il loro ordine

L’insieme di tutte le operazioni di sistema definisce l’interfaccia
del sistema

SSD: Diagramma di sequenza di sistema

- le operazioni di sistema gestite dal sistema in un SSD rappresentano
chiamate di operazioni dallo strato UI allo strato Domain o Application
- Un SSD descrive l’interfaccia (parziale) dello strato del dominio
    
    

Nella progettazione ci sono vari strati:

- User Interface(UX/UI)
    - mostra informazioni all’utente e interpreta le sue richieste
- Application
    - definisce un’API unificata per sostenere la realizzazione di più
    UI o client – in pratica, definisce i compiti che il sistema è
    chiamato a fare, ovvero le “operazioni di sistema”.
    Di solito è responsabile anche di gestire lo stato delle
    conversazioni (sessioni) con i suoi client
- Dominio
    - rappresenta il modello di dominio
- Infrastruttura
    - fornisce capacità tecniche per supportare gli strati superiori –
    ad es., l’accesso ai dati