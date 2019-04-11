package com.paulo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulo.cursomc.domain.Categoria;
import com.paulo.cursomc.repositories.CategoriaRepositories;
import com.paulo.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositories repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id +"Tipo:" + Categoria.class.getName() ));
		
	}
	
	

}
