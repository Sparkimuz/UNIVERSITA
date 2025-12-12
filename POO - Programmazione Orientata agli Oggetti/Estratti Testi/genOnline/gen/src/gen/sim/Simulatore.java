package gen.sim;


import static gen.sim.CostantiSimulazione.*;
import static gen.sim.GeneratoreCasuale.siVerificaEventoDiProbabilita;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.SwingUtilities;

import gen.gui.GUI;
import gen.stats.Statistiche;
import gen.tipo.Bianco;

public class Simulatore {

	final private Ambiente ambiente;
	
	final private Set<Scontro> scontri;
	
	final private Set<Incontro> incontri;

	private int passo;

	private GUI gui;
	
	volatile boolean fineTerminazioneRichiesta;
	
	public Simulatore() {
		this.ambiente = new Ambiente();
		this.passo = 0;
		creaPopolazione();
		this.scontri = new LinkedHashSet<>();
		this.incontri = new LinkedHashSet<>();
		this.fineTerminazioneRichiesta = false;
	}

	private void creaPopolazione() {
		/* DA AGGIORNARE (VEDI DOMANDA 2bcd) */
		for(int i=0; i<NUMERO_INIZIALE_PER_TIPOLOGIA; i++) {
			this.ambiente.add(creaBianco());
		}
	}
	
	public Bianco creaBianco() {
		return new Bianco(this.getAmbiente());
	}


	public List<Bianco> getAnimali() {
		return this.ambiente.getAllAnimali();
	}

	public void setGUI(GUI gui) {
		this.gui = gui;
	}

	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public int getPasso() {
		return this.passo;
	}

	public void simula() {

		for(this.passo=0; this.passo<DURATA_SIMULAZIONE; this.passo++) {

			eseguiPassoDellaSimulazione();

			aggiornaStatistiche();

			pausa();
			
			if (fineSimulazioneRichiesta()) {
				System.out.println("Simulazione interrotta al passo "+passo);
				System.out.println();
				break;
			}
		}
		
		/* VEDI DOMANDA 5 */
		
		System.out.println("Simulazione terminata.");
		
		/**
		 * Termina la simulazione corrente stampando le statistiche finali
		 */
		new Statistiche().stampaFinale(this);

		terminaSimulazioneBrutalmente();
	}

	private boolean fineSimulazioneRichiesta() {
		return this.fineTerminazioneRichiesta;
	}

	private void eseguiPassoDellaSimulazione() {
		final List<Bianco> tutti = new ArrayList<>(this.ambiente.getAllAnimali());
		Collections.shuffle(tutti);
		/* DA CAMBIARE ( VEDI DOMANDA 2 )*/
		for(Bianco animale : tutti) {
			animale.simula(this.getPasso());
			
			final Set<Bianco> stessaPosizione = this.getAmbiente().getAnimali(animale.getPosizione());
			
			if (stessaPosizione.size()>1) { /* scontro od incontro? */
				if (isScontroPossibile(stessaPosizione)) {
					// diverse specie: questo e' uno scontro
					final Scontro scontro = new Scontro(stessaPosizione);
					this.add(scontro);
					this.ambiente.rimuoviAnimali(stessaPosizione);
					this.ambiente.add(scontro.getVincente());			
				} else if (isRiproduzionePossibile(animale,stessaPosizione)) {
					//  tutti della stessa specie: questo e' un incontro
					final Incontro incontro = new Incontro(stessaPosizione);
					final Bianco figlio = incontro.figlio();
					this.getAmbiente().add(figlio);
					this.add(incontro);
				} 
			}

			if (animale.getEta()>=MAX_ETA_RIPRODUZIONE && GeneratoreCasuale.siVerificaEventoDiProbabilita(PROBABILITA_MORTE))
				this.getAmbiente().rimuoviAnimale(animale);
		}
	}
	
	public boolean isScontroPossibile(Set<Bianco> animali) {
		return getNumeroTipologie(animali)>1 && siVerificaEventoDiProbabilita(PROBABILITA_SCONTRO);	
	}

	private int getNumeroTipologie(Set<Bianco> animali) {
		final Set<Class<? extends Bianco>> tipi = new HashSet<>();
		for(Bianco a : animali)
			tipi.add(a.getClass());
		return tipi.size();
	}


	private boolean isRiproduzionePossibile(Bianco animale, Set<Bianco> animali) {
		if (animali.size()!=2 || getNumeroTipologie(animali)!=1) return false;
		final Iterator<Bianco> it = animali.iterator();
		final Bianco a1 = it.next(); // primo 
		final Bianco a2 = it.next(); // secondo
		if (a1.getGenere()==a2.getGenere()) return false;
		return ( MIN_ETA_RIPRODUZIONE<=animale.getEta() && animale.getEta()<=MAX_ETA_RIPRODUZIONE && 
				 siVerificaEventoDiProbabilita(PROBABILITA_RIPRODUZIONE) );
	}

	public void add(Scontro s) {
		this.scontri.add(s);
	}
	
	public Set<Scontro> getScontri() {
		return this.scontri;
	}

	public void add(Incontro i) {
		this.incontri.add(i);
	}
	
	public Set<Incontro> getIncontri() {
		return this.incontri;
	}


	private void aggiornaStatistiche() {
		/* stampa passo simulazione */
		this.gui.riportaNelTitolo(this.passo, this);
	}

	private void pausa() {
		try {
			this.updateGui();
			Thread.sleep(RITMO);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void updateGui() {
		SwingUtilities.invokeLater( new Runnable() {			
			@Override
			public void run() {
				Simulatore.this.gui.repaint();
			}
		});
	}

	/**
	 * Termina la simulazione corrente arrestando l'intera JVM!!!
	 */
	public void terminaSimulazioneBrutalmente() {
		System.exit(-1);
	}

	public void richiediTerminazione() {
		this.fineTerminazioneRichiesta = true;
	}
	
}
