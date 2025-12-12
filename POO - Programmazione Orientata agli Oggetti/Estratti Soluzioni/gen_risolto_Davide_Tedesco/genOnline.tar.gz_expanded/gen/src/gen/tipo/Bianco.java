package gen.tipo;


import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_BIANCO;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gen.sim.Ambiente;

public class Bianco extends Animale{
	
	static final private Image IMMAGINE_BIANCA = leggiImmagineOggetto(RISORSA_IMMAGINE_BIANCO);

	static private int progId;
	
	public Bianco(Ambiente ambiente) {		
		super(ambiente, progId++);
	}
	
	public Bianco creaClone() {
		return new Bianco(this.getAmbiente());
	}
	
	protected Animale decidiProssimoObiettivo() {
		/* scegli un obiettivo casualmente */
		// Sugg.: al momento sono tutti della stessa specie, ma dopo DOMANDA 2bcd e' ancora vero? */
		final List<Animale> all = this.getAmbiente().getAllAnimali();
		
		List<Animale> possibili = new ArrayList<Animale>();
//		
//		for(Animale a : all) {
//			if(a.getClass()==this.getClass())
//				possibili.add(a);
//		}
		
		for(Animale a : all) {
			if(a.getClass().equals(this.getClass()))
				possibili.add(a);
		}
		
		Collections.shuffle(possibili);
		return possibili.get(0);
	}


	public Image getImmagine() {
		return IMMAGINE_BIANCA;
	}

	@Override
	public String toString() {
		return Bianco.class.getSimpleName()+getId() + ":"+getGenere().name().charAt(0)+" "+getEta();
	}

}
