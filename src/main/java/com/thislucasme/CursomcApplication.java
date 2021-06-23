package com.thislucasme;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thislucasme.domain.Categoria;
import com.thislucasme.domain.Cidade;
import com.thislucasme.domain.Cliente;
import com.thislucasme.domain.Endereco;
import com.thislucasme.domain.Estado;
import com.thislucasme.domain.Produto;
import com.thislucasme.domain.enuns.TipoCliente;
import com.thislucasme.repositories.CategoriaRepository;
import com.thislucasme.repositories.CidadeRepository;
import com.thislucasme.repositories.ClienteRepository;
import com.thislucasme.repositories.EnderecoRepository;
import com.thislucasme.repositories.EstadoRepository;
import com.thislucasme.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 =new Produto(null, "Celular", 1320.98);
		Produto p2 =new Produto(null, "MacBook Pro", 6400.48);
		Produto p3 =new Produto(null, "Miband", 310.53);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		
		Estado est1 = new Estado(null, "Minas Gereais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);	
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,  c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "lucas@gmail.com", "14.000.000", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("999383382"));
		
		
		Endereco e1 = new Endereco(null, "Rua prefeito Joao Costa", "300", "apt 1266", "Centro", "38601000", cli1, c1);
		Endereco e2 = new Endereco(null, "Vereador joao narciso", "200", "apt 66", "Cachoeira", "38603000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}
