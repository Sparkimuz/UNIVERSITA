C1.1 - SI, è opportuno creare un nuovo oggetto di tipo Pizzeria dato che il caso d’uso UC1 tratta proprio l’inserimento di una nuova Pizzeria all’interno del sistema, e per farlo è necessario creare un nuovo oggetto di cui poi inizializzeremo i suoi attributi, il nuovo oggetto avrà poi il compito di creare un nuovo oggetto di menù per inserire le pizze e i prodotti aggiuntivi al suo interno. L’operazione di sistema in cui è opportuno creare l’oggetto è l’operazione di sistema n.4 “inserisciNuovaPizzeria(nomeP, desc, città)”

C1.2 - SI, bisogna creare un nuovo oggetto di tipo DescrizionePizza per l’operazione di sistema “inserisciPizzaNelMenu(nome, desc, prezzo)” equivalente alla riga n.5 del caso d’uso UC1. L’oggetto viene creato dall’oggetto Menù e per poi essere di conseguenza aggiunto alla Collezione delle Pizze del Menù

C1.3 - NO, non è opportuno creare un nuovo oggetto di tipo Titolare dato che il caso d’uso UC1 tratta l’inserimento di una nuova Pizzeria da parte di un Titolare già esistente e registrato all’interno del sistema. Se il Titolare non fosse già registrato allora avremmo dovuto creare un nuovo oggetto da inserire nella Mappa dei Titolari dell’Azienda PizzaDelivery.

C1.4 - NO, dato che questo caso d’uso non tratta la gestione e la creazione di Ordini, ne dell’utilizzo del sistema da parte di un cliente, ma solo da parte di un Titolare. Sarebbe opportuno creare un oggetto di tipo Ordine nel caso d’uso UC2 che è il caso d’uso ad hoc per la gestione degli ordini.

C1.5 - Gli oggetti candidati a creare DescrizionePizza sono in ordine di rilevanza:

Menù: dato che la classe Menù ha una composizione con la classe DescrizionePizza

PortaleAcmePizza: dato che esso possiede i dati per la creazione dell’oggetto DescrizionePizza presi dal messaggio trovato

La scelta migliore è la classe Menù dato che contiene le descrizioni delle pizze.

C1.6 - 

Serve l’associazione Titolare → Pizzeria (pizzerie *), richiesta per creare o selezionare le proprie pizzerie.
Serve Pizzeria → Menu (menù 1) perché ogni pizzeria deve mostrare e aggiornare il proprio menu.
Serve Pizzeria → Titolare (titolare 1) per fare in modo che i clienti possano vedere chi è il titolare della Pizzeria che stanno visualizzando.

CHATGPT:
C1.1 - Sì. Poiché UC1 richiede di registrare una nuova pizzeria, è necessario istanziare un oggetto Pizzeria per memorizzarne attributi (nome, descrizione, città). Questo oggetto potrà poi creare il proprio Menù, con pizze e prodotti aggiuntivi. La creazione va effettuata durante l’operazione di sistema 4 «inserisciNuovaPizzeria(nomeP, desc, città)».
C1.2 - Sì. Per poter aggiungere una nuova pizza al menù della pizzeria è necessario istanziare un oggetto DescrizionePizza che contenga nome, descrizione e prezzo. L’oggetto Menu lo crea durante l’operazione di sistema 5 «inserisciPizzaNelMenu(nome, desc, prezzo)» e lo inserisce subito dopo nella propria collezione di pizze.
C1.3 - No. UC1 parte dal presupposto che l’operatore sia un Titolare già autenticato e registrato, quindi non occorre istanziare un nuovo oggetto Titolare: si recupera quello esistente dalla mappa dei titolari di PizzaDelivery. Solo in un (diverso) caso d’uso di registrazione si creerebbe un nuovo Titolare.
C1.4 - No. UC1 riguarda esclusivamente l’inserimento di una nuova pizzeria da parte di un titolare già autenticato e non prevede la gestione di ordini o l’interazione dei clienti, quindi non si devono istanziare oggetti Ordine. La loro creazione sarà invece pertinente al caso d’uso UC2, specifico per la gestione degli ordini.
C1.5 - 

Candidati Creator:
– Menu, perché possiede la collezione di DescrizionePizza (relazione di composizione).
– Pizzeria, poiché contiene il Menu che le include.
– Il PortaleAcmePizza, dato che esso riceve i dati per la creazione dell’oggetto DescrizionePizza presi dal messaggio trovato
Fra questi, Menu è il più adatto: è il vero contenitore delle descrizioni e ne gestisce direttamente il ciclo di vita.
C1.6 - Le associazioni che sono necessarie sono:

1. **Titolare → Pizzeria (pizzerie *)** per cercare o creare le proprie pizzerie in UC1 e gestirle nei casi d’uso di manutenzione.
2. **Pizzeria → Titolare (titolare 1)** per fare in modo che i clienti possano vedere chi è il titolare della Pizzeria che stanno visualizzando come richiesto nei test d’accettazione.
3. **Pizzeria → Menù (menù 1)** perché ogni pizzeria deve mostrare e aggiornare il proprio menu.