package br.com.negrao_ipr.projeto_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.negrao_ipr.projeto_backend.entity.UsuarioEnity;

//foi criado uma interface que extende aa classe pai JPARepository - trabalhando a classe entity e variavel tipo long

public interface UsuarioRepository extends JpaRepository<UsuarioEnity, Long> {

}
