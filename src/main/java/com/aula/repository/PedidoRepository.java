package com.aula.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aula.domain.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	@Query(value = "SELECT * FROM pedido", nativeQuery = true)
	List<Pedido> findAllCat();

	@Query(value = "SELECT * FROM pedido where id = ?", nativeQuery = true)
	Pedido findPorId(Integer idpedido);

	Pedido findByDataPedido(LocalDate localDate);

    
}


