import java.util.*;

class Prodotto {
    private String codice;
    private String marca;

    public Prodotto(String codice, String marca) {
        this.codice = codice;
        this.marca = marca;
    }

    public String getCodice() {
        return this.codice;
    }

    public String getMarca() {
        return this.marca;
    }

}

public class RaggruppatoreProdottiPerMarca {
    private List<Prodotto> elencoProdotti;

    public RaggruppatoreProdottiPerMarca() {
        this.elencoProdotti = new ArrayList<Prodotto>();
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        this.elencoProdotti.add(prodotto);
    }

    public Map<String, List<Prodotto>> marca2prodotto() {
        Map<String, List<Prodotto>> marca2prodotto = new HashMap<String, List<Prodotto>>();
        for(Prodotto prodotto : elencoProdotti) {
        	String marca = prodotto.getMarca();
        	
        	if(!marca2prodotto.containsKey(marca)) {
        		marca2prodotto.put(marca, new ArrayList<Prodotto>());
        	}
        	
        	marca2prodotto.get(marca).add(prodotto);
        			
        	
        }

        return marca2prodotto;
    }
    
}