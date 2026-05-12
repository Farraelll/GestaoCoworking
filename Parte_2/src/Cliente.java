public class Cliente {
	private String nome, cpf, email, senha;

	public Cliente(String nome, String cpf, String email, String senha) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setSenha(senha);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String toString() {
		return this.nome + " (" + this.email + " CPF: " + this.cpf + ")";
	}

	public boolean equals(Object o) {
		if (!(o instanceof Cliente cliente)) return false;
		return getCpf().equals(cliente.getCpf());
	}
}