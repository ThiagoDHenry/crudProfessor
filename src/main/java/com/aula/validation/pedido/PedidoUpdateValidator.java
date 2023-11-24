package com.aula.validation.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.aula.domain.Pedido;
import com.aula.domain.dto.PedidoDTO;
import com.aula.repository.PedidoRepository;
import com.aula.resource.exception.FieldMessage;



public class PedidoUpdateValidator implements ConstraintValidator<PedidoUpdate, PedidoDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PedidoRepository repo;

	
	@Override
	public void initialize(PedidoUpdate ann) {
	}

	@Override
	public boolean isValid(PedidoDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Map<String,String>map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		Pedido aux1 = repo.findByDataPedido(objDto.getDataPedido());	
		if(aux1 !=null && !aux1.getId().equals(uriId)) {
			list.add(new FieldMessage("pedido"," Razao já existente"));
		}
		


		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}