package com.gustavofranzolin.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavofranzolin.cursomc.domain.Categoria;
import com.gustavofranzolin.cursomc.repositories.CategoriaRepository;

/*
O commandLineRunner através do método que ele implementa, permite executar alguma ação
antes da aplicação rodar. Para efeito de teste, foi colocado duas instancias de categoria
para ocupar o banco de dados.


*/
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
private	CategoriaRepository categoriaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			Categoria cat1 = new Categoria(null, "Informatica");
			Categoria cat2 = new Categoria(null, "Escritorio");
				
		
			categoriaRepository.save(Arrays.asList(cat1, cat2));
		
		
	}
}
