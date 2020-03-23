package presc_lib.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import presc_lib.dao.ValidationRepository;
import presc_lib.entities.Validation;

@Service
public class ValidationMetierImp implements IValidationMetier{
  
@Autowired
private ValidationRepository validationRepository;
	@Override
	public Validation save(Validation entity) 
	      {
		//date & heur
		//entity.setDateV(date);
		//entity.setDateV(date);
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
		return validationRepository.findById(id).orElse(null);
	}

	@Override
	public void stop(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Validation> getValuesByContent(Long idC) {
		return  validationRepository.findValuesByContent(idC);
	}

	
	
}
