
Esercizi per Preparazione all'Esame - Concetti Chiave

Esercizio 1: Gestione delle Coordinate e del Piano Cartesiano

Scopo: Implementare una classe Coordinate che rappresenta una posizione su un piano cartesiano.

Richiesta: Crea la classe Coordinate con i seguenti metodi:

- public Coordinate(int x, int y): Costruttore per inizializzare la posizione.
- public Coordinate sposta(int dx, int dy): Metodo che restituisce una nuova istanza di Coordinate spostata di dx e dy.
- public boolean equals(Object obj): Metodo per confrontare due coordinate. Due coordinate sono uguali se hanno lo stesso x e y.
- public int distanzaDa(Coordinate altra): Metodo che calcola la distanza (approssimata) tra la posizione corrente e un’altra coordinata altra.

Test: Scrivi test JUnit per verificare che:

- restituisca le coordinate corrette dopo uno spostamento.
- equals funzioni correttamente per due coordinate uguali.
- distanzaDa restituisca la distanza giusta tra due punti noti.

Esercizio 2: Uso delle Direzioni e degli Spostamenti

Scopo: Implementare una classe Direzione che rappresenta la direzione di spostamento.

Richiesta: Crea la classe Direzione con le seguenti caratteristiche:

- Definisci le direzioni NORD, SUD, EST, e OVEST.
- Implementa un metodo opposta che restituisce la direzione opposta di una data direzione.
- Crea un metodo sposta(Coordinate origine) che, data una Coordinate di partenza, restituisce la nuova Coordinate spostata in base alla direzione.

Test: Scrivi test JUnit per verificare che:

opposta restituisca le direzioni corrette (NORD↔SUD, EST↔OVEST).
sposta sposti le coordinate correttamente secondo ciascuna direzione.

Esercizio 3: Definizione di Comportamenti Simili per Entità Diverse

Scopo: Creare una gerarchia di classi per rappresentare entità che condividono comportamenti simili (ad esempio, Persona e Animale).

Richiesta:

- Crea una classe astratta EssereVivente con un metodo astratto muovi(Direzione dir) che specifica la logica per muovere l’essere vivente in una direzione.
- Crea due classi derivate Persona e Animale che implementano muovi. Per Persona, muovi può incrementare la coordinata di una cella. Per Animale, muovi può avere una logica leggermente diversa (ad esempio, può muoversi in due celle alla volta).

Test: Scrivi test per verificare che:

- Persona e Animale implementino muovi come previsto.
- Creando una lista di EssereVivente e richiamando muovi su ciascun elemento, ogni entità si muova come specificato dalla sua classe.


Esercizio 4: Implementazione di Classi Astratte e Metodi Polimorfici

Scopo: Creare una struttura polimorfica per veicoli.

Richiesta:

- Crea una classe astratta Veicolo con il metodo astratto decidiProssimaDestinazione().
- Implementa due classi concrete AutoElettrica e AutoBenzina che estendono Veicolo.
- AutoElettrica decide una destinazione casuale all'interno di un raggio limitato (ad esempio, massimo 5 unità di distanza).
- AutoBenzina può scegliere una destinazione su una distanza più lunga.
- Aggiungi un metodo simulaMovimento() in Veicolo che, in un ciclo di 10 iterazioni, chiama decidiProssimaDestinazione e si sposta verso di essa.

Test: Scrivi test per verificare che:

- AutoElettrica e AutoBenzina scelgano destinazioni con distanze massime come specificato.
- simulaMovimento funzioni correttamente per entrambe le classi, aggiornando la posizione per ciascuna iterazione.


Esercizio 5: Studio delle Simulazioni in main()

Scopo: Creare e testare una simulazione basata su una lista di EssereVivente.

Richiesta:

- Crea una lista di esseri viventi (Persona e Animale dal punto precedente).
- Scrivi un metodo simula() che itera sulla lista, facendo muovere ciascun essere vivente in una direzione casuale ad ogni iterazione.
- A ogni passo, registra le nuove coordinate di ciascun essere vivente in una lista di coordinate.
- Alla fine della simulazione, stampa le posizioni finali di ciascun essere.

Test:

- Esegui main() per verificare che la simulazione funzioni e che le posizioni finali siano coerenti con i movimenti fatti.
- Aggiungi un’opzione per interrompere la simulazione manualmente e visualizzare le posizioni intermedie.


Esercizio 6: Creazione e Verifica di Test Unitari

Scopo: Praticare la creazione di test per verificare il comportamento di metodi critici.

Richiesta:

- Scrivi test per ciascun metodo della classe Coordinate, come equals, distanzaDa, sposta.
- Crea test per verificare la correttezza dei metodi opposta e sposta in Direzione.
- Implementa test specifici per il comportamento polimorfico di muovi su Persona e Animale, controllando che ogni classe si muova come previsto.
Conferma dei Risultati:

- Assicurati che ogni test sia indipendente e confermi l’esattezza di ogni metodo.
- Modifica i metodi se i test falliscono, e ripeti il test fino a ottenere risultati corretti.
