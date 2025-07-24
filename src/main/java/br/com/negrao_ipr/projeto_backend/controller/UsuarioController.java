package br.com.negrao_ipr.projeto_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.negrao_ipr.projeto_backend.dto.UsuarioDTO;
import br.com.negrao_ipr.projeto_backend.entity.UsuarioEnity;
import br.com.negrao_ipr.projeto_backend.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<UsuarioDTO> listarTodos(){
		return usuarioService.listarTodos();
	}
	@PostMapping
	public void inserir(@RequestBody UsuarioDTO usuario) { //@RequestBody ler corpo da mensagem que veio do front
		usuarioService.inserir(usuario);
	}
	@PutMapping
	public UsuarioDTO alterar(@RequestBody UsuarioDTO usuario) {
		return usuarioService.alterar(usuario);
	}
	@DeleteMapping("/{id}") //pegar o id na url por parametro
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){ //link com o id do BD
		usuarioService.excluir(id);
		return ResponseEntity.ok().build(); //valor
	}
}
