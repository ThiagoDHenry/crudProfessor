package com.aula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.domain.Produto;
import com.aula.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> getProdutosByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public List<Produto> getProdutosByPreco(BigDecimal preco) {
        return produtoRepository.findByPreco(preco);
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Long id, Produto produto) {
        Optional<Produto> existingProduto = produtoRepository.findById(id);
        if (existingProduto.isPresent()) {
            Produto updatedProduto = existingProduto.get();
            updatedProduto.setNome(produto.getNome());
            updatedProduto.setPreco(produto.getPreco());
            return produtoRepository.save(updatedProduto);
        }
        return null; 
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

}

