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

import presc_lib.entities.FicheInfirmier;
import presc_lib.entities.Prescription;
import presc_lib.exception.EntityException;
import presc_lib.exception.ResourceNotFoundException;
import presc_lib.metier.IFicheInfirmierMetier;

@RestController
@CrossOrigin("*")
public class FicheInfirmierRestService {

	@Autowired
	   private IFicheInfirmierMetier iFicheInfirmierMetier;

	@RequestMapping(value = "/ficheInfirmiers",method = RequestMethod.POST)
	public FicheInfirmier save(@RequestBody FicheInfirmier entity) {
		return iFicheInfirmierMetier.save(entity);
	}
	@RequestMapping(value = "/ficheInfirmiers/{id}",method = RequestMethod.PUT)
	public FicheInfirmier update(@PathVariable Long id, @RequestBody FicheInfirmier entity) {
		return iFicheInfirmierMetier.update(id, entity);
	}

	@RequestMapping(value = "/ficheInfirmiers",method = RequestMethod.GET)
	public List<FicheInfirmier> getAll() {
		return iFicheInfirmierMetier.getAll();
	}
	@RequestMapping(value = "/ficheInfirmiers/{id}",method = RequestMethod.GET)
	public FicheInfirmier getById(@PathVariable Long id) throws EntityException {
		return iFicheInfirmierMetier.getById(id);
	}

	@RequestMapping(value = "/stopFicheInfirmiers/{id}",method = RequestMethod.GET)
	public void stop(@PathVariable Long id) {
		iFicheInfirmierMetier.stop(id);
	}

	@RequestMapping(value = "/allActifCareFileByPrescription",method = RequestMethod.GET)
	public Page<FicheInfirmier> allCareFileByPrescription(
			@RequestParam(name="id") Long id,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size)throws EntityException,ResourceNotFoundException {
		
		 try {
			 Page<FicheInfirmier> presc=iFicheInfirmierMetier.allCareFileByPrescription(id,PageRequest.of(page, size));
							if(presc==null)
							{
								
								throw new ResourceNotFoundException("has no actif care file yet ");
							}
							return presc;
				
			} catch (EntityException e) {
				throw new EntityException("Internal Server Exception while getting exception");
					}
	}
	
	@RequestMapping(value = "/currentCareFileByPrescription",method = RequestMethod.GET)
	public Page<FicheInfirmier> currentCareFileByPrescription(
			@RequestParam(name="id") Long id,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size)throws EntityException,ResourceNotFoundException {
		
		 try {
			 Page<FicheInfirmier> presc=iFicheInfirmierMetier.currentCareFileByPrescription(id,PageRequest.of(page, size));
							if(presc==null)
							{
								
								throw new ResourceNotFoundException("has no actif care file yet ");
							}
							return presc;
				
			} catch (EntityException e) {
				throw new EntityException("Internal Server Exception while getting exception");
					}
	}
	
	@RequestMapping(value = "/archiveFile",method = RequestMethod.GET)
	public void archiveFile(
			@RequestParam(name="id") Long id )throws EntityException,ResourceNotFoundException {
		
		 try {
			 FicheInfirmier f=iFicheInfirmierMetier.getById(id);
							if(f==null)
							{
								
								throw new ResourceNotFoundException("no file found ");
							}
							iFicheInfirmierMetier.archiveFile(id);
				
			} catch (EntityException e) {
				throw new EntityException("Internal Server Exception while getting exception");
					}
	}
	
	
	@RequestMapping(value = "/fileAreNotComplete",method = RequestMethod.GET)
	public Page<FicheInfirmier> fileHaseProb(
			@RequestParam(name="id") Long id ,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="3") int size)throws EntityException,ResourceNotFoundException {
		
		 try {
			 Page<FicheInfirmier> f=iFicheInfirmierMetier.fileCareHasProb(id, PageRequest.of(page, size));
							if(f==null)
							{
								
								throw new ResourceNotFoundException("no file found ");
							}
							return f;
				
			} catch (EntityException e) {
				throw new EntityException("Internal Server Exception while getting exception");
					}
	}
	
	
	
	@RequestMapping(value = "/fileCareByPresc",method = RequestMethod.GET)
	public Page<FicheInfirmier> fileCareByPresc(
			@RequestParam(name="id") Long id ,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="3") int size)throws EntityException,ResourceNotFoundException {
		
		 try {
			 Page<FicheInfirmier> f=iFicheInfirmierMetier.fileCareByPresc(id, PageRequest.of(page, size));
							if(f==null)
							{
								
								throw new ResourceNotFoundException("no file found ");
							}
							return f;
				
			} catch (EntityException e) {
				throw new EntityException("Internal Server Exception while getting exception");
					}
	}
}
