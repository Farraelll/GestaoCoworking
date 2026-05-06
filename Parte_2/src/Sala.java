public class Sala extends Espaco{
    private boolean projetor;
    private static double precoProjetor;

    public String toString() {
        return "Sala{}";
    }

    public double preco(Horario inicio, Horario fim) {
        return super.preco(inicio, fim) + precoProjetor;
    }

    public boolean possuiAdicional() {

        return true;
    }
}
