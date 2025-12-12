public class Portale(){
    private Studente studenteCorrente;
    private PSI psiCorrente;
    private Università università;
    private InsegnamentoScelto insegnamentoSceltoCorrente;

    public void loginStudente(matricola, pwd){
        this.studenteCorrente = università.getStudente(matricola);
        this.studenteCorrente.checkpwd(pwd);

    }
    public void iniziaCompilazionePSI(){
        PSI p = new PSI(studenteCorrente);
        this.psiCorrente = p;
    }

    public void SelezionaInsegnamento(idInsegnamento){
        Insegnamento i = università.getInsegnamento(idInsegnamento);
        this.insegnamentoSceltoCorrente = new InsegnamentoScelto(idInsegnamento);
    }
    
    
}
public class Università(){
    private Dipartimento d;
    
    public Studente getStudente(matricola){
        return d.getStudente(matricola);
    }
}

public class Dipartimento(){
    private CorsoDiLaurea cdl;
    
    public Studente getStudente(matricola){
        return cdl.getStudente(matricola);
    }
}

public class CorsoDiLaurea(){
    private Map<Studente> studenti;
    
    public Studente getStudente(matricola){
        return this.studenti.find(matricola);
    }
}

public class PSI(){
    private Studente studente;
    private Collection<InsegnamentoScelto> insegnamentiScelti;

    PSI PSI(Studente s){
        this.studente = s;
        this.insegnamentiScelti = new Collection<>();

    }
}