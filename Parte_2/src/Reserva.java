public class Reserva {
	private Data data;
	private Horario inicio, fim;
	private Espaco espaco;
	private Cliente cliente;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Horario getInicio() {
		return inicio;
	}

	public void setInicio(Horario inicio) {
		this.inicio = inicio;
	}

	public Horario getFim() {
		return fim;
	}

	public void setFim(Horario fim) {
		this.fim = fim;
	}

	public Espaco getEspaco() {
		return espaco;
	}

	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Reserva(Data data, Horario inicio, Horario fim, Espaco espaco, Cliente cliente) {
		this.setData(data);
		this.setInicio(inicio);
		this.setFim(fim);
		this.setEspaco(espaco);
		this.setCliente(cliente);
	}

	public String toString() {
		return  "* Local: " + espaco.toString() +
				"\n* Data: " + data.toString() +
				"\n* Horário: " + inicio.toString() + " - " + fim.toString() +
				"\n* Cliente: " + cliente.toString() +
				"\n* Valor: " + String.format("R$ %.2f", preco());
	}

	public double preco() {
		return espaco.preco(inicio, fim);
	}
}