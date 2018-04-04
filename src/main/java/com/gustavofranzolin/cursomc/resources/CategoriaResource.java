package com.gustavofranzolin.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gustavofranzolin.cursomc.domain.Categoria;
import com.gustavofranzolin.cursomc.services.CategoriaService;


@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	// Acrescentando o /{id} indica que o end-point agora é /categorias/{id} o Id que a pessoa entrar
	// Para o spring saiba que o Integer do id do método vá para o Id do end-point, é necessário incluir o
	//@PathVariable
	//ReponseEntity tipo especial do Spring, que encapsula os tipo HTTP, para o tipo REST, objeto complexo
	// vai ter várias informações do protocolo HTTP
	
	
	
	@RequestMapping(value="/{id}",  method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria obj = service.buscar(id);
		
	
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	
}
