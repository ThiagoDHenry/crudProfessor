package com.aula.validation.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.aula.domain.Produto;
import com.aula.domain.dto.ProdutoDTO;
import com.aula.repository.ProdutoRepository;
import com.aula.resource.exception.FieldMessage;



public class ProdutoUpdateValidator implements ConstraintValidator<ProdutoUpdate, ProdutoDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ProdutoRepository repo;

	
	@Override
	public void initialize(ProdutoUpdate ann) {
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean isValid(ProdutoDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Map<String,String>map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		Produto aux1 = (Produto) repo.findByNome(objDto.getNome());	
		if(aux1 !=null && !aux1.getId().equals(uriId)) {
			list.add(new FieldMessage("produto"," Produto já existente"));
		}
		


		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}