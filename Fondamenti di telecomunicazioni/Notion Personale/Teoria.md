## **Componenti di un sistema di telecomunicazione**

- **sorgente**: genera il segnale da trasmettere
    
    [Codifica di Sorgente:]Per trasmettere un segnale analogico attraverso un canale affinché raggiunga un destinatario è importante prima di tutto lavorare sulla sorgente con un processo di codifica che passa attraverso le seguenti tre fasi:

### Campionamento

Consiste nella trasformazione di un segnale analogico in un segnale numerico. Questo processo avviene tipicamente attraverso un ***convertitore analogico-digitale*** (anche noto come D.A.C.)

Durante questo processo il segnale analogico viene campionato a intervalli regolari, cercando di evitare aliasing e convertito in un segnale numerico discreto.

Affinché si possa evitare aliasing è sufficiente utilizzare la frequenza di campionamento di Nyquist:

$f_c \ge 2f_{max}$

Chiameremo questa così ottenuta la ***frequenza di simbolo:*** $f_s$

### Quantizzazione

![image.png](attachment:d3ac6c19-576a-42f6-8494-6fefe8cc4ed5:image.png)

Una volta che il segnale è stato campionato si utilizza un quantizzatore che consente di suddividere il segnale in intervalli e associa a ciascun intervallo un valore numerico corrispondente, ovviamente introducendo un certo grado di errore nella trasmissione.

Ogni intervallo di quantizzazione vale $\Delta={A_{max}-A_{min} \over M}$ dove $M$ indica il numero di intervalli.

Ovviamente tanto più $M$ è grande, cioè $\Delta$ è piccolo, tanto migliore sarà il sistema di trasmissione in termini di accuratezza.

L’errore che si commette è pari a $e_q[n]=x[n]-x_q[n]$  ed è una variabile aleatoria con probabilità di errore pari a $P_e(e)={1 \over \Delta}rect({e \over \Delta})$  assumendola uniformemente distribuita sull’intervallo $[{-\Delta \over 2}; {\Delta \over 2}]$.

È possibile calcolare la potenza dell’errore di quantizzazione, ricordando che è una variabile aleatoria: $P_{eq}={V^2 \over 3M^2}$

Molto più spesso però la si indica in dB (decibel):

$(P_{eq})_{dB}=10log_{10}({V^2 \over 3})-10log_{10}(M^2)=10log_{10}({V^2 \over 3})-10log_{10}(2^{2k}) \approx 10log_{10}({V^2 \over 3})-6k$

Possiamo calcolare la potenza del segnale $P_x={V^2 \over 3}$ e stabilire una relazione che definiamo **rapporto tra segnale e rumore di quantizzazione:**

$(SNR_q)_{dB}=({P_x \over P_{eq}})_{dB}=(P_x)_{dB}-(P_{eq})_{dB}=6k$

### Codifica della sorgente in bit

Al termine del processo di quantizzazione, ogni campione viene convertito in una sequenza di bit in base al numero di livelli di quantizzazione. Al termine dell’operazione di codifica in bit il segnale è pronto per la trasmissione digitale.

Per sapere quale sia il numero di bit necessari per effettuare la codifica dopo aver effettuato la quantizzazione basterà applicare la seguente formula $k=log_2(M)$

### Algoritmi efficienti per la codifica

Non sempre però la codifica binaria naturale è efficiente in quanto più è elevato il bit-rate (cioè la cadenza dei bit da trasmettere) e più il sistema necessiterà di banda e potenza.

Per questo motivo è spesso necessario scegliere l’algoritmo di codifica più efficiente che minimizzi il bit-rate senza alterare le caratteristiche del segnale.

Tutti questi algoritmi si fondano sul concetto che non tutti i simboli hanno la stessa probabilità di essere trasmessi, sapendo infatti che il valor medio $\mu_{bitrate} = E[bitrate]=f_s \sum_1^M P_iK_i$ è possibile far variare il numero di bit $K_i$ per migliorare il parametro.

![image.png](attachment:c7a6fa3c-7c09-4faa-80d7-183bbde612e9:image.png)

**Algoritmo di codifica di Huffman**

![image.png](attachment:2ce4417d-057a-49b3-9794-45a239138dbe:image.png)

