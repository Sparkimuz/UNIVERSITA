import java.util.HashMap;
import java.util.Map;

/*Scrivere il metodo getProdotto2quantita() della classe OperazioniProdotti. Tale metodo riceve in input due mappe. La prima mappa, cod2prod, associa un codice di tipo String ad un oggetto di tipo Prodotto. La seconda, cod2qta, associa un codice di tipo String ad una quantita' di tipo Integer.
Il metodo deve restituire una mappa che associa i prodotti della prima mappa alle quantita' della seconda mappa usando la corrispondenza fra codici (le chiavi delle mappe).
E' possibile che per alcuni prodotti non siano riportate le quantita'. In quel caso il prodotto non deve comparire nella mappa in output.
N.B. Non modificare la classe Prodotto.*/


class Prodotto {
    // NON MODIFICARE QUESTA CLASSE
    private String codice;
    private int peso;
    
    public Prodotto(String codice, int peso) {
        this.codice = codice;
        this.peso = peso;
    }

    public String getCodice() { return codice; }

    public int getPeso() { return peso; }
    
    @Override
    public int hashCode() { return this.codice.hashCode(); } // Il codice e' univoco
    
    public boolean equals(Object o) {
        Prodotto that = (Prodotto) o;
        return this.getCodice().equals(that.getCodice()); // Il codice e' univoco
    }
}
//INIZIA A MODIFICARE DA QUI...
class OperazioniProdotti{
	
	public Map<Prodotto, Integer> getProdotto2quantita(Map<String, Prodotto> cod2prod, Map<String, Integer> cod2qta){
		Map<Prodotto, Integer> prodotto2quantita = new HashMap<>();
		
		for(Map.Entry<String, Prodotto> entry : cod2prod.entrySet()) {
			String codice = entry.getKey();
			Prodotto prodotto = entry.getValue();
			
			if(cod2qta.containsKey(codice)) {
				Integer quantita = cod2qta.get(codice);
				prodotto2quantita.put(prodotto, quantita);
			}
		}
		return prodotto2quantita;
	}
}
