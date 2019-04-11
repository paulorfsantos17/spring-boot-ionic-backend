package com.paulo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulo.cursomc.domain.ItemPedido;


@Repository
public interface ItemPedidoRepositories extends JpaRepository<ItemPedido , Integer> {

}
