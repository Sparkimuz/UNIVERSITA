package car.sim;

import car.auto.Bianca;

/**
 * Modella un percorso da un'origine ad una destinazione,
 * entrambe modellate da un oggetto {@link Coordinate} da parte di
 * una generica auto, ad es. ma non solo di tipo {@link Bianca}
 */
public class Tragitto {

	/* DA CAMBIARE VEDI DOMANDA 2 */
	private Bianca auto;
	
	private Coordinate origine;

	private Coordinate destinazione;
	
	public Tragitto(Bianca auto, Coordinate origine, Coordinate destinazione) {
		this.auto = auto;
		this.origine = origine;
		this.destinazione = destinazione;
	}

	public Bianca getAuto() {
		return this.auto;
	}

	public Coordinate getOrigine() {
		return this.origine;
	}

	public Coordinate getDestinazione() {
		return this.destinazione;
	}
	
	@Override
	public String toString() {
		return this.getOrigine()+"->"+this.getDestinazione();
	}

}
