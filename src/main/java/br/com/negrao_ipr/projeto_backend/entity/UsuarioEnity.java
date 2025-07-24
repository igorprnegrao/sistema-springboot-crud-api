package br.com.negrao_ipr.projeto_backend.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.negrao_ipr.projeto_backend.dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity						  // Criar uma entidade no BD usando a annotation JPA 	
@Table(name = "IPRN_USUARIO") //Criar tabela com o nome IPRN_USUARIO
public class UsuarioEnity {
	@Id						 // o dado "Id" será minha primary key e autoinclementada.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false) // na coluna "nome" será obrigatório o preenchimento assim como as demais
	private String nome;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false, unique = true) //login será único, não pode haver dois logins indênticos
	private String Senha;
	@Column(nullable = false)
	private String email;
	
	
	// construtor vazio padrão
	public UsuarioEnity() {
			
	}
		
	//Construtor para copiar os dados do UsuarioEntity para usuarioDTO
	public UsuarioEnity (UsuarioDTO usuario) {
		BeanUtils.copyProperties(usuario, this); ///usamos a classe beanutils para converter
												/// usuarioDTO para UsuarioEntity
	}
	
	
	//Gerei os Getters ans setters (Encapsulamento)
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
	
	//comparação entre dois "IDs"
	
	@Override
	public int hashCode() {
		return Objects.hash(Senha, email, id, login, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEnity other = (UsuarioEnity) obj;
		return Objects.equals(Senha, other.Senha) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(login, other.login) && Objects.equals(nome, other.nome);
	}
	
	
	
}
