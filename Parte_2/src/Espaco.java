import java.util.ArrayList;

public class Espaco {
	protected String descricao;
	protected static double valorHora, taxaLimpeza;
	protected ArrayList<Reserva> reservas = new ArrayList<>();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static double getValorHora() {
		return valorHora;
	}

	public static void setValorHora(double valorHora) {
		Espaco.valorHora = valorHora;
	}

	public static double getTaxaLimpeza() {
		return taxaLimpeza;
	}

	public static void setTaxaLimpeza(double taxaLimpeza) {
		Espaco.taxaLimpeza = taxaLimpeza;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public Espaco setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;

		return this;
	}

	public String toString() {
		return descricao;
	}

	public boolean disponivel(Data d, Horario inicio, Horario fim, boolean extra) {
		if (!possuiAdicional()) {return false;}



		return true;
	}

	public void adicionarReserva(Reserva r) {
		this.reservas.add(r);
	}

	public double preco(Horario inicio, Horario fim) {
		return ((getValorHora() * inicio.calcTempo(fim)) + getTaxaLimpeza());
	}

	public boolean possuiAdicional() {
		return true;
	}
}
