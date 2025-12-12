Fare la trasformata di Fourier del segnale(sostituire t con n e dividerlo con il periodo) e poi moltiplicarla per il reciproco del periodo. SI PUO’ FARE SOLAMENTE SE LA TRASFORMATA RISULTANTE NON SONO DELTA DI DIRAC, SE SONO DELTA DI DIRAC ALLORA:

- FINESTRARE PRIMA CON UNA RECT DI PERIODO T (NON CONVIENE)
- I COEFFICIENTI SONO EQUIVALENTI AI COEFFICIENTI CHE SONO MOLTIPLICATI PER LE DELTA PRESENTI NELLA TRASFORMATA, C0, C1, C-1 - COME SI PUO’ VEDERE ALL’INTERNO DI QUESTA FORMULA

X(f) = SUM(n) cn*delta(f-n/T)

Formula Standard vs. Metodo della Trasformata
- Formula di Definizione (sempre valida):
    cn = 1/T INT(x(t)e^-j2pin/Tt dt)
    Questo integrale è la definizione formale e funziona sempre per qualsiasi segnale periodico, ma può essere lungo e complesso da calcolare
- Metodo della Trasformata(scorciatoia):
    cn = (1/T)*G(n/T)
    Questa è una scorciatoia che evita l'integrazione, ma richiede di conoscere(o saper calcolare) la trasformata di Fourier G(f) dell'impulso generatore.

1/T Nella formula dei coefficienti dipende dalla finestra che utilizziamo

n/T Nella formula dei coefficienti dipende dalla funzione originale che abbiamo poi trasformato, quindi con per esempio cos(2*pi*t/2T + 2omega) allora sarebbe diventato n/2T

IN REALTA’ DIPENDONO ENTRAMBI DAL PERIODO INIZIALE (LO DICE LA PROF DI SOLITO)