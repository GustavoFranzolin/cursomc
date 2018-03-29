package com.gustavofranzolin.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavofranzolin.cursomc.domain.Categoria;

// Um objeto do tipo CategoriaRepository vai ser possível que faça consultas, como inserir, deletar
// na tabela de dados Categoria
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	
	

}
