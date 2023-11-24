package com.aula.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aula.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	@Query(value = "SELECT * FROM produto", nativeQuery = true)
	List<Produto> findAllCat();

	@Query(value = "SELECT * FROM produto where id = ?", nativeQuery = true)
	Produto findPorId(Integer idproduto);
	
    List<Produto> findByPreco(BigDecimal preco);
    List<Produto> findByNome(String nome);
}
