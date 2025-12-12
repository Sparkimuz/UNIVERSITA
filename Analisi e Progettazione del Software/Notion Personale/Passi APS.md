Passi APS:

Scrivere sul foglio in orizzontale

Diagramma delle classi:

- Primo passo: Individuare le classi concettuali candidate per il diagramma
- Parto dal concetto principale e inizio a scegliere le classi più rilevanti
- Chiamare il punto di accesso a cui accede il client “Portale …”
- Gli elementi software come il salvataggio dei dati non ci va
- Bisogna creare una classe per un insieme se questo ha un nome specifico (Listino prezzi, Offerta formativa, la Corte)
- Il concetto più importante lo mettiamo al centro del diagramma
- Le associazioni le chiamiamo basandoci sul testo di riferimento e su i casi d’uso
- Le composizioni sono spesso delle associazioni chiamate “Contiene”
- Per le composizioni possiamo ragionare su come dipende la vita delle classi tra di loro
- Di solito quando abbiamo un ciclo di associazioni una di quelle è probabilmente derivata
- Criterio per cancellare le associazioni derivate, non può essere cancellata se rappresenta qualcosa di significativo nel dominio che verrebbe meno se la cancellassi (Perdendo info su composizione)
- Le associazioni si basano sulla necessità di ricordare
- Le azioni presenti “Crea” “Vede” ecc. sono ambigue, io mi devo ricordare che l’ha creato, non che lo sta creando, quindi è meglio “Ha creato”

Diagramma degli oggetti di dominio:

Contratti:

- Quando creiamo e descriviamo un contratto dobbiamo vedere e descrivere il mondo dal punto di vista dell’attore che esegue il contratto, (il cassiere registra la vendita su IL registratore, dato che lui ne ha assegnato solo 1)
- Si devono fare delle associazioni transienti per poter capire come funziona il sistema (sale——register)
- Le pre-condizioni dobbiamo definirle sempre dal punto di vista del registratore, cioè ciò a cui è riferito/associato la vendita (???)
- Attenzione alla creazione degli oggetti, solo quelli che vengono coinvolti e quelli che già esistono chiaramente no
- Attenzione agli articoli, c’è molta differenza tra un registratore, il registratore, una vendita, la vendita dipende tutto da che punto vediamo il sistema
- E’ vietato scrivere nei contratti, “Il sitema registra”, “il sistema mostra”, questi fanno parte dei casi d’uso non dei contratti
- Se un’associazione transiente/collegamento viene rotto a metà del contratto è giusto scriverlo in un commento(che non vale come post-condizione di contratto) e invece se viene rotto alla fine non ha senso scriverlo

Modello di dominio semplificato:
Modello di dominio con associazioni classi cardinalità ma nessun attributo

Per rappresentare l’utilizzo temporaneo in questo momento tra un utente e un portale usiamo delle associazioni transienti(facoltative) (0..1 ——- 0…1) e lo chiamiamo sta usando, spesso usato per  rappresentare gli elementi come “DiagrammaCorrente” e “UtenteCorrente”

Operazioni di sistema:

Notazione java: “operazioneSistemaInserimento”, viene usato principalmente l’imperativo “creaDiagramma”, “loginUtente”, si aggiungono le variabili in parentesi es. (email, pwd), (nome, desc).

Inserisici/aggiungi sono parole ambigue non conviene utilizzarle dato che implicano che quell’oggetto esista da prima, di solito si usa “crea…”

Anche per le operazioni che richiedono un attributo esistente si mettono gli attributi tra parentesi.

nelle post condizioni dobbiamo mettere solamente i cambiamenti di stato dovuti da questa operazione: sicuramente non va scritto l’utente è stato autenticato,

Noi guardiamo le operazioni dal punto di vista di una istanza (su tante) del portale/sistema

per le postcondizioni tipicamente aggiungiamo i puntini per indicarne diverse dello stesso contratto

I contratti delle operazioni di sistema, per avere delle precondizioni sensate e logiche, devono essere ordinati in modo logico e sistematico, quindi se voglio aprire un diagramma con una precondizione utente corrente, dobbiamo prima aver fatto fare il login all’utente

Contratti delle operazioni di sistema Eredit:

- loginUtente(email, pwd)
    
    pre: la precondizione è nessuna dato che è la prima operazione del caso d’uso
    
    post:(sarebbe sbagliato dire è stato creato un utente, perché per poter fare il login il sistema doveva già conoscerlo e quindi già esisteva) - è stato **formato(terminologia importante)** un collegamento **fra IL** portale ERedit
    
    **e UN** Utente u
    
    **di tipo “sta usando” (nome dell’associazione)**
    
    **sulla base** di email e pwd **(attributi necessari per fare il login)**
    
    (format importante)
    
- apriDiagramma(nome)
    
    pre: l’utente u sta usando il sistema
    
    post: è stato formato un collegamento fra IL portale Eredit
    
    e un Diagramma d
    
    di tipo è corrente (omettibile perché non ci sono ambiguità)
    
    sulla base di nome e dell’utente corrente u (possiamo citare un oggetto nelle post condizioni con il suo nome solo se lo abbiamo citato nelle precondizioni)
    
- creaDiagramma(nome, desc)
    
    pre: l’utente (tra un e l’utente non cambia molto detto da lui) u sta usando il sistema
    
    post: - è stato creato un nuovo Diagramma d
    
        - è stato formato un collegamento tra il portale ERedit e il Diagramma d
    
        - è stato formato un collegamento tra il diagramma d e l’utente corrente u
    
        - attributi di d inizializzati (poco importante)
    
- creaEntita(nome, desc)
    
    pre: l’utente u sta modificando il diagramma d
    
    post: -è stata creata un’entità e
    
        - è stato formato un collegamento tra l’entità e e il diagramma corrente d
    
        - attributi di e inizializzati
    
- creaAttributo(nome A, desc, tipo, nome E)
    
    pre: l’utente u sta modificando il diagramma d
    
    post: - è stato creato un attributo a
    
        - è stato formato un collegamento tra l’attributo a e un’entità e del diagramma corrente d sulla base di nome E
    
        - attributi di a inizializzati