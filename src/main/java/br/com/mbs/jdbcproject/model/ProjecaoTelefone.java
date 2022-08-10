package br.com.mbs.jdbcproject.model;

public class ProjecaoTelefone {

	private String nome;
	private String numero;
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ProjecaoTelefone [nome=" + nome + ", numero=" + numero + ", email=" + email + "]";
	}

}
