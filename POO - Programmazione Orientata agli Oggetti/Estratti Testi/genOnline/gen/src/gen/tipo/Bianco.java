package gen.tipo;


import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;
import static gen.sim.GeneratoreCasuale.generaNumeroSinoA;
import static gen.sim.GeneratoreCasuale.posizioneCasuale;

import java.awt.Image;
import java.util.List;
import java.util.Set;

import gen.sim.Ambiente;
import gen.sim.Coordinate;
import gen.sim.Direzione;
import gen.sim.Genere;

public class Bianco {
	
	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);

	static private int progId;

	private Ambiente ambiente;

	private Coordinate posizione; // posizione corrente

	private Direzione direzione;  // direzione corrente
	
	private Bianco obiettivo;    // per un incontro (ora VEDI domanda 2a) od un incontro (poi, VEDI domanda 2bcd)
		
	private Genere genere;
	
	private int eta;
	
	private final int id;
	
	public Bianco(Ambiente ambiente) {		
		this.ambiente = ambiente;
		this.posizione = posizioneCasuale();
		this.eta = 0;
		this.obiettivo = null;
		this.direzione = null;
		this.id = progId++;
		this.genere = Genere.casuale();
	}
	
	public Ambiente getAmbiente() {
		return this.ambiente;
	}

	public void setPosizione(Coordinate nuova) {
		this.posizione = nuova;
	}

	public Coordinate getPosizione() {
		return this.posizione;
	}

	public Direzione getDirezione() {
		return this.direzione;
	}

	public void setDirezione(Direzione nuova) {
		this.direzione = nuova;
	}

	private void setObiettivo(Bianco animale) {
		this.obiettivo = animale;
	}
	
	public Bianco getObiettivo() {
		return this.obiettivo;
	}
	
	public int getEta() {
		return this.eta;
	}
	
	public Genere getGenere() {
		return this.genere;
	}

	public void simula(int passo) {
		this.eta++;

		/* target gia' deciso? */
		if (this.getObiettivo()==null || isObiettivoRaggiunto()) {
			this.setObiettivo(decidiProssimoObiettivo());
		}
		
		final Direzione versoObiettivo = direzionaVerso(this.getObiettivo().getPosizione());
		this.setDirezione(versoObiettivo);
		
		this.setPosizione(calcolaNuovaPosizione());
	}
	
	public Bianco creaClone() {
		return new Bianco(this.getAmbiente());
	}
	
	protected Bianco decidiProssimoObiettivo() {
		/* scegli un obiettivo casualmente */
		// Sugg.: al momento sono tutti della stessa specie, ma dopo DOMANDA 2bcd e' ancora vero? */
		final List<Bianco> all = this.getAmbiente().getAllAnimali();
		return all.get(generaNumeroSinoA(all.size()));
	}
	
	private boolean isObiettivoRaggiunto() {
		return this.getPosizione().equals(this.getObiettivo().getPosizione());
	}

	private Direzione direzionaVerso(Coordinate dest) {
		final Direzione verso = Direzione.verso(this.getPosizione(),dest);
		final Set<Direzione> possibili = getPossibiliDirezioni();
		if (possibili.contains(verso)) 
			return verso;
		else return Direzione.scegliAcasoTra(possibili);
	}

	private Coordinate calcolaNuovaPosizione() {
		return (this.getPosizione().trasla(this.getDirezione()));
	}

	private Set<Direzione> getPossibiliDirezioni() {
		return this.getAmbiente().getPossibiliDirezioni(this.getPosizione());
	}

	public Image getImmagine() {
		return IMMAGINE_BIANCA;
	}
	
	/**
	 * <B>DA CORREGGERE (VEDI DOMANDA 2)</B> 
	 * @return un id progressivo (per tipologia) associato a
	 *         questo oggetto
	 */
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return Bianco.class.getSimpleName()+getId() + ":"+getGenere().name().charAt(0)+" "+getEta();
	}

}
