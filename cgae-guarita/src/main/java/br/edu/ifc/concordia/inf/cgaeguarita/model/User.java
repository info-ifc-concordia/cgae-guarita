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
	
	private String name;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String username;
	private String password;
	private int accesso = UserRoles.NORMAL.getAccessLevel();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
