## 1. Teoria dell'Informazione e Capacità di Canale

*Per iniziare il discorso:* "Partiamo definendo i limiti teorici della trasmissione. Shannon ci dice quanta informazione possiamo trasmettere al massimo su un canale affetto da rumore senza commettere errori."

- **$C = B \log_2(1 + SNR)$**
    - *Cos'è:* **Capacità di canale** (espressa in **bit/s**, non simboli/s, attenzione!). È il limite superiore teorico della velocità di trasmissione senza errori.
    - *Nota:* Se ti chiedono la capacità in *simboli/s*, ti riferisci solitamente alla limitazione di banda di Nyquist ($2B$), ma la formula di Shannon dà il risultato in bit/s.
- **$SNR = \frac{P_x}{P_n}$**
    - *Cos'è:* Rapporto segnale-rumore (Signal-to-Noise Ratio). Indica quanto il segnale è più forte del rumore.
- **$P_n = N_0 B$**
    - *Cos'è:* Potenza del rumore termico.
    - *Chiarimento:* $N_0$ non è proprio l'energia, ma la **Densità Spettrale di Potenza** del rumore (dimensionalmente è un'energia, Watt/Hz = Joule, ma concettualmente è potenza distribuita sulle frequenze).
- **$\frac{E_b}{N_0} > \ln 2 \approx -1.6 \text{ dB}$**
    - *Cos'è:* **Limite di Shannon**. È il valore minimo di $E_b/N_0$ sotto il quale non è possibile trasmettere senza errori, anche con banda infinita. Fondamentale per il grafico della capacità.
- **$M \le \sqrt{1+SNR}$** (Derivata dal confronto tra Nyquist e Shannon)
    - *Cos'è:* Numero massimo di simboli (o livelli) distinguibili dato un certo SNR.
    - *Spiegazione:* Se aumenti troppo $M$ (i livelli) senza aumentare la potenza, i livelli diventano troppo vicini e il rumore li fa confondere.

## 2. Parametri della Trasmissione (Velocità e Banda)

*Per collegarsi:* "Una volta definito il limite teorico, dobbiamo capire a che velocità stiamo effettivamente trasmettendo i nostri simboli e bit."

- **$R_s = \frac{1}{T_s}$** (Baud Rate)
    - *Cos'è:* **Velocità di simbolo**. Numero di simboli trasmessi al secondo.
    - *Vincolo di Nyquist:* $R_s \le 2B$ (per trasmissioni in banda base senza ISI).
- **$R_b = k \cdot R_s$**
    - *Cos'è:* **Bitrate** (bit/s).
    - $k = \log_2 M$: Numero di bit per simbolo.
- **$P_x = E_b \cdot R_b$**
    - *Correzione:* Tu avevi scritto $P_x = E_b \cdot C$. Quella è valida solo se trasmetti *esattamente* alla capacità massima. La formula generale è che la Potenza del segnale è l'Energia per bit moltiplicata per i bit al secondo ($R_b$).
- **Relazione fondamentale SNR - Eb/N0:**
    - $SNR = \frac{E_b}{N_0} \cdot \frac{R_b}{B}$ (Molto utile per convertire gli esercizi e i grafici).

## 3. Probabilità di Errore (BER)

*Per collegarsi:* "Tuttavia, nel mondo reale il rumore c'è sempre. Dobbiamo quantificare quanto spesso sbagliamo a interpretare un simbolo, usando il BER."

- **$d = c_2 - c_1$**
    - *Cos'è:* Distanza tra due simboli adiacenti (la "soglia" decisionale sta nel mezzo, a $d/2$).
- **$BER = Q\left(\frac{d}{2\sigma_w}\right) = \frac{1}{2}\text{erfc}\left(\frac{d}{2\sqrt{2}\sigma_w}\right)$**
    - *Cos'è:* Probabilità di errore per un sistema binario o tra simboli adiacenti.
    - *Nota:* $\sigma_w$ è la deviazione standard del rumore (radice della potenza del rumore $P_n$ o $N_0 B$).
    - *Error-free:* Convenzionalmente si dice "error-free" se $BER \le 10^{-9}$.

---

## 4. Quantizzazione e PCM

*Per collegarsi:* "Se il segnale di partenza è analogico, prima di trasmetterlo devo digitalizzarlo tramite campionamento e quantizzazione, introducendo però un errore di approssimazione."

- **$\Delta = \frac{2V}{M}$**
    - *Cos'è:* Passo (intervallo) di quantizzazione. $2V$ è l'escursione picco-picco del segnale (da $-V$ a $+V$).
- **$P_{eq} = \frac{\Delta^2}{12} = \frac{V^2}{3M^2}$**
    - *Correzione Importante:* Nella tua lista mancava il quadrato su $M$. La potenza dell'errore di quantizzazione scende col *quadrato* del numero di livelli.
    - *Derivazione:* Sostituisci $\Delta = 2V/M$ in $\Delta^2/12 \rightarrow (4V^2/M^2)/12 = V^2/3M^2$.
- **$SNR_q \approx 6k$ dB**
    - *Formula empirica:* Il rapporto segnale rumore di quantizzazione aumenta di circa 6 dB per ogni bit aggiunto ($k$). Utile per controlli rapidi (es. 8 bit $\approx$ 48 dB).

---

## 5. Filtro Adattato (Matched Filter)

*Per collegarsi:* "Per minimizzare la probabilità di errore in ricezione, non usiamo un filtro qualsiasi, ma uno progettato *ad hoc* per massimizzare il rapporto segnale-rumore (SNR) nell'istante di campionamento: il filtro adattato."

- **$h(t) = s(T_s - t) + k$**
    - *Cos'è:* Risposta impulsiva del filtro adattato. È il segnale trasmesso $s(t)$ ribaltato nel tempo e traslato di un periodo di simbolo $T_s$.
    - *Significato:* Il filtro "assomiglia" esattamente alla forma d'onda del simbolo che stiamo cercando.
- **$SNR_{max} = \frac{2E_s}{N_0}$** (oppure $\frac{E_s}{N_0/2}$ in alcune notazioni)
    - *Cos'è:* Il massimo rapporto segnale-rumore ottenibile in uscita al filtro adattato.
    - *Nota fondamentale:* Questo SNR **dipende solo dall'energia del simbolo ($E_s$) e dalla potenza del rumore ($N_0$)**, NON dalla forma dell'impulso! (Che sia rettangolare, triangolare o sinc, se l'energia è la stessa, l'SNR massimo è identico).
- **$y(T_s) = \int_{-\infty}^{+\infty} r(t) s(t) dt$** (Operazione di Correlazione)
    - *Cos'è:* L'uscita del filtro adattato all'istante di campionamento $T_s$.
    - *Spiegazione:* Il filtro adattato esegue matematicamente una **correlazione** (o prodotto scalare) tra il segnale ricevuto $r(t)$ e la replica del segnale atteso $s(t)$. Se sono simili, l'uscita è massima; se c'è solo rumore, l'uscita è bassa.

## Formule aggiuntive consigliate (da tenere a mente)

1. **Campionamento:** $f_c \ge 2 f_{max}$ (Teorema di Nyquist-Shannon sul campionamento, diverso da quello della capacità!).
2. **Entropia (Huffman):** $H = -\sum p_i \log_2 p_i$ (limite inferiore per la compressione dati).