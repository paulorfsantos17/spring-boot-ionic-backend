package com.paulo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulo.cursomc.domain.Produto;


@Repository
public interface ProdutoRepositories extends JpaRepository<Produto , Integer> {

}
