package gen.tipo;

import static gen.gui.CostantiGUI.RISORSA_IMMAGINE_GIALLO;
import static gen.gui.LettoreImmagini.leggiImmagineOggetto;
import static gen.sim.GeneratoreCasuale.generaNumeroSinoA;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import gen.sim.Ambiente;
public class Giallo extends Animale {
	
	static final private Image IMMAGINE_GIALLA = leggiImmagineOggetto(RISORSA_IMMAGINE_GIALLO);

	static private int progId;

	public Giallo(Ambiente ambiente) {
		super(ambiente, progId++);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Animale creaClone() {
		return new Giallo(this.getAmbiente());
	}

	@Override
	Animale decidiProssimoObiettivo() throws IllegalArgumentException{
		final List<Animale> all = this.getAmbiente().getAllAnimali();
		List<Animale> possibili = new ArrayList<Animale>();

//		for(Animale a : all) {
//			if(a.getClass()!=this.getClass())
//				possibili.add(a);
//		}
		
		for(Animale a : all) {
		if(!a.getClass().equals(this.getClass()))
			possibili.add(a);
	}
	
		return possibili.get(generaNumeroSinoA(possibili.size()));
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_GIALLA;

	}
	
	@Override
	public String toString() {
		return Giallo.class.getSimpleName()+getId() + ":"+getGenere().name().charAt(0)+" "+getEta();
	}

}
