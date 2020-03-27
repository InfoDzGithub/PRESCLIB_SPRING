package presc_lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presc_lib.entities.Service;
import presc_lib.entities.Tests;
import presc_lib.exception.EntityException;
import presc_lib.exception.ResourceNotFoundException;
import presc_lib.metier.ITestMetier;

@RestController
public class TestRestService {
	@Autowired
	private ITestMetier iTestMetier;

	@RequestMapping(value = "/testsByprescription/{idP}",method = RequestMethod.GET)
	public List<Tests> getAllContentByPrescription(@PathVariable Long idP) {
		return iTestMetier.getAllContentByPrescription(idP);
	}

	@RequestMapping(value = "/tests",method = RequestMethod.POST)
	public Tests save(@RequestBody Tests entity) {
		return iTestMetier.save(entity);
	}

	@RequestMapping(value = "/tests/{id}",method = RequestMethod.PUT)
	public Tests update(@PathVariable Long id,@RequestBody Tests entity) {
		return iTestMetier.update(id, entity);
	}

	
	@RequestMapping(value = "/actifTestsByPrescription/{idP}",method = RequestMethod.GET)
	public List<Tests> getActifContentByPrescription(@PathVariable Long idP) {
		return iTestMetier.getActifContentByPrescription(idP);
	}

	@RequestMapping(value = "/allTests",method = RequestMethod.GET)
	public List<Tests> getAll() {
		return iTestMetier.getAll();
	}
	@RequestMapping(value = "/tests/{id}",method = RequestMethod.GET)
	public Tests getById(@PathVariable Long id) throws EntityException,ResourceNotFoundException {
		try {
					Tests test=iTestMetier.getById(id);
								if(test==null)
								{
									
									throw new ResourceNotFoundException("Test not found");
								}
								return test;
					
				} catch (EntityException e) {
					throw new EntityException("Internal Server Exception while getting exception");
						}
			}
	
	@RequestMapping(value = "/stopTest/{id}",method = RequestMethod.PUT)
	public void stop(@PathVariable Long id) {
		iTestMetier.stop(id);
	}

}
