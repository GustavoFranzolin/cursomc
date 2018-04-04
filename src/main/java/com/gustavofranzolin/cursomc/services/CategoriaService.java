package com.gustavofranzolin.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavofranzolin.cursomc.domain.Categoria;
import com.gustavofranzolin.cursomc.repositories.CategoriaRepository;

//Service - implementação do serviço
//Dependencia de um objeto CategoriaRepository
// @Autowired instancia automaticamente a CategoriaRepository - pelo mecanismo de injeção de dependências
// Como repo é instancia do CategoriaRepository, ele apresenta várias operações para manipulação do BD

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria buscar(Integer id) {
		
		Categoria obj = repo.findOne(id);
		
		return obj;
		
	}
	
	
	


}
