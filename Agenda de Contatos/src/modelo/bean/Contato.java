package modelo.bean;

public class Contato {
	private String nome;
	private String email;
	private String numero;
	
	private Contato(String nome, String email, String numero){
		this.nome = nome;
		this.email = email;
		this.numero = numero;
	}
	public static Contato create(String nome, String email, String numero) {
		return new Contato(nome, email, numero);
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getNumero() {
		return numero;
	}
}
