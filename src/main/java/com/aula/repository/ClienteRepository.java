package com.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aula.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Query(value = "SELECT * FROM cliente", nativeQuery = true)
    List<Cliente> findAllClientes();

    @Query(value = "SELECT * FROM cliente where id = ?", nativeQuery = true)
    Cliente findPorId(Integer idCliente);

    Cliente findByNome(String nome);
}