L’algoritmo di Huffman consente di codificare una sorgente con lunghezza di bit variabili

Ha il pregio di avere prestazioni che si avvicinano spesso al limite teorico di bit minimi senza perdita di informazione ($I=log_2{1 \over P_i}$)(formula autoinformazione), che è definito dall’***entropia di sorgente:***

$H=\sum_1^MP_ilog_2(1/P_i)=\sum_1^MP_iI_i$

Si basa su due principi:

1. i simboli più probabili vengono codificati con parole di codice composte da meno bit
2. nessuna parola di codice deve essere prefisso di un’altra

Questo algoritmo consente quindi di costruire un grafo partendo dalle foglie più in basso e arrivando alla radice sommando a due a due le probabilità più basse. 

Una volta terminato le parole di codice a lunghezza variabile ottenute per ogni label di probabilità si leggono a partire dalla radice e arrivando alla foglia corrispondente.
    
- algoritmi che consentono di evitare la ridondanza e di quantizzare l’informazione da trasmettere in modo efficiente
    
    [Codifica di canale:]### Rilevazione e correzione di errori

Tutti i sistemi di codifica di canale studiati per avvicinarsi al limite teorico di Shannon si basano sull’aggiunta di **bit di ridondanza per rilevare e/o correggere gli eventuali errori**.

Analizziamo quindi i codici a blocco, in cui si trasmettono blocchi di $L$ bit (*parole di codice*) di cui solo $K$  contengono l’informazione; i restanti $L-K$  bit sono ridondanti.

Questo comporta che il bit-rate così codificato sarà:  $R_c = {R_bL \over K}$

In questo modo possiamo codificare $2^L$ parole, di cui solo $2^K$ saranno realmente utilizzate e che vengono scelte sulla base della **distanza di Hamming**, definita come il numero di bit diversi tra l’una e l’altra parola di codice.

In generale possiamo concludere che:

1. affinché sia possibile **rilevare $g$ errori** la distanza di Hamming minima deve essere:
    
    $d_{min}≥g+1$
    
    una volta identificati gli errori è possibile utilizzare delle tecniche come **ARQ (Automatic Repeat Request)** per farsi inviare nuovamente la trasmissione.
    
2. affinché sia possibile **correggere $t$ errori** la distanza di Hamming minima deve essere:
    
    $d_{min}≥2t+1$
    
    una delle tecniche di correzione più usate è detta **FEC (Forward Error Correction)**, in cui si sceglie una $d_{min}>2$
    
- algoritmi che introducendo ridondanza consentono di rendere meno sensibile la trasmissione al rumore, individuando e/o correggendo errori

[Modulazione:]### Modulazione: banda base (filtro passa-basso) [CAPITOLO 8]

Affinché un segnale numerico possa essere trasmesso in un canale fisico deve essere modulato così da trasformarsi in un segnale analogico mediante un modulatore.

Nel caso che analizziamo ora, modelliamo il canale come un filtro passa-basso (questo modello è valido ad esempio per le connessioni Ethernet).

Consideriamo una segnale numero con un dizionario di M simboli da trasmettere. Possiamo leggere i suoi bit a blocchi di $k$, perciò il dizionario sarà formato da $M = 2^k$ simboli.

Per poter trasmettere il segnale numerico, associamo quindi ad ogni simbolo un valore reale:

$c_m$ $(1 \le m \le M)$

Dopo aver effettuato questa codifica ogni segnale numerico corrisponderà ad una sequenza $s[n]$ i cui campioni appartengono ad un dizionario di $M$ numeri reali $c_m$.

Ogni simbolo si presenta ogni $T_s$ secondi, $T_s$  è detto ***tempo di simbolo*** e $R_s = {1 \over T_s}$ è detto ***cadenza di simbolo***.

Gli M simboli sono associati biunivocamente a parole binarie lunghe $k = log_2 M$, perciò possiamo definire anche il ***tempo di bit*** $T_b={T_s \over log_2 M}$ e la ***cadenza di bit*** $R_b=kR_s=R_slog_2M$

### Tecnica di trasmissione PAM (Pulse Amplitude Modulation)

Per ottenere un segnale analogico $x(t)$ trasmissibile sul canale occorre associare ad ogni valore reale $c_m$ della sequenza numerica $s[n]$ un segnale analogico $x_m(t)$  con le seguenti caratteristiche:

