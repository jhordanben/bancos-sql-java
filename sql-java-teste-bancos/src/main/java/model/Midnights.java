package model;

public class Midnights {
	
	public int id;
	public String nome;
	public String email;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Midnights [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
	

}
