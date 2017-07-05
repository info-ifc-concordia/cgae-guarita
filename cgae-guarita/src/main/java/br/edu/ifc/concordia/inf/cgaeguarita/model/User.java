package br.edu.ifc.concordia.inf.cgaeguarita.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.ifc.concordia.inf.cgaeguarita.permission.UserRoles;

@Entity(name="users")
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String username;
	private String senha;
	private int accesso = UserRoles.NORMAL.getAccessLevel();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAccesso() {
		return accesso;
	}
	public void setAccesso(int accesso) {
		this.accesso = accesso;
	}
	
	
	
	
}
