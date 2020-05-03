package presc_lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import presc_lib.entities.Patient;
import presc_lib.entities.Service;
import presc_lib.entities.User;
import presc_lib.exception.EntityException;
import presc_lib.exception.ResourceNotFoundException;
import presc_lib.metier.IServiceMetier;
import presc_lib.metier.ServiceMetierImp;

@RestController
@CrossOrigin("*")
public class ServiceRestService {
    
	@Autowired
	private IServiceMetier iServiceMetier;
    
	@RequestMapping(value = "/services",method = RequestMethod.POST)
	public Service save(@RequestBody Service entity) {
		return iServiceMetier.save(entity);
	}

	@RequestMapping(value = "/services/{id}",method = RequestMethod.PUT)
	public Service update(@PathVariable Long id,@RequestBody Service entity) {
		return iServiceMetier.update(id, entity);
	}

	@RequestMapping(value = "/services",method = RequestMethod.GET)
	public List<Service> getAll() {
		return iServiceMetier.getAll();
	}

	@RequestMapping(value = "/services/{id}",method = RequestMethod.GET)
	public Service getById(@PathVariable Long id) throws EntityException,ResourceNotFoundException {
			
			try {
				Service s=iServiceMetier.getById(id);
							if(s==null)
							{
								
								throw new ResourceNotFoundException("service not found");
							}
							return s;
				
			} catch (EntityException e) {
				throw new EntityException("Internal Server Exception while getting exception");
					}
		}

    
	@RequestMapping(value = "/archiveService/{id}",method = RequestMethod.GET)
	public void stop(@PathVariable Long id) {
		iServiceMetier.stop(id);
	}
	
	@RequestMapping(value = "/enableService/{id}",method = RequestMethod.GET)
	public void enable(@PathVariable Long id) {
		iServiceMetier.enableService(id);
	}
	
	@RequestMapping(value = "/AllServices",method = RequestMethod.GET)
	public Page<Service> allService(
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="3") int size) throws EntityException,ResourceNotFoundException {
		
		try {
			Page<Service> ListeService=iServiceMetier.getAllService(PageRequest.of(page, size));
						if(ListeService==null)
						{
							
							throw new ResourceNotFoundException("services not found");
						}
						return ListeService;
			
		} catch (Exception e) {
			throw new EntityException("Internal Server Exception while getting exception");
				}
	}

}
