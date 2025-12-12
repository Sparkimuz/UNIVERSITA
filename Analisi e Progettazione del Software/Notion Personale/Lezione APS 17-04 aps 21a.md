-Almeno un  collegamento per oggetto è necessario per evitare che il garbage collector lo cancelli

- Di solito il controller è uguale per ogni caso d’uso, quindi se scelgo register nel caso UC1 lo utilizzo anche in UC2 ecc.
- Per salto rappresentazionale basso conviene creare SalesLineItem???
- I suggerimenti per i creator di un oggetto sono:(1 domanda importante)
    - l’oggetto fa parte di una composizione di un altro oggetto(SalesLineItem con Sale)(CONTIENE?)
    - Chi è che concettualmente registra le righe di vendita per articolo?(Register) (REGISTRA?)
    - chi è che deve usare strettamente questi oggetti(chi è che chiede il prezzo totale a SalesLineItem? La vendita)(UTILIZZA?)
    - Chi possiede i dati necessari per l’inziializzazione dei dati dell’oggetto? (Chi conosce la quantità degli articoli di SalesLineItem? Il Controller, cioè il register, perché il cassiere inserisce tramite enterItem la quantità nel Controller)(INIZIALIZZA DATI?)
        - Viene deciso Sale perché è il primo candidato
- Ma qual è l’oggetto di classe Sale che deve creare le righe di vendita? la SaleCorrente(2 domanda importante)
- Chi chiede alla vendita corrente di creare il nuovo oggetto SalesLineItem
    - quale pattern devo applicare? info expert, low coupling cohesion ecc.? Normalmente si applica information expert
    - Chi glielo può chiedere deve conoscere l’oggetto che crea le righe di vendita
    - Il controller ha la responsabilità di conoscere la vendita corrente(Quindi il register)
        - Come si sceglie il nome di questa operazione?
        - Il libro sceglie makeLineItem(creaRigaDiVenditaPerArticolo) tra Register e currentSale
        - Ma questa operazione praticamente fa che Register chieda a currentSale di creare una nuova SalesLineItem, poi da Sale a SalesLineItem abbiamo la classica operazione: create()
- Chi associa il nuovo oggetto SalesLineItem alla SaleCorrente?
    - Bisogna capire intanto in che verso deve essere navigabile questa associazione
    - La SaleCorrente deve fare l’add alla collezione lineItems tramite un’associazione ordered, dato che l’associazione tra Sale e SalesLineItem è 1 a molti
    - Potrei essermi scordato di creare la collezione di SalesLineItem, mi devo chiedere quand’è il momento migliore per creare questo oggetto?? Quando creo la Sale, quindi creo la collezione inizialmente vuota appena creo Sale
- In generale quando creo un’associazione/collegamento devo chiedermi in che direzione deve essere navigabile per capire chi lo crea o in generale da chi parte l’operazione
    - Prima di poter formare questi collegamenti dobbiamo sapere il riferimento a quell’oggetto(per esempio il collegamento tra SLI e ProductDescription) con informationExpert diamo la responsabilità ad un oggetto che conosce tutti i riferimenti, quindi diamo questa responsabilità al productCatalog
    - Il product catalog contiene una mappa di tutti i prodotti
    - Ad un certo punto avremo il :PC che fa come operazione get(itemID) su un oggetto Map<PD>
    - Un modo per chiamare e prendere la ProductDescription avremo un’operazione che si collega al :PC che si chiamerà getProductDescription(itemID), quindi l’oggetto ProductCatalog fornirà funzioni per cercare il PD e magari anche aggiungerli
- Ricordarsi che il modello di dominio non ci vincola nel modello di progetto, possiamo fare dei collgamenti che saltano altre classi, per esempio Register——Store——ProductCatalog normalmente, però facciamo che il register si collleghi a ProductCatalog e gli chieda il ProductDescription sulla base di ItemID.
- Lo fa il register perché conosce il ProductCatalog, mentre la Sale non lo conosce e dovrebbe prendere le informazioni da register che è un controller
- Questo è un “pattern”: IDs to Objects(paragrafo29.8)
- I parametri devono essere valori, di solito riferimenti, e non oggetti(importante)
- MOSTRARE SEMPRE LA FORMAZIONE DEI COLLEGAMENTI (attributi poco importanti)
- IL COSTRUTTORE (create) DA SCRIVERE SEMPRE CON I PARAMETRI perché inizializza l’oggetto in uno stato iniziale che sia funzionale e pronto. quindi create(desc, qty) ecc.
- MAI USARE SETDESCRIPTION ECC. PER SETTARE GLI ATTRIBUTI
- Slide 28 importante, quelli blu sono quelli che sono usati in più casi d’uso, quelli in rosso sono quelli usati nel caso d’uso corrente, se non vengono usati in altri caso d’uso allora li teniamo rossi e ci chiediamo perché li abbiamo inseriti, scritto anche nel testo di esame se sono da mostrare
- I collegamenti per uno specifico caso d’uso non sono da creare solamente in quel caso d’uso, è giusto crearli quando viene gestita quell’operazione negli altri casi d’uso per esempio se devo registrare la quantità di volte che viene venduto un oggetto nel caso d’uso UC3 e la vendita degli oggetti sta nel UC2 allora creiamo il collegamento nell’UC2

Powerpoint aps22

- Nell’invio di un messaggio, il mittente deve conoscere un riferimento al destinatario, conoscere il riferimento del destinatario si chiama **VISIBILITA’**, quindi il mittente deve avere VISIBILITA’ del destinatario
- Esistono 4 modi comuni per avere visibilità (da A a B)
    - Visibilità per attributo
        - B è un attributo di A (ha una durata lunga di visibilità dato che rimane nell’oggetto finché non viene eliminato dalla memoria)
    - Visibilità per parametro
        - B è un parametro di un metodo di A(ha una durata relativamente breve dato che permangono solo per i metodi come makeLineItem e create(desc, qty))
    - Visibilità locale
        - B è un oggetto locale in un metodo di A( ha una durata breve dato che permane solo durante l’esecuzione di makeSale ecc.)
    - Visibilità globale
        - B è in qualche modo visibile globalmente - pericolosa perché tende a portare ad un accoppiamento alto
- Tra register e catalog c’è una visiblità per attributo
- Tra Sale e SaleLineItem c’è una visibilità per parametro
- Tra Register e ProductDescription c’è una visibilità locale
- Il register ha una visibilità locale su ProductDescription ma la trasforma a visibilità per parametro tra Sale e ProductDescription tramite makeLineItem, e da Sale a SalesLineItem che sta in parametro, lo trasforma in visibilità per attributo a

Domanda che fa all’esame??

- Trova tutti i creatori candidati di un oggetto(molto importante)