package com.thislucasme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thislucasme.domain.Categoria;
import com.thislucasme.domain.Cliente;
import com.thislucasme.domain.Endereco;;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	
}
