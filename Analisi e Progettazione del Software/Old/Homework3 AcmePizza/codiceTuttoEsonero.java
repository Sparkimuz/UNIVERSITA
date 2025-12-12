public class Portale(){
    private Ordine ordineCorrente;
    private Menu menuCorrente;

    public void aggiungiPizzaAllOrdine(idPizza){
        p=menuCorrente.getPizza(idPizza);
        ordineCorrente.addPizza(p);
    }
    
    
}

public class Menu(){
    private Map<Pizza> pizze;

    public Pizza getPizza(String idPizza){
        return this.pizze.find(idPizza);
    }
}


public class Ordine(){
    private List<VoceOrdine> vociOrdine;

    public void addPizza(Pizza p){
        VoceOrdine vo = new VoceOrdine(p); 
        vociOrdine.add(vo);
    }

    /*int getTotale(){
        int tot = 0;
        for sli in vociOrdine
            tot = tot + sli.getPrezzo
        return tot
    }*/



}

public class VoceOrdine(){
    private Pizza p;
    private List<ProdottoAggiuntivo> ProdottiAggiuntivi;

    
    public VoceOrdine(Pizza p){
        this.p= p;
        this.ProdottiAggiuntivi = new ArrayList<ProdottoAggiuntivo>();
        
    }

    public int getSubtotale(){
        subtot
        return subtotal;
    }
}