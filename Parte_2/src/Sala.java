public class Sala extends Espaco{
	private boolean projetor;
	private static double precoProjetor;

	public Sala(String descricao, boolean projetor) {
		this.setDescricao(descricao);
		this.setProjetor(projetor);
	}

	public boolean isProjetor() {
		return projetor;
	}

	public void setProjetor(boolean projetor) {
		this.projetor = projetor;
	}

	public static double getPrecoProjetor() {
		return precoProjetor;
	}

	public static void setPrecoProjetor(double precoProjetor) {
		Sala.precoProjetor = precoProjetor;
	}

	public String toString() {
		if (projetor) {
			return super.toString() + " (Sala com Projetor)";
		}
		return super.toString() + " (Sala sem Projetor)";
	}

	public double preco(Horario inicio, Horario fim) {
	    double total = (4 * getValorHora() * inicio.calcTempo(fim)) + getTaxaLimpeza();
	    if (this.projetor) {
	        total += precoProjetor;
	    }
	    return total;
	}

	public boolean possuiAdicional() {
		return this.projetor;
	}
}
