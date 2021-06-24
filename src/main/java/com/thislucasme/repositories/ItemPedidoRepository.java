package com.thislucasme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thislucasme.domain.Categoria;
import com.thislucasme.domain.ItemPedido;;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
	
}
