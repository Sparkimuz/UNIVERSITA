package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_VERDE;

import java.awt.Image;
import java.util.Random;

import ama.Citta;
import ama.Posizione;

public class Chase {

	static private int progId=0;
	
	private int id;

	final private Random rnd;
	
	private Citta citta;
	
	public Chase(Citta citta) {
		this.id = progId++;
		this.citta = citta;
		this.rnd = new Random();
	}

	public int getId() {
		return this.id;
	}
	
	public Citta getCitta() {
		return this.citta;
	}
	
	public Posizione decidiDirezione(Posizione corrente) {
		final Posizione posizioneRifiutoNelleVicinanze = 
				this.getCitta().getRifiutoVicinoA(corrente);
		if (posizioneRifiutoNelleVicinanze==null) 
			return corrente.traslazioneUnitaria(deltaCasuale(),deltaCasuale());
		else return posizioneRifiutoNelleVicinanze;
	}
	
	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */
	private int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}

	public Image getImmagine() {
		return IMMAGINE_CAMION_VERDE;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}

}
