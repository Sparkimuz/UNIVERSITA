Prima di tutto riportare il segnale iniziale alle forme base (sin(x), cos(x), sinc(x), rect(x), oppure qualsiasi somma di questi segnali, ma non la moltiplicazione, per esempio sin(x)*cos(x) non va bene mentre sin(x)+cos(x) va bene come segnale per rilevare la frequenza max

QUANDO CI SONO DELLE DELTA CHE SI RIPETONO, CONSIDERARE IN F=0 COME ESCE, E CHIARAMENTE QUELLO CHE ESCE SI RIPETE PER OGNI INTERVALLO

Varie casistiche esercizi dalla più comune alla meno comune:

- Procedimento da una funzione tra queste(sinc, cos, sin, sinc^2), fare trasformata e si ottiene una funzione nel tempo semplice(rect, delta, tri), disegnare e passare nel filtro
- Procedimento da una funzione complicata tra queste(cos^2, sin^2), semplificare tramite formule trigonometriche e tornare su funzioni semplici conosciute e poi fare la trasformata
- Se ti da x(t)=tri o rect allora applicare direttamente la definizione del campionamento, x(nT)*delta(t-nT) perché in questo modo ottieni delle delta nei punti in cui la funzione è definita. easy
    - Da qui potrebbe uscire una convoluzione che da una funzione sconosciuta e bisogna analizzare gli intervalli
    - Se non si possono semplificare le funzioni complicate allora applicare la definizione e fare caso ai valori che prendono le funzioni con i valori interi (…-2, -1, 0, 1, 2)

## Passo 1: Trova la frequenza massima del segnale (f_max)

Il primo passo è sempre identificare la frequenza più alta presente nel segnale analogico *x(t)*. Questa è la "velocità" con cui il segnale oscilla.

- **Caso 1: Segnali sinusoidali (coseno o seno)**
    
    Il segnale è nella forma *A cos(ωt + φ)* o *A sin(ωt + φ)*. La pulsazione è *ω* (il numero che moltiplica *t*). La frequenza *f* si calcola con la formula:
    
    *f = ω / 2π*
    
    Nel tuo esercizio: *x(t) = 5cos(200πt)*.
    
    La pulsazione *ω = 200π*.
    
    Quindi, la frequenza del segnale è:
    
    *f_max = 200π / 2π = 100 Hz*
    
- **Caso 2: Somma di più segnali sinusoidali**
    
    Se il segnale è una somma, ad esempio *x(t) = sin(100πt) + cos(250πt)*, calcola la frequenza di ogni componente e prendi la più alta. In questo caso, le frequenze sono 50 Hz e 125 Hz, quindi *f_max = 125 Hz*.
    
- **Caso 3: Segnali a banda limitata (es. sinc)**
    
    Se il segnale è definito dalla sua banda (es. "un segnale con banda B = 10 kHz"), allora *f_max = B*.
    

---

## Passo 2: Calcola la frequenza di Nyquist (f_c)

La frequenza di Nyquist (*f_c*) è la **frequenza minima** a cui devi campionare il segnale per non perdere informazioni. Il teorema del campionamento di Nyquist-Shannon dice che questa frequenza deve essere almeno il doppio della frequenza massima del segnale.

- **Formula:** *f_c = 2 ⋅ f_max*
    
    Nel tuo esercizio, con *f_max = 100 Hz*:
    
    *f_c = 2 ⋅ 100 Hz = 200 Hz*
    

Questo risponde alla **prima domanda** del tuo esercizio. La frequenza minima per evitare aliasing è 200 Hz.

---

## Passo 3: Verifica se c'è Aliasing

Ora confronta la frequenza di campionamento data dal problema (*f_s*) con la frequenza di Nyquist (*f_c*) che hai appena calcolato.

- **Se *f_s ≥ f_c*** → **NON c'è aliasing**. Il campionamento è corretto e il segnale originale può essere perfettamente ricostruito.
- **Se *f_s < f_c*** → **C'è aliasing**. Le repliche dello spettro si sovrappongono, corrompendo il segnale. L'informazione originale è persa.

Nel tuo esercizio, *f_s = 300 Hz*.

Poiché *300 Hz ≥ 200 Hz* (cioè *f_s ≥ f_c*), **non si verifica aliasing**.

Questo risponde alla **seconda domanda** del tuo esercizio.

---

## Passo 4: Disegna lo spettro del segnale originale X(f)

Lo spettro di frequenza *X(f)* mostra quali frequenze compongono il segnale. Per un coseno, lo spettro è molto semplice.

- **Formula (Trasformata di Fourier di un coseno):**
    
    Un segnale *A cos(2πf₀t)* ha una trasformata *X(f) = (A/2) [δ(f - f₀) + δ(f + f₀)]*.
    
    Questo significa che lo spettro è composto da due impulsi (linee verticali), uno a *+f₀* e uno a *-f₀*, entrambi di ampiezza *A/2*.
    
- **Nel tuo esercizio:**
    
    *x(t) = 5cos(200πt)*. Abbiamo *A = 5* e *f₀ = 100 Hz*.
    
    Lo spettro *X(f)* avrà:
    
    - Un impulso a **f = 100 Hz** con ampiezza **5/2 = 2.5**.
    - Un impulso a **f = -100 Hz** con ampiezza **5/2 = 2.5**.

Il disegno sarà semplicemente l'asse delle frequenze con due frecce a -100 e +100.

---

## Passo 5: Disegna lo spettro del segnale campionato X_c(f)

Il campionamento nel tempo causa una **ripetizione (o replicazione) periodica** dello spettro originale nel dominio della frequenza. Le repliche sono centrate a multipli interi della frequenza di campionamento *f_s*. QUANDO CI SONO DELLE DELTA CHE SI RIPETONO, CONSIDERARE IN F=0 COME ESCE, E CHIARAMENTE QUELLO CHE ESCE SI RIPETE PER OGNI INTERVALLO

- **Procedura per il disegno:**
    1. Disegna lo spettro originale *X(f)* centrato in 0 (come al Passo 4).
    2. Copia l'intero spettro *X(f)* e centrato su *f_s*, *f_s*, *2f_s*, *2f_s*, e così via.
- **Nel tuo esercizio:**
    
    *f_s = 300 Hz*. Lo spettro originale ha impulsi a ±100 Hz.
    
    1. **Replica a 0 Hz (l'originale):** Impulsi a **100 Hz** e **+100 Hz**.
    2. **Replica a +300 Hz:** Lo spettro originale (impulsi a ±100) viene traslato di +300. Gli impulsi appaiono a *300 - 100 = **200 Hz*** e *300 + 100 = **400 Hz***.
    3. **Replica a -300 Hz:** Lo spettro viene traslato di -300. Gli impulsi appaiono a *300 - 100 = **400 Hz*** e *300 + 100 = **200 Hz***.

Lo spettro finale *X_c(f)* mostrerà quindi una serie infinita di impulsi alle frequenze: ..., -400, -200, -100, 100, 200, 400, ... Hz. Le repliche sono ben separate, confermando visivamente l'assenza di aliasing.