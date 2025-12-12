# UC1

- registraEntrata(codiceDipendente)
    - PRE:
        - nessuna
    - POST:
        - E’ stata creata una nuova Presenza P
        - E’ stato formato un collegamento tra il Dipendente D e la Presenza P del tipo “sta effettuando”
        - E’ stato un formato un collegamento tra il PortaleAcmeLab e il Dipendente D sulla base di codiceDipendente
        - Gli attributi dataEntrata e oraEntrata sono stati inizializzati e aggiornati
- registraUscita(codiceDipendente)
    - PRE:
        - Un dipendente D vuole registrare l’uscita per la presenza P
    - POST:
        - Gli attributi dataUscita e oraUscita sono stati inizializzati e aggiornati
        - è stato formato un collegamento tra il Dipendente D e la presenza P del tipo “ha effettuato”

# UC3

- iniziaVenditaCongegni
    - PRE:
        - nessuna
    - POST:
        - è stato creata una nuova vendita V
        - è stato formato un collegamento tra la vendita V e il PortaleAcmeLab
        - è stato formato un collegamento tra un dipendente D e il portaleAcmeLab
- inserisciCliente(codiceCliente)
    - PRE:
        - il Dipendente D sta effettuando la vendita V
    - POST:
        - è stato formato un collegamento tra la vendita V e un cliente C
- inserisciCongegno(numeroDiSerie)
    - PRE:
        - il Dipendente D sta effettuando la vendita V
    - POST:
        - è stata creata una nuova RigaDiVendita RV
        - è stato formato un collegamento tra la RigaDiVendita RV e la Vendita V
        - è stato formato un collegamento tra la RigaDiVendita RV e un CongegnoCostruito C
- terminaInserimentoCongegno
    - PRE: il Dipendente D sta effettuando la vendita V
    - POST: nessuna
- effettuaPagamentoContanti(importoPagato)
    - PRE:
        - il Dipendente D sta effettuando la vendita V
    - POST:
        - è stato creato un nuovo PagamentoContanti P
        - è stato formato un collegamento tra il PagamentoContanti P e la vendita V
        - è stato formato un collegamento tra la vendita V e il dipendente D