package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_GIALLO;

import java.awt.Image;
import java.util.Random;

import ama.Posizione;

public class Brown {

	static private int progId=0;	

	private int id;
	
	final private Random rnd;

	public Brown() {
		this.id = progId++;
		this.rnd = new Random();
	}

	public int getId() {
		return this.id;
	}

	public Posizione decidiDirezione(Posizione p) {
		return p.traslazioneUnitaria(deltaCasuale(),deltaCasuale());
	}

	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */
	private int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}
	
	public Image getImmagine() {
		return IMMAGINE_CAMION_GIALLO;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}

}
