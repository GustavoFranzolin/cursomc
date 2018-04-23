package com.gustavofranzolin.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavofranzolin.cursomc.domain.Categoria;
import com.gustavofranzolin.cursomc.repositories.CategoriaRepository;
import com.gustavofranzolin.cursomc.services.exceptions.ObjectNotFoundException;

//Service - implementação do serviço
//Dependencia de um objeto CategoriaRepository
// @Autowired instancia automaticamente a CategoriaRepository - pelo mecanismo de injeção de dependências
// Como repo é instancia do CategoriaRepository, ele apresenta várias operações para manipulação do BD

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	

	
	
	// Lançamento de exceção na camada serviço
	public Categoria buscar(Integer id) {
		
		Categoria obj = repo.findOne(id);
		
			if(obj==null) {
					
				throw new ObjectNotFoundException("Objeto não encontrado!! Id:  " + id
						
						+ ", Tipo: " + Categoria.class.getName());
				
			}
		
		return obj;
		
	}
	
	
	


}
