package presc_lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presc_lib.entities.Validation;
import presc_lib.metier.IValidationMetier;

@RestController 
public class ValidationRestService {
	@Autowired
	private IValidationMetier iValidationMetier;

	@RequestMapping(value = "/validations",method = RequestMethod.POST)
	public Validation save(@RequestBody Validation entity) {
		return iValidationMetier.save(entity);
	}

	@RequestMapping(value = "/validations/{id}",method = RequestMethod.PUT)
	public Validation update(@PathVariable Long id,@RequestBody Validation entity) {
		return iValidationMetier.update(id, entity);
	}

	/*GetALL
	 * @RequestMapping(value = "validations",method = RequestMethod.GET) public
	 * List<Validation> getAll() { return iValidationMetier.getAll(); }
	 */

	@RequestMapping(value = "/validations/Content/{idC}",method = RequestMethod.GET)
	public List<Validation> getValuesByContent(@PathVariable  Long idC) {
		return iValidationMetier.getValuesByContent(idC);
	}
    
	@RequestMapping(value = "/validations/{id}",method = RequestMethod.GET)
	public Validation getById(@PathVariable  Long id) {
		return iValidationMetier.getById(id);
	}

	/***stop validation
	 * @RequestMapping(value = "/stopValidation",method = RequestMethod.PUT) public
	 * void stop(@PathVariable Long id) { iValidationMetier.stop(id); }
	 */

}
