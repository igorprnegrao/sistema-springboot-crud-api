package br.com.negrao_ipr.projeto_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.negrao_ipr.projeto_backend.dto.UsuarioDTO;
import br.com.negrao_ipr.projeto_backend.entity.UsuarioEnity;
import br.com.negrao_ipr.projeto_backend.repository.UsuarioRepository;

@Service //annotation para demostrar service
public class UsuarioService {
	@Autowired //injeção de dependecia (auto estanciamento)
	private UsuarioRepository usuarioRepository;
	
	// listar 
	public List<UsuarioDTO> listarTodos(){
		List<UsuarioEnity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList(); //pecorrer a lista automaticamente, cria um usuarioDTO e converter para string
		
	}
	//criar um nova entidade no banco de dados
	// vai converter usuario DTO pra Entity pra inserio no BD 
	public void inserir(UsuarioDTO usuario) {
		UsuarioEnity usuarioEnity = new UsuarioEnity(usuario);
		usuarioRepository.save(usuarioEnity);
	}
	//alterar uma entidade no banco de dados  
	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEnity usuarioEnity = new UsuarioEnity(usuario);
		return new UsuarioDTO(usuarioRepository.save(usuarioEnity));
	}
	//excluir entidade do banco de dados
	public void excluir(long id) {
		UsuarioEnity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	//buscar por Id
	public UsuarioDTO buscarPorId(Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());
	}
}
