public class Corso {
    private int cfu;
    private String nome;

    public Corso(String nome, int cfu) {
        this.nome = nome;
        this.cfu = cfu;
    }

    public void cambioNome(String nome){
        this.nome = nome;
    }

    public String toString() {
        return this.nome + " " + this.cfu;
    }

    public static void main(String[] args) {
        Corso c1 = new Corso("AAAA", 1);
        Corso c2 = new Corso("BBBB", 2);
        Corso c3 = c1; 

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        c2 = c3;
        c2.cambioNome("CCCC");

        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
}