package com.paulo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulo.cursomc.domain.Cliente;


@Repository
public interface ClienteRepositories extends JpaRepository<Cliente , Integer> {

}
