package com.paulo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulo.cursomc.domain.Categoria;


@Repository
public interface CategoriaRepositories extends JpaRepository<Categoria , Integer> {

}
