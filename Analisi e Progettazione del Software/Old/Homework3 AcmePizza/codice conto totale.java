public class Ordine {

    public List<VoceOrdine> vociOrdine;


    public int getTotale(){
        int tot=0;
        for vo in vociOrdine{
            tot+=vo.getTotVoce();
        }
    }
}

public class VoceOrdine{
    public Pizza pizza;
    public List<DescrizionePA> dpas;

    int getTotVoce(){
        p=pizza.getPrezzo();
        for dpa in dpas{
            p+=dpa.getPrezzo();
        }
        return p
    }

}
