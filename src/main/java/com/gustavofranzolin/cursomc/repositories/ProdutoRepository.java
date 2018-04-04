package com.gustavofranzolin.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavofranzolin.cursomc.domain.Produto;

// Um objeto do tipo CategoriaRepository vai ser possível que faça consultas, como inserir, deletar referentes ao objeto Categoria
// na tabela de dados Categoria
// A anotação Repository permite que a CategoriaRepository faça as manipulações no banco de dados
// JpaRepository capaz de acessar os dados Categoria, Integer é o tipo do atributo identificador do objeto

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	
	

}
