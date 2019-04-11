package com.paulo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulo.cursomc.domain.Pagamento;


@Repository
public interface PagamentoRepositories extends JpaRepository<Pagamento , Integer> {

}