1. banda massima non superiore a quella del canale ($B$)
2. in ricezione, dopo averlo campionato a passo $T_s$, ogni campione deve essere univocamente associato al valore $c_m$ trasmesso

Un segnale che rispecchia queste caratteristiche è $x_m(t)=c_mg(t)$, dove $g(t)$ è un impulso in banda base assimilabile alla definizione di una $sinc$ per multipli di $T_s$.

Interferenza Inter-Simbolica (I.S.I.)

È un fenomeno di distorsione causato dalla banda limitata del canale, che si comporta come un filtro passa-basso e "allarga" temporalmente gli impulsi trasmessi. A causa di questo allargamento, la coda di un impulso va a sovrapporsi al simbolo successivo (e precedente), rendendo difficile per il ricevitore distinguere correttamente il valore trasmesso (chiusura del diagramma ad occhio).
Per eliminare l'I.S.I. è necessario che l'impulso $g(t)$ rispetti il Primo Criterio di Nyquist: deve avere passaggi per lo zero precisi agli istanti di campionamento degli altri simboli $g(kT_s) = 0$ per $k \neq 0$). La funzione $sinc$  è l'impulso ideale che soddisfa questa condizione con la minima banda possibile.

E’ noto che la la banda della $sinc$ è $1/2T_s$ (la sua trasformata è una $rect$), ne consegue che la minima banda B del canale passa-basso necessaria ad una trasmissione senza interferenza intersimbolica è metà della cadenza di simbolo $R_s$(Baud).

Perciò: $B \ge {R_s \over 2}$ e $R_s \le 2B$

Quindi associandolo ad ogni valore tramite una sommatoria otteniamo il segnale analogico:

$x(t)=\sum_n s[n]g(t-nT_s)$

Questa formula definisce la tecnica PAM, in cui un impulso in banda base viene modulato in ampiezza dal valore $c_m$ associato al simbolo della sorgente numerica che si vuole trasmettere.

### Tecnica di trasmissione PCM (Pulse Coded Modulation)

La stessa tecnica prende il nome di PCM se $s[n]$  è un sequenza numerica ottenuta a partire da un segnale analogico in sorgente campionato, quantizzato e codificato.

### Effetto del rumore

Tutti i canali di trasmissione introducono del rumore termico $n(t)$ descritto come un processo aleatorio con densità di probabilità gaussiana a valor medio nullo $\mu_n=0$ e densità spettrale di potenza costante pari a $G_n(f)={N_0 \over 2}$

In ogni sistema di ricezione si filtra sempre il rumore all’interno della banda di interesse con un filtro h(t) ideale a banda $B$ che non altera il segnale trasmesso $x(t)$.

Il segnale in uscita dal filtro h(t) sarà dunque inalterato:

$y(t)=x(t)+n(t)$

Se lo campioniamo otteniamo $y(nT_s)=s[n]+n[n]$, ciò significa che in ricezione si stabilisce che è stato trasmesso un valore $c_m$ in base a quello che più si avvicina al valore $y(nT_s)$. Questo ovviamente genera un certo margine di errore.

### Calcolo della probabilità di errore

Per semplicità scegliamo un vocabolario di simboli con M=2 equiprobabili associati alle ampiezze $c_1$ e $c_2$.

In uscita dal filtro h(t) otteniamo quindi $c_1 + n$ oppure $c_2 +n$ in base a quale dei due simboli è stato trasmesso.

In ricezione si sceglie come simbolo quello più vicino al valore misurato e dunque si commette errore quando:

$\dot c_1 \ge c_1 + {|c_2 - c_1| \over 2}$

$\dot c_2 \le c_2 - {|c_2 - c_1| \over 2}$

La probabilità di commettere un errore nella scelta del simbolo (nel caso ad esempio in cui trasmettiamo $c_1$) è pari a:

$P_e(e)={1 \over 2}\int_V^{-\infty}P_{\dot c_1}(a)da={1 \over 2}efc({V-c_1 \over \sqrt 2 \sigma_n})=Q({V-c_1 \over \sigma_n})$

(dove $P_c(a)$ indica una distribuzione di probabilità gaussiana)

