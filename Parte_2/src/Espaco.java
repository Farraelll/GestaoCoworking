import java.util.ArrayList;

public class Espaco {
    protected String descricao;
    protected static double valorHora, taxaLimpeza;
    protected ArrayList<Reserva> reservas = new ArrayList<>();

    public double getValorHora() {
        return valorHora;
    }

    public double getTaxaLimpeza() {
        return taxaLimpeza;
    }

    public String toString() {
        return "Espaco{}";
    }



    public boolean disponivel(Data d, Horario inicio, Horario fim, boolean extra) {

        return false;
    }

    public void adicionarReserva(Reserva r) {
        this.reservas.add(r);
    }

    public double preco(Horario inicio, Horario fim) {
        return ((this.getValorHora() * inicio.calcTempo(fim)) + this.getTaxaLimpeza());
    }

    public boolean possuiAdicional() {
        return true;
    }

}
