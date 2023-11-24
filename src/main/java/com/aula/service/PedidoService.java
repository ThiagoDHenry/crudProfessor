package com.aula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.domain.Pedido;
import com.aula.domain.dto.PedidoDTO;
import com.aula.domain.dto.PedidoNewDTO;
import com.aula.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> getPedidoById(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido createPedido(PedidoNewDTO pedidoNewDTO) {
        Pedido pedido = new Pedido();
        pedido.setDataPedido(pedidoNewDTO.getDataPedido());
        pedido.setValor(pedidoNewDTO.getValor());
        return pedidoRepository.save(pedido);
    }

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido updatePedido(Long id, PedidoDTO pedidoDTO) {
        Pedido pedido = getPedidoById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedido.setValor(pedidoDTO.getValor());
        return pedidoRepository.save(pedido);
    }
}
