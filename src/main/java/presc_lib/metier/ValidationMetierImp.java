package presc_lib.metier;

import java.util.List;

import presc_lib.dao.ValidationRepository;
import presc_lib.entities.Validation;

public class ValidationMetierImp implements IValidationMetier{
  
private ValidationRepository validationRepository;
	@Override
	public Validation save(Validation entity) 
	{
		return validationRepository.save(entity);
	}

	@Override
	public Validation update(Long id, Validation entity) {
		entity.setId(id);
	    return validationRepository.save(entity);
	}

	@Override
	public List<Validation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Validation getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Validation> getValuesByContent(Long IdC) {
		return validationRepository.findValuesByContent(IdC);
	}

	
	
}