E’ possibile calcolare il BER (Bit Error Rate) di un sistema per verificarne il suo tasso di errore per bit come segue:

$BER = {1 \over 2} Q({V - c_1 \over \sigma_n})+{1 \over 2} Q({c_2 - V \over \sigma_n})$

Affinché il BER sia minimo si deve porre la soglia di decisione come segue:

$V=c_1+{d \over 2}=c_2-{d \over 2}$ (dove $d=|c_2 - c_1|$)

$BER = Q({d \over \sigma_n})=10^{-9}$ (con ${d \over \sigma_n} = 6$)

In questo caso si dice che il sistema è **error-free.**

### Filtro adattato

Invece di utilizzare un filtro h(t) ideale a banda B, possiamo utilizzare un filtro adattato che consente di migliorare le prestazioni.

Studiamo quindi l’uscita del segnale da un filtro $h_0(t)$:

$y(t)=[x(t)+n(t)]*h_0(t)=[\sum_nc_mg(t-nT_s)+n(t)]*h_0(t)$

$c_mg(t-nT_s)*h_0(t)=c_m\int G(f)H_0(f)e^{i2 \pi ft}df$

Per trovare il segnale utile scelgo t=0, l’espressione diventa quindi:

$c_m\int G(f)H_0(f)df$

Calcoliamo e definiamo quindi un SNR (Signal Noise Ratio), cioè il rapporto tra la potenza del segnale utile e la potenza del rumore:

$SNR={c_m^2|\int G(f)H_0(f)df|^2 \over \int {N_0 \over 2}|H_0(f)|^2df}$

Utilizzando la disuguaglianza di Schwarz possiamo quindi ricavare il valore ottimo del filtro:

${c_m^2|\int G(f)H_0(f)df|^2 \over \int {N_0 \over 2}|H_0(f)|^2df} \le c_m^2{\int |G(f)|^2df \cdot \int |H_0(f)|^2df \over {N_0 \over 2} \int |H_0(f)|^2df}={2c_m^2 \int |G(f)|^2df \over N_0}={2c_m^2}{E_g \over N_0}$

Questa relazione è massima (cioè i due membri sono uguali) se $H_0(f)=G^*(f)$.

In pratica il filtro adattato ottimale $h_0(t)=g(-t)$ ha la stessa forma dell’impulso in banda base ribaltato nel tempo, la cui risposta in frequenza è uguale alla sua trasformata complessa e coniugata.

Calcoliamo ora il BER nel caso usiamo questo filtro adattato (per semplicità usiamo ancora un alfabeto di simboli con M=2):

$BER=Q({\sqrt{SNR_1} - \sqrt{SNR_2} \over 2}=Q({(c_1 - c_2)} \sqrt{E_g \over 2N_0})$

Studiamo due casi:

1. i due simboli sono unipolari, cioè $c_1=0$
    
    $BER=Q(c_2 \sqrt{E_g \over 2N_0})$ → $BER=Q(\sqrt{2E_b \over N_0})$
    
2. i due simboli sono bipolari, cioè $c_2=-c_1$
    
    $BER=Q(2c_2 \sqrt{E_g \over 2N_0})$ → $BER=Q(\sqrt{2E_b \over N_0})$
    
    In questo caso l’argomento della funzione Q è doppio (la distanza tra i simboli è doppia), pertanto il BER è migliore.
    
    *NB:* $E_b={c_1^2E_g+c_2^2E_g \over 2}$ ed è utile per fornire il valore del BER in termini di bit
    

### Modulazione: banda passante (filtro passa-alto) [CAPITOLO 9]

A volte è necessario trasmettere un segnale in un canale che ha una sua frequenza portante $f_0≠0$, ad esempio i canali wireless come il Wi-Fi.

In tal caso modelliamo il canale come un filtro passa-alto, in cui gli impulsi in banda base G(f) sono centrati alla frequenza portante in $-f_0$ e $f_0$ e hanno banda $B$.

### Tecnica di trasmissione AM (Amplitude Modulation)

Partendo quindi dal segnale in banda base ottenuto precedentemente:

$x(t)=\sum_n s[n]g(t-nT_s)$

Dobbiamo modularlo intorno alla frequenza portante $f_0$ e per farlo utilizzeremo come filtro il coseno:

$z(t)=x(t)cos(2 \pi f_0t)=c_mg(t)cos(2 \pi f_0t)$

$Z(f)={c_m \over 2}[G(f-f_0)+G(f+f_0)]$

Questo processo ci consente di creare due copie del segnale, una a frequenze negative e una a frequenze positive. Ciò mi serve per spostare il segnale nella banda portante del canale che voglio usare.

Notiamo però che $f_{max}={B \over 2}$ e sapendo che $f_{max}={1 \over 2T_s}$ (nel caso ottimo di un impulso $g(t)$ che va come una $sinc$) allora $R_s \le B$, quindi la banda utilizzata è doppia rispetto a quella in banda base (ce lo aspettavamo in quanto la copia a frequenze negative derivante dal processo di modulazione così fatto non ci serve ma occupa banda).

Per demodulare il segnale e riottenere dunque x(t) originale, utilizziamo un demodulatore in ricezione che moltiplica di nuovo per un coseno alla stessa frequenza portante e un filtro passa-basso per tagliare fuori le alte frequenze.

$\dot x(t)=2z(t)cos(2 \pi f_0 t)=2x(t)cos^2(2 \pi f_0t)=2x(t)[{1 \over 2} + {1 \over 2}cos(4 \pi f_0 t)]$

$\dot x(t)=x(t)+x(t)cos(4 \pi f_0 t)$

$\dot X(f) = {X(f-2f_0) \over 2} +  {X(f+2f_0) \over 2}$

Usando infine un filtro passa-basso ideale $H(f)$ otteniamo il segnale originale:

$X(f)=\dot X(f)H(f)$ → $F^{-1}$ → $x(t)$

### Tecnica di trasmissione QAM (Quadratur Amplitude Modulation) o IQ

Una tecnica di trasmissione in un canale con una portante $f_0≠0$ più efficiente è detta QAM o IQ.

Dato un segnale x(t) da trasmettere lo si modula in fase e in quadratura, moltiplicandolo per un coseno e per un seno e poi sommando le due componenti:

$z(t)=x_1(t)cos(2 \pi f_0 t) + x_2(t)sin(2 \pi f_0 t)$

In ricezione si demodula il segnale in fase e poi in quadratura ottenendo di nuovo il segnale di partenza:

1. $2z(t)cos(2 \pi f_0 t)=x_1(t)+x_1(t)cos(4 \pi f_0 t)+x_2(t)sin(4 \pi f_0 t)$
    
    applicando un filtro ideale otteniamo $x_1(t)$
    
2. $2z(t)sin(2 \pi f_0 t)=x_1(t)sin(4 \pi f_0 t)+x_2(t)-x_2(t)cos(4 \pi f_0 t)$
    
    applicando un filtro ideale otteniamo $x_2(t)$
    

Al termine del processo di demodulazione abbiamo riottenuto $x(t)=x_1(t)+x_2(t)$

Utilizzando questa tecnica $R_b=R_slog_2M \le Blog_2M$, che nel caso peggiore corrisponde al valore che otteniamo usando la tecnica AM.

### Costellazioni di simboli

### Tecnica di trasmissione M-QAM

Avendo una sequenza numerica s[n] da trasmettere possiamo utilizzare la tecnica di trasmissione QAM nel modo descritto di seguito.

Data la sequenza numerica, possiamo rappresentare il simbolo $c_m$ come un punto sul piano cartesiano complesso avente coordinate $(a_m, b_m)$:

$s[n]=c_mg(t-nT_s)=a_mg(t-nT_s)+b_mg(t-nT_s)$

Ora possiamo applicare la modulazione sulle ordinate (parte immaginaria) e sulle ascisse (parte reale), ricordando che $Re\{e^{-i2 \pi f_0 t}\}=cos(2 \pi f_0 t)$ e  $Im\{e^{-i2 \pi f_0 t}\}=sin(2 \pi f_0 t)$ ottenendo:

$z(t)=a_mg(t-nT_s)cos(2 \pi f_0 t)+b_mg(t-nT_s)sin(2 \pi f_0 t)$

Questo significa che per trasmettere una sequenza numerica i cui simboli sono rappresentati da una costellazione M-aria è sufficiente trasmettere sulla portante in fase e su quella in quadratura le coordinate cartesiane di ciascun simbolo.

In ricezione non faremo altro che effettuare il procedimento inverso come visto nel caso base di applicazione della tecnica QAM.

Possiamo anche calcolare l’energia di simbolo $E_s=\int|Z(f)|^2df$

$Z(f)={1 \over 2}(a_m-ib_m)G(f-f_0)+{1 \over 2}(a_m+ib_m)G(f+f_0)$

$|Z(f)|^2={1 \over 4}(a_m^2+b_m^2)|G(f-f_0)|^2+{1 \over 4}(a_m^2+b_m^2)|G(f+f_0)|^2$

*NB: il doppio prodotto è nullo perchè $G(f-f_0)$ non si sovrappone con* $G(f+f_0)$

Perciò in conclusione l’energia di simbolo $E_s=\int |Z(f)|^2={1 \over 2}(a_m^2+b_m^2)E_g$

### Tecnica di trasmissione PSK (Phase Shift Keying)

Con M-PSK si indica una tecnica di trasmissione simile a quella M-QAM, ma in questo caso la modulazione in fase e quadratura comporta una costellazione distribuita su una circonferenza di raggio A con M simboli equi spaziati tra loro.

Al termine della modulazione il segnale $z(t)$ è così composto:

$z(t)=Acos(2 \pi f_0 t + \phi_m)=Acos(\phi_m)cos(2 \pi f_0 t)-Asin(\phi_m)sin(2 \pi f_0 t)$

Perciò le coordinate di $c_m$ sono ancora $(a_m, b_m)$, ma stavolta:

$a_m=Acos(\phi_m)$

$b_m=Asin(\phi_m)$

con  $\phi_m = {2 \pi \over M}$

- trasforma il segnale numerico precedentemente ottenuto tramite codifiche in un segnale analogico trasmissibile sul canale fisico.
- **trasmettitore:** amplifica e invia il segnale nel canale
    
    [Canale:]### Capacità di canale [CAPITOLO 10]

### Secondo teorema di Shannon

Dato un canale con una banda B e un certo rumore, questo teorema consente di stabilire il **limite teorico della cadenza di bit che è possibile trasmettere senza commettere errori**:

$C=Blog_2(1+{P_s \over P_n})=Blog_2(1+SNR)$

[$P_s$  è la potenza del segnale e $P_n$  è la potenza del rumore]

Questo risultato teorico non ci dice quale codifica consente di raggiungere questo valore limite, però ci fornisce alcune considerazioni importanti.

Sapendo che in un canale in banda base $R_s ≤ 2B$ e quindi $R_b ≤ 2Blog_2M$, se confrontiamo queste due espressioni otteniamo il **numero massimo $M$ di simboli di cui deve essere composto il mio alfabeto affinché non commetta errori**:

$2Blog_2M=Blog_2(1+SNR)$

$M=\sqrt{1+SNR}$

E’ possibile graficare il limite di Shannon riscrivendo la formula della capacità di canale, sapendo che $P_s = E_bC$ e $P_n=N_0B$:

${C \over B}=log_2(1 + {E_bC \over N_0B})$

Da cui otteniamo il minimo valore del rapporto $E_b \over N_0$ necessario affinché la trasmissione sia priva di errori:

${E_b \over N_0}={2^{C \over B} - 1 \over {C \over B}}$

Se ${C \over B} → 0$ allora ${E_b \over N_0} → log_2e=-1.6dB$

Vediamo anche due approssimazioni che consentono di utilizzare delle formule operative nel calcolo della capacità di canale, partendo dal grafico della capacità in funzione della banda:

1. valore limite con banda illimitata o limite di potenza limitata
    
    se $B→ \infty$ allora C → $1.44 \cdot B \cdot SNR$
    
2. valore limite con potenza illimitata o limite di banda limitata
    
    se ${P_s\over N_0}>>1$ allora
    
- **canale**: connessione fisica tra sorgente e destinatario, può essere interpretato come un filtro $H(f)$ passa-basso o passa-alto. Comporta la generazione di rumore.
- **ricevitore:** amplifica il segnale in uscita dal canale
- **demodulatore:** trasforma il segnale analogico ottenuto dal canale in un segnale numerico codificato
- decodifica di canale
- decodifica di sorgente
- **destinatario**: riceve il segnale