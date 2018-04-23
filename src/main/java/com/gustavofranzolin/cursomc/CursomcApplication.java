package com.gustavofranzolin.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavofranzolin.cursomc.domain.Categoria;
import com.gustavofranzolin.cursomc.domain.Cidade;
import com.gustavofranzolin.cursomc.domain.Estado;
import com.gustavofranzolin.cursomc.domain.Produto;
import com.gustavofranzolin.cursomc.repositories.CategoriaRepository;
import com.gustavofranzolin.cursomc.repositories.CidadeRepository;
import com.gustavofranzolin.cursomc.repositories.EstadoRepository;
import com.gustavofranzolin.cursomc.repositories.ProdutoRepository;

/*
O commandLineRunner através do método que ele implementa, permite executar alguma ação
antes da aplicação rodar. Para efeito de teste, foi colocado duas instancias de categoria
para ocupar o banco de dados.


*/
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
private	CategoriaRepository categoriaRepository;
	@Autowired
private ProdutoRepository produtoRepository;
	
	@Autowired
private CidadeRepository cidadeRepository;

	@Autowired
private EstadoRepository estadoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	// Aqui estão todas instancias do objetos e das Listas para efeito de teste.
	// Como está no mapeamento objeto-objeto
	
	
	@Override
	public void run(String... args) throws Exception {
			Categoria cat1 = new Categoria(null, "Informatica");
			Categoria cat2 = new Categoria(null, "Escritorio");

			Produto p1 = new Produto(null, "computador", 2000.00 );	
			Produto p2 = new Produto(null, "impressora", 800.00 );	
			Produto p3 = new Produto(null, "mouse", 80.00 );	

			cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
			cat2.getProdutos().addAll(Arrays.asList(p2));
			
			p1.getCategorias().addAll(Arrays.asList(cat1));
			p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
			p3.getCategorias().addAll(Arrays.asList(cat1));
			
		
			categoriaRepository.save(Arrays.asList(cat1, cat2));
			produtoRepository.save(Arrays.asList(p1,p2,p3));
		
			
			
			Estado est1 = new Estado(null, "Minas Gerais");
			Estado est2 = new Estado(null, "São Paulo");
			Cidade c1 = new Cidade(null, "Uberlândia", est1);
			Cidade c2 = new Cidade(null, "São Paulo", est2);
			Cidade c3 = new Cidade(null, "Campinas", est2);
			
			est1.getCidades().addAll(Arrays.asList(c1));
			est2.getCidades().addAll(Arrays.asList(c2, c3));
			
			estadoRepository.save(Arrays.asList(est1,est2));
			cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
	}
}
