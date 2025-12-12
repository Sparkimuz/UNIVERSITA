import java.util.HashMap;
import java.util.Map;

class Studente {
    // NON MODIFICARE QUESTA CLASSE
    private String matricola;
    private int eta;
    
    public Studente(String matricola, int eta) {
        this.matricola = matricola;
        this.eta = eta;
    }

    public String getMatricola() { return matricola; }

    public int getEta() { return eta; }
    
    // NON MODIFICARE QUESTA CLASSE
    @Override
    public int hashCode() { return this.matricola.hashCode(); } // La matricola e' univoca
    
    public boolean equals(Object o) {
        Studente s = (Studente) o;
        return this.getMatricola().equals(s.getMatricola()); // La matricola e' univoca
    }
    // NON MODIFICARE QUESTA CLASSE

}

public class OperazioniStudenti {

    public Map<Studente, Integer> getStudente2voto(Map<String, Studente> mat2stud, Map<String, Integer> mat2voto) {
        Map<Studente, Integer> stud2voto = new HashMap<>();
        Studente studente = mat2stud.get(stud2voto);
    	Integer voto = voto2stud.get(matricola);
        for(String matricola : mat2stud.) {
        	
        	
        	if(voto == null) {
        		
        	}
        	
        	stud2voto.put(Studente mat2stud.get(matricola), voto)
        	
        }
        
        
        return stud2voto;
    }

}
