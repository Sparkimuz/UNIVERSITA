package car.stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalcolatoreMaxParallelo implements CalcolatoreMax {

	@Override
	public int max(final int[][] m) {
		// DA COMPLETARE 
		// (SOLO PER STUDENTI CHE SOSTENGONO ESAME DA 9 CFU)
		// VEDI DOMANDA 6
		//numero thread disponibili per la JVM
		int n_thread = Runtime.getRuntime().availableProcessors();	
		
		//lista di thread, essa e' un array perche' sappiamo il numero
		List<Thread> threads = new ArrayList<>(n_thread);
		
		//lista per salvare i massimi relativi
		final Integer[] maxRelativi = new Integer[n_thread];

		//capiamo quanto deve essere grande ogni fetta della matrice
		int dimensioneFetta = m.length/n_thread;
		
		//matrice e'  numero dispari, do0bbi8amo avere anche il resto
		int resto = m.length%n_thread;
		
		int inizioFetta = 0;

		//ciclo per assegnare ai thread
		for(int i=0; i<n_thread; i++) {
			//variabili d'appoggio finali per usarle nei thread
			int fineFetta =inizioFetta+dimensioneFetta;
			final int indice = i;
			final int inizio = inizioFetta;
			
			//distribuisco il resto una colonna alla volta
			if(i<resto) {
				fineFetta++;
			}
			
			final int fine = fineFetta;
			
			threads.add(new Thread(new Runnable() {

				@Override
				public void run() {
					maxRelativi[indice]=new CalcolatoreMaxSeriale().max(m,inizio,fine );		
				}
			}));
			inizioFetta = fineFetta;
		}
		for(int j=0; j<n_thread; j++) {
			//attendiamo la fine dell'esecuzione di ogni thread
			try {
				threads.get(j).join();
			} catch (InterruptedException e) {
				throw new RuntimeException();
			}
		}

		//passiamo da array a lista e poi ne cerchiamo il massimo
		return Collections.max(Arrays.asList(maxRelativi));
	}

}
