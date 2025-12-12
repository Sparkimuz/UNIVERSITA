/*Modificare la classe Cantante ed implementare il metodo statico getInsiemeOrdinato() in modo che i test vadano a buon fine.
Tale metodo, data una lista di cantanti, ritorna un insieme nel quale i cantanti sono ordinate secondo l'ordine alfabetico.*/
import java.util.*;

class Cantante implements Comparable<Cantante>{
    private String cognome;
    
    public Cantante(String cognome) {
        this.cognome = cognome;
    }
    
    @Override
    public int compareTo(Cantante altroCantante) {
    	return this.cognome.compareTo(altroCantante.getCognome());
    }
    
    public String getCognome() { return this.cognome; }  
    
    public static TreeSet<Cantante> getInsiemeOrdinato(List<Cantante> listaCantanti) {
    	TreeSet<Cantante> insiemeOrdinato = new TreeSet<>();
    	
    	insiemeOrdinato.addAll(listaCantanti);
    	
    	return insiemeOrdinato;
    }
    
}
