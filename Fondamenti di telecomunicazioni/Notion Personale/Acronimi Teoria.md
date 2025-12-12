$C$ = Capacità di canale simboli/s

$B$ = Banda

$E_b$ = Energia di un bit

$N_o$= Energia rumore bianco? 

$R_s$= Velocità di simbolo(Baud), numero di simboli inviati al secondo

$R_b$=Velocità di bit (bit al secondo)

$Bitrate = k(bit)*R_s(Baudfrequenza di simbolo f_s)$

$BER$= Probabilità di errore del simbolo $\frac12erfc(\frac{d}{2\sqrt{2}\sigma_w})=Q(\frac{d}{2\sigma_w})$ con $d(soglia)=c_2-c_1$ se il $BER = 10^{-9}$ il sistema si dice error-free

$P_x=E_b·C$

$P_n={N_0}{B}$

$M = totale\hspace{1mm}simboli<= \sqrt{1+SNR}$ per evitare errori 

$SNR=\frac{P_x}{P_n}$

$\Delta=\frac{2V}{M}$ intervallo di quantizzazione

$P_{eq}=V^2/3M\hspace{1mm}perché\hspace{1mm}P_{eq}=\Delta^2/12\hspace{1mm}e\hspace{1mm}\Delta=2V/M$

$\frac{E_b}{N_0}=ln2$  Limite inferiore per l’energia di bit nel canale tramite secondo teo. di Shannon(da mettere nel grafico)