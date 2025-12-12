Le domande "fisse" o molto frequenti sembrano concentrarsi su **Shannon (Capacità e limiti)**, **Quantizzazione (SNR e dimensionamento)** e **Filtro Adattato**. Il professore tende a collegare teoria ed esercizi (es. chiedere il grafico della capacità durante l'orale partendo da un esercizio dello scritto).

## 1. Domande tratte dalle Immagini WhatsApp (Storico Esami)

Queste sono le domande specifiche riportate dagli studenti, quindi ad **altissima probabilità**:

- **Teoria dell'Informazione e Capacità:**
    - **Secondo Teorema di Shannon:** Enunciato e significato fisico.
    - **Grafico della Capacità di Canale:** Disegnare $C/B$ in funzione di $E_b/N_0$. Chiede spesso di individuare il limite di Shannon ($-1.6$ dB).
    - **Trovare M massimo:** Come calcolare il numero massimo di simboli $M$ in funzione del SNR per non avere errori (formula $M \le \sqrt{1+SNR}$).
    - **Autoinformazione:** Definizione e proprietà.
- **Codifica di Sorgente e Canale:**
    - **Codifica di Huffman:** Come funziona l'algoritmo (orale classico).
    - **SNR di Quantizzazione:** Formule e relazione $6k$ dB (ogni bit aggiuntivo guadagna 6 dB).
- **Trasmissione e Modulazione:**
    - **Schema a blocchi:** Disegnare la catena di trasmissione (spesso chiesto allo scritto o come apertura all'orale).
    - **PCM (Pulse Code Modulation):** Differenza con PAM e applicazione al segnale telefonico.
    - **Filtro Adattato:** A cosa serve, SNR in uscita e probabilità d'errore.
    - **Modulazione IQ/QAM:** Schema del modulatore/demodulatore e costellazioni.
    - **ISI e Criterio di Nyquist:** Condizioni per evitare l'interferenza intersimbolica.

## 2. Previsione Domande Scritto (Esercizi e Grafici)

In base agli appunti e ai messaggi, lo scritto si concentra su calcoli dimensionali e grafici.

1. **Dimensionamento del sistema:**
    - Dato un segnale (es. voce o audio), calcolare frequenza di campionamento, livelli di quantizzazione $M$ per un certo SNR target, e il *bit-rate* risultante $R_b$.
    - *Formula chiave:* $SNR_{dB} \approx 6k + 1.8$ (o semplificato $6k$).
2. **Grafici di Capacità:**
    - Ti verrà chiesto di disegnare il grafico della capacità spettrale $\eta = C/B$ in funzione di $SNR$ o $E_b/N_0$.
    - Devi saper indicare le zone di funzionamento "limited by power" (dove il grafico è lineare) e "limited by bandwidth" (dove il grafico è logaritmico).
3. **Calcolo del BER (Bit Error Rate):**
    - Esercizi sull'uso della funzione Q (o erfc) per calcolare la probabilità di errore in sistemi PAM o QAM in presenza di rumore gaussiano.

## 3. Previsione Domande Orali (Teoriche)

1. **Teorema del Campionamento:** Enunciato, aliasing e ricostruzione ideale (filtro passa-basso/interpolazione con sinc). È una domanda "filtro": se non la sai, spesso l'esame finisce.
2. **Quantizzazione:**
    - Descrivere l'errore di quantizzazione (distribuzione uniforme tra $-\Delta/2$ e $+\Delta/2$).
    - Dimostrazione della potenza dell'errore $P_e = \Delta^2 / 12$.
3. **Filtro Adattato:**
    - Dimostrare che la risposta impulsiva ottima è $h(t) = g(T-t)$ (il ribaltato dell'impulso trasmesso) per massimizzare il SNR.
4. **Rumore e Variabili Aleatorie:**
    - Densità di probabilità del rumore (Gaussiana).
    - Probabilità di errore come area sotto la coda della Gaussiana (Q-function).