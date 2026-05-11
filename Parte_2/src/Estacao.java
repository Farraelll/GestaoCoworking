public class Estacao extends Espaco{
	private boolean monitorExtra;
	private static double precoMonitor;

	public Estacao(String nome, boolean monitor) {
		this.setDescricao(nome);
		this.setMonitorExtra(monitor);
	}

	public boolean isMonitorExtra() {
		return monitorExtra;
	}

	public void setMonitorExtra(boolean monitorExtra) {
		this.monitorExtra = monitorExtra;
	}

	public static double getPrecoMonitor() {
		return precoMonitor;
	}

	public static void setPrecoMonitor(double precoMonitor) {
		Estacao.precoMonitor = precoMonitor;
	}

	public String toString() {
		if (monitorExtra) {
			return super.toString() + " (Estação de Trabalho com Monitor Extra)";
		}
		return super.toString() + " (Estação de Trabalho sem Monitor Extra)";
	}

	public double preco(Horario inicio, Horario fim) {
	    if (this.monitorExtra) {
	        return super.preco(inicio, fim) + precoMonitor;
	    }
	    return super.preco(inicio, fim);
	}

	public boolean possuiAdicional() {
		return this.monitorExtra;
	}
}
