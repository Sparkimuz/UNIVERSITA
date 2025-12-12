Continuo di [[Lezione 3 09-10-2023 Prima parte]]

# Standard IEEE 802
Obiettivi:
- definire un insieme di standard di livello fisico e livello data-link per reti locali (e reti metropolitane)
- gli standard riguardano tecnologie con pacchetti di lunghezza variabile

Lo standard IEEE 802 tiene conto dei primi due livelli del modello iso-osi, dunque il livello fisico e il livello data link.

## Il sottolivello MAC - Media Access Control

- Specifico pero ogni tipo di lan
- Si assume che ci sia un unico canale condiviso (un lan, come se fosse una nuvoletta che collega tutti i sistemi collegati), risolvendo due problemi:
	- **in trasmissione** verifica disponibilità canale e risolve conflitti
	- **in ricezione** determina destinatario e mittente (Utilizzo di indirizzi MAC)

#### Richiamo Terminologico
pdu= protocal data unit = pacchetto = trama
sap = service access point

## Indirizzi MAC

Ogni sistema collegato alla rete locale ha un proprio indirizzo MAC, ogni indirizzo MAC sono 6 byte, sono unici a livello mondiale:
- 3 byte per riconoscere il costruttore del sistema (Samsung, iphone ecc.)
- 3 byte definiti dal costruttore
- ogni gruppo di 4 bit è rappresentato da una cifra compresa tra 0 e F

Gli indirizzi MAC sono codificati in esadecimale, i byte sono separati tra di loro da due punti o da trattini.
ES: 00:25:9E:3C:07:9A è un indirizzo MAC

Diversi tipi di indirzzi:
- Unicast: identifica singola scheda di rete
	- Ultimo bit del primo byte ha valore zero
- multicast: identifica gruppi di schede di rete
	- Ultimo bit del primo byte ha valore uno
- broadcast: tutte le schede di rete
	- indirizzo MAC è FF:FF:FF:FF:FF:FF

lo standard che stabilisce il formato degli indirizzi MAC si chiama EUI-48 (Extended Unique Identifier).

E' possibile assegnare indirizzi MAC uguali, soprattutto per l'utilizzo di macchine virtuali che non hanno bisogno di un indirizzo MAC ufficiale. Se il penultimo bit del primo byte ha valore zero, allora l’indirizzo MAC è unico a livello mondiale e l’unicità è gestita attraverso gli OUI

## MAC pdu
La MAC pdu è formata da vari campi, tra cui gli indirizzi MAC:

MAC pdu:
MAC-dsap - MAC-ssap - info(payload)

dsap = destination service access point
ssap = sender/source service access point

## Il sottolivello LLC (Logical Link Control)
Campi del pacchetto LLC:

LLC-dsap - LLC-ssap - control(tipo pdu) - info(payload di livello 3)

Il campo control varia e ci fornisce varie tipologie di pacchetti, ma noi ne vedremo solamente uno

### Indirizzi LLC
- LLC-dsap e LLC-ssap servono a denotare i protocolli di livello 3 a cui sono destinati i pacchetti 
- consentono la convivenza di diversi protocolli di livello 3 (e di diverse pile protocollari) sulla stessa LAN e sulla stessa macchina
- il dsap permette al LLC di mandare il pacchetto ad uno specifico protocollo di livello 3, mentre altri protocolli di livelli 3 sono aperti allo stesso momento.

#### Esempi (hex)
Attribuiti da IEEE solo ai protocolli ufficialmente standard
- 42 (802.1D)
- AA (snap)
- F0 (netbios)

Se gli LLC-sap hanno valore AA allora il pacchetto è di un protocollo non standard
	- in questo caso (snap-pdu) dopo il campo control c’è un campo protocol identifier di 5 byte