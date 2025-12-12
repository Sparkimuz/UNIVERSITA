- Partiamo dal diagramma delle classi di progetto
- Implementiamo facade controller?
- dobbiamo implementare le associazioni, e per scegliere quali ragioniamo sulle interrogazioni dei nostri requisiti “ il sistema mostra l’elenco dei diagrammi correnti per l’utente corrente”, quindi l’associazione tra utente e diagramma è importantissima per rappresentare questa interrogazione lo stesso vale per entità/relazione con diagramma. E’ importante il verso. “Per ciascuna entità vengono visualizzati i loro attributi” quindi anche entità—> attributi
- Nel software non ci interessa il nome dell’associazione proprio ma i nomi degli oggetti coinvolti e le loro molteplicità QUindi dare nomi ai collegamenti pensando anche agli insiemi “Diagrammi” per la classe Diagramma, questa è una variabile di istanza
- Ragioniamo su chi deve conoscere chi, il portale molto probabilmente conosce l’azienda, quindi è necessario un collegamento, stessa cosa tra Azienda e dipendenti
- Applichiamo information expert per il diagramma di comunicazione per trovare l’utente da loginUtente, quindi colleghiamo il protale all’azienda
- low coupling/cohesion è l’ultima spiaggia 10:56 rivedere per continuare questa parte
- La password la deve verificare l’utente e non il controller per motivi di sicurezza
- information expert non lo scrivo di solito quando lo utilizzo
- Nel sistema pos non avevamo messo come candidato creatore lo Store, dato che lo store registra solamente le vendite completate, mentre in questo caso non c’è l’operazione salva e il diagramma viene salvato automaticamente
- Quindi il diagramma viene registrato dal controller e dall’utente, ma dato che il nome del diagramma lo conosce il controller
- nel mondo reale l’utente crea il diagramma, quindi non può crearlo lui nel mondo software - Importantissimo
- Ci sono delle situazioni in cui i parametri delle operazioni coincidono, se succede questo, se sono esattamente uguali, quello che di solito fa il prof è di sostituire queste cose con dei puntini, esattamente gli stessi parametri del messaggio ricevuto che ha causato questa operazione. NON FARE PER EVITARE STRONZATE
- Quando stiamo in dubbio mettiamo collection che è il termine ombrello per le mappe e le liste ecc.

## 13/05

- Se non mettiamo Collezioni nel compito (List, Map) il prof boccia.

Altre informazioni generali (2020):

- Per le interrogazioni che dobbiamo rappresentare (terminaInserimento ecc.) il messaggio rilevato lo colleghiamo al portale/controller e ci mettiamo la notifica “non fa nulla”
- Per decidere chi è il controller, se ci troviamo in un sistema client/server tipicamente il controller è il punto di accesso/portale
- Mai usare Array
- Per cancellare l’elemento in una lista utilizziamo “delete(n)” dove n è l’indice dell’elemento da eliminare
- Per eliminare un’associazione transiente tra il portale e un oggetto, prendiamo la variabile d’istanza pizzeriaCorrente e la eguagliamo a Null—> {pizzeriaCorrente= NULL}
- Non ci conviene far mettere il portale in mezzo al rapporto tra due classi (per esempio Titolare e Pizzeria) dato che aumentano le informazioni che il portale deve sapere su una delle due e dovrebbe aumentare la coesione e/o il coupling