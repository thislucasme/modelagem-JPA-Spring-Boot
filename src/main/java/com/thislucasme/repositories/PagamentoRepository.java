package com.thislucasme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thislucasme.domain.Categoria;
import com.thislucasme.domain.Pagamento;
import com.thislucasme.domain.Pedido;;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
	
}
