import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class SequenzaDiStringhe {

	public String[] sequenza;

	public SequenzaDiStringhe(int dimensione) {
		this.sequenza = new String[dimensione];
	}

	public void aggiungiStringa(String stringa, int posizione) {
		this.sequenza[posizione] = stringa;
	}

	public void aggiungiInCoda(String nuovaStringa) {
		if(sequenza[sequenza.length - 1] == null){
			sequenza[sequenza.length - 1] = nuovaStringa;
		}
	}


	public class SequenzaDiStringheTest {

		private SequenzaDiStringhe sequenza;

		@Before
		public void setUp() {
			// Inizializza un array di stringhe con 3 elementi
			sequenza = new SequenzaDiStringhe(3);
		}

		@Test
		public void testAggiungiStringa() {
			// Aggiungere una stringa in una posizione specifica
			sequenza.aggiungiStringa("ciao", 0);
			assertEquals("ciao", sequenza.sequenza[0]);

			sequenza.aggiungiStringa("mondo", 1);
			assertEquals("mondo", sequenza.sequenza[1]);

			// Verifica che l'elemento nella posizione 2 sia ancora null
			assertNull(sequenza.sequenza[2]);
		}

		@Test
		public void testAggiungiInCoda() {
			// Verifica l'aggiunta in coda
			sequenza.aggiungiStringa("ciao", 0);
			sequenza.aggiungiStringa("mondo", 1);

			// Il terzo elemento dovrebbe essere aggiunto in coda (indice 2)
			sequenza.aggiungiInCoda("fine");
			assertEquals("fine", sequenza.sequenza[2]);

			// Prova ad aggiungere in coda di nuovo (dovrebbe ignorare il secondo tentativo)
			sequenza.aggiungiInCoda("nuovo");
			assertEquals("fn", sequenza.sequenza[2]);
		}

		@Test
		public void testAggiungiInCodaArrayPieno() {
			// Aggiungiamo elementi in tutte le posizioni
			sequenza.aggiungiStringa("uno", 0);
			sequenza.aggiungiStringa("due", 1);
			sequenza.aggiungiStringa("tre", 2);

			// Proviamo ad aggiungere una stringa in coda con l'array pieno
			sequenza.aggiungiInCoda("quattro");

			// L'ultimo elemento dovrebbe rimanere invariato
			assertEquals("tre", sequenza.sequenza[2]);
		}
	}
}
