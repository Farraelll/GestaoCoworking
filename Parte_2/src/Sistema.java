import java.util.ArrayList;

public class Sistema {
	private ArrayList<Cliente> clientes;
	private ArrayList<Espaco> estacoes = new ArrayList<>();
	private ArrayList<Espaco> salas = new ArrayList<>();


	public Sistema(double valorHora, double taxaLimpeza, double precoProjetor, double precoMonitor) {
		this.clientes = new ArrayList<>();

		Espaco.setValorHora(valorHora);
        Espaco.setTaxaLimpeza(taxaLimpeza);
        Sala.setPrecoProjetor(precoProjetor);
        Estacao.setPrecoMonitor(precoMonitor);
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Espaco> getSalas() {
		return salas;
	}

	public ArrayList<Espaco> getEstacoes() {
		return estacoes;
	}

	public Cliente getCliente(String cpf) {
		for (Cliente c : this.clientes) {
			if (c.getCpf().equals(cpf)) return c;
		}
		return null;
	}

	public void cadastrar(Cliente cli) {
		this.clientes.add(cli);
	}

	public void cadastrar(Sala s) {
		this.salas.add(s);
	}

	public void cadastrar(Estacao e) {
		this.estacoes.add(e);
	}

	public boolean reservar(String tipo, Data d, Horario inicio, Horario fim, Cliente c, boolean extra) {
		if (tipo.equalsIgnoreCase("s")) {
	        for (Espaco sala : this.salas) {
	            if (sala.disponivel(d, inicio, fim, extra)) {
					Reserva novaReserva = new Reserva(d, inicio, fim, sala, c);
	                sala.adicionarReserva(novaReserva);
	                return true;
	            }
	        }
	    } else if (tipo.equalsIgnoreCase("e")) {
	        for (Espaco estacao : this.estacoes) {
	            if (estacao.disponivel(d, inicio, fim, extra)) {
	                Reserva novaReserva = new Reserva(d, inicio, fim, estacao, c);
	                estacao.adicionarReserva(novaReserva);
	                return true;
	            }
	        }
	    }
	    return false;
	}

	// reservar o dia inteiro
	public boolean reservar(String tipo, Data d, Cliente c, boolean extra) {
		return reservar(tipo, d, new Horario(8, 0), new Horario(22, 0), c, extra);
	}

	// reservar um turno
	public boolean reservar(String tipo, Data d, String turno, Cliente c, boolean extra) {
	    Horario inicio = null;
		Horario fim = null;

	    if (turno.equalsIgnoreCase("m") || turno.equalsIgnoreCase("matutino")) {
	        inicio = new Horario(8, 0);
	        fim = new Horario(12, 0);
	    } else if (turno.equalsIgnoreCase("v") || turno.equalsIgnoreCase("vespertino")) {
	        inicio = new Horario(13, 0);
	        fim = new Horario(17, 0);
	    } else if (turno.equalsIgnoreCase("n") || turno.equalsIgnoreCase("noturno")) {
	        inicio = new Horario(18, 0);
	        fim = new Horario(22, 0);
	    }

	    if (inicio != null) return reservar(tipo, d, inicio, fim, c, extra);
	    return false;
	}

	public ArrayList<Reserva> getReservas() {
		ArrayList<Reserva> todasReservas = new ArrayList<>();

		for (Espaco sala : this.salas) {
			todasReservas.addAll(sala.getReservas());
		}
		for (Espaco estacao : this.estacoes) {
			todasReservas.addAll(estacao.getReservas());
		}
		return todasReservas;
	}

	public ArrayList<Reserva> getReservas(Data d) {
		ArrayList<Reserva> reservasData = new ArrayList<>();

		for (Reserva r : getReservas()) {
			if(r.getData().equals((d))) {
				reservasData.add(r);
			}
		}
		return reservasData;
	}

	public ArrayList<Reserva> getReservas(Cliente c) {
		ArrayList<Reserva> reservasCliente = new ArrayList<>();

		for (Reserva r : getReservas()) {
			if(r.getCliente().equals(c)) {
				reservasCliente.add(r);
			}
		}
		return reservasCliente;
	}
}
