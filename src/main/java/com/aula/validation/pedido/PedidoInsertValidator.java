package com.aula.validation.pedido;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aula.domain.Pedido;
import com.aula.domain.dto.PedidoNewDTO;
import com.aula.repository.PedidoRepository;
import com.aula.resource.exception.FieldMessage;


public class PedidoInsertValidator implements ConstraintValidator<PedidoInsert, PedidoNewDTO> {
	@Autowired
	private PedidoRepository repo;

	
	@Override
	public void initialize(PedidoInsert ann) {
	}

	@Override
	public boolean isValid(PedidoNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Pedido aux1 = repo.findByDataPedido(objDto.getDataPedido());
		if(aux1 !=null) {
			list.add(new FieldMessage("dataPedido"," Data do pedido já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}