package br.com.negrao_ipr.projeto_backend.dto;

import org.springframework.beans.BeanUtils;
import br.com.negrao_ipr.projeto_backend.entity.UsuarioEnity;

public class UsuarioDTO {
	
	private long id;
	
	private String nome;
	
	private String login;

	private String Senha;
	
	private String email; //email
	
	// construtor vazio padrão
	public UsuarioDTO() {
		
	}
	
	//Construtor para copiar os dados do UsuarioEntity para usuarioDTO
	public UsuarioDTO (UsuarioEnity usuario) {
		BeanUtils.copyProperties(usuario, this); ///usamos a classe beanutils para copiar
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
