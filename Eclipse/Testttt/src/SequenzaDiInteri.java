public class SequenzaDiInteri {
    private int[] sequenza;

    public SequenzaDiInteri(int numeroInteri) {
        this.sequenza = new int[numeroInteri];
    }

    public void aggiungiIntero(int intero, int indice) {
        this.sequenza[indice] = intero;
    }

    public int sommaPari() {
        int somma= 0;
        
        for(int i=0; i<sequenza.length; i++){
            if(i%2 == 0){
                somma = sequenza[i] + somma; 
            }
            
        }
        return somma;
    }
	public static class TestSequenzaDiInteri {
        public static void main(String[] args) {
            // Creazione di un'istanza della classe SequenzaDiInteri
            SequenzaDiInteri sequenza = new SequenzaDiInteri(5);  // Una sequenza di 5 interi

            // Aggiungere interi alla sequenza
            sequenza.aggiungiIntero(10, 0);  // Aggiunge 10 all'indice 0
            sequenza.aggiungiIntero(5, 1);   // Aggiunge 5 all'indice 1
            sequenza.aggiungiIntero(28, 2);  // Aggiunge 20 all'indice 2
            sequenza.aggiungiIntero(7, 3);   // Aggiunge 7 all'indice 3
            sequenza.aggiungiIntero(66, 4);  // Aggiunge 15 all'indice 4

            // Calcola la somma degli elementi agli indici pari
            int somma = sequenza.sommaPari();

            // Stampa il risultato
            System.out.println("La somma degli elementi agli indici pari è: " + somma);
        }
    }
}