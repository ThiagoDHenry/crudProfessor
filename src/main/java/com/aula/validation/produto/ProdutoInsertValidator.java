package com.aula.validation.produto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.aula.domain.Produto;
import com.aula.domain.dto.ProdutoNewDTO;
import com.aula.repository.ProdutoRepository;
import com.aula.resource.exception.FieldMessage;


public class ProdutoInsertValidator implements ConstraintValidator<ProdutoInsert, ProdutoNewDTO> {
	@Autowired
	private ProdutoRepository repo;

	
	@Override
	public void initialize(ProdutoInsert ann) {
	}

	@Override
	public boolean isValid(ProdutoNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Produto aux1 = (Produto) repo.findByNome(objDto.getNome());
		if(aux1 !=null) {
			list.add(new FieldMessage("Nome"," Nome do produto já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}