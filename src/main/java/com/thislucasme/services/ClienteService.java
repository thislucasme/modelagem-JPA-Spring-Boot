package com.thislucasme.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thislucasme.domain.Categoria;
import com.thislucasme.domain.Cliente;
import com.thislucasme.repositories.CategoriaRepository;
import com.thislucasme.repositories.ClienteRepository;
import com.thislucasme.services.exceptions.ObjectNotFoundExceptionAPI;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() ->  new ObjectNotFoundExceptionAPI("Objeto nao encontrado! Id: "+id+" Tipo: "+Cliente.class.getName()));
	}
}
