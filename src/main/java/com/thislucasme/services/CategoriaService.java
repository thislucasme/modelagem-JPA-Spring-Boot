package com.thislucasme.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thislucasme.domain.Categoria;
import com.thislucasme.repositories.CategoriaRepository;
import com.thislucasme.services.exceptions.ObjectNotFoundExceptionAPI;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() ->  new ObjectNotFoundExceptionAPI("Objeto nao encontrado! Id: "+id+" Tipo: "+Categoria.class.getName()));
	}
}
