package presc_lib.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import presc_lib.entities.Patient;
import presc_lib.entities.Tests;
import presc_lib.entities.User;
import presc_lib.entities.User_Service;
import presc_lib.exception.EntityException;
import presc_lib.exception.ResourceNotFoundException;
import presc_lib.metier.IUserMetier;
import presc_lib.metier.MailService;

@RestController
@CrossOrigin("*")
public class UserRestService {
	@Autowired
	private IUserMetier iUserMetier;

	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/users",method = RequestMethod.POST)
	public User save(@RequestBody User entity) throws ResourceNotFoundException {
		
		
			boolean checkUser=iUserMetier.checkExistanceUserInfo(entity.getEmail(), entity.getNom(), entity.getPrenom(), entity.getDate_naissance());
						if(checkUser)
						{
							
							throw new ResourceNotFoundException("User already existe found");
						}
						return iUserMetier.save(entity);
			
		
	}

	@RequestMapping(value = "/users/{id}",method = RequestMethod.PUT)
	public User update(@PathVariable Long id,@RequestBody User entity) throws ResourceNotFoundException 
	{
		boolean checkUser=iUserMetier.nbreUserWithEmail(entity,id);
		if(!checkUser)
		{
			
			throw new ResourceNotFoundException("User already existe found");
		}
		return iUserMetier.update(id, entity);
	}
    
	@RequestMapping(value = "/user/{idU}/service/{idS}",method = RequestMethod.GET)
	public void affecterUserToSerice(@PathVariable Long idU,@PathVariable Long idS) {
		iUserMetier.affecterUserToSerice(idU, idS);
	}

	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public List<User> getAll() {
		return iUserMetier.getAll();
	}
	
	
	@PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
      iUserMetier.uploadPhoto(file, id);
    }
    
	@GetMapping(path="/photoUser/{id}",produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
		return iUserMetier.getPhoto(id);
	}
	
	
	
	@RequestMapping(value = "/releaseUser/{idU}/FromService/{idS}",method = RequestMethod.GET)
	public void stopUserFromSerice(@PathVariable Long idU,@PathVariable Long idS) {
		iUserMetier.stopUserFromSerice(idU, idS);
	}
    
	@RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
	public User getById(@PathVariable Long id) throws EntityException,ResourceNotFoundException {
		try {
			User user=iUserMetier.getById(id);
						if(user==null)
						{
							
							throw new ResourceNotFoundException("User not found");
						}
						return user;
			
		} catch (EntityException e) {
			throw new EntityException("Internal Server Exception while getting exception");
				}
	}

	
	

	@RequestMapping(value = "/archiveUser/{id}",method = RequestMethod.DELETE)
	public boolean stop(@PathVariable Long id) {
		
		iUserMetier.stop(id);
		return true;
	}
	
	@RequestMapping(value = "/enableUser/{id}",method = RequestMethod.GET)
	public boolean enableUser(@PathVariable Long id) {
		iUserMetier.enableUser(id);
		return true;
		
	}
    
	@RequestMapping(value = "/searchUserByEmail",method = RequestMethod.GET)
	public User findUserByEmail(@RequestParam(name="email") String email) throws EntityException {
		return iUserMetier.findUserByEmail(email);
	}
	@RequestMapping(value = "/searchUser",method = RequestMethod.GET)
	public Page<User> searchUser(
			@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size) throws EntityException,ResourceNotFoundException {
		
		try {
			Page<User> ListeUser=iUserMetier.searchUser(mc+"%",  PageRequest.of(page, size));
						if(ListeUser==null)
						{
							
							throw new ResourceNotFoundException("user not found");
						}
						return ListeUser;
			
		} catch (EntityException e) {
			throw new EntityException("Internal Server Exception while getting exception");
				}
	}

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public User login(@RequestParam(name="email") String email,@RequestParam(name="password") String password) throws EntityException,ResourceNotFoundException {
		
		try {
			User user=iUserMetier.login(email,password);
						if(user==null)
						{
							
							throw new ResourceNotFoundException("login or password not correct");
						}
						System.out.println("NOM:"+user.getNom());
						return user;
			
		} catch (EntityException e) {
			throw new EntityException("Internal Server Exception while getting exception");
				}
	}

	@RequestMapping(value = "/forgetPassword",method = RequestMethod.GET)
    public void forgetPassword(@RequestParam(name="email")  String email) throws Exception
    {
    	
    	try {
    		User user= iUserMetier.findUserByEmail(email);
						if(user==null)
						{
							
							throw new ResourceNotFoundException("You haven't account sorry!");
						}
						
						System.out.print("hh");
                         String content="Bonjour "+user.getNom() +"Votre password perdu: "+user.getPassword();
                        
						mailService.send(user.getEmail(), "a.presclib@gmail.com", "Recuperation de mot de passe oublier", content);
						 
			
		} catch (EntityException e) {
			throw new EntityException("Internal Server Exception while getting exception");
				}
    }


	@RequestMapping(value = "/releaseUserFromAllActifService/{id}",method = RequestMethod.GET)
	public void releaseUserFromService(@PathVariable Long id) 
	{
		 iUserMetier.releaseUserFromService(id);
	}
	

	
//sous forme page
	@RequestMapping(value = "/servicesOccupiedByUser",method = RequestMethod.GET)
	public Page<User_Service> servicesOccupiedByUser(
			@RequestParam(name="id") Long id,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="3") int size) throws EntityException,ResourceNotFoundException {
		
		try {
			Page<User_Service> Liste=iUserMetier.findServicesByUser(id, PageRequest.of(page, size));
						if(Liste==null)
						{
							
							throw new ResourceNotFoundException("services not found");
						}
						return Liste;
			
		} catch (EntityException e) {
			throw new EntityException("Internal Server Exception while getting exception");
				}
	}
//sous forme liste
	@RequestMapping(value = "/ListServicesOccupiedByUser",method = RequestMethod.GET)
	public List<User_Service> servicesOccupiedByUserL(
			@RequestParam(name="id") Long id) throws EntityException,ResourceNotFoundException {
		
		try {
			List<User_Service> Liste=iUserMetier.findServicesByUserL(id);
						if(Liste==null)
						{
							
							throw new ResourceNotFoundException("not yet Affected");
						}
						return Liste;
			
		} catch (EntityException e) {
			throw new EntityException("Internal Server Exception while getting exception");
				}
	}
	
	
	
	@RequestMapping(value = "/historiqueServicesOccupiedByUser",method = RequestMethod.GET)
	public Page<User_Service> historiueServicesOccupiedByUser(
			@RequestParam(name="id") Long id,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="3") int size) throws EntityException,ResourceNotFoundException {
		
		try {
			Page<User_Service> Liste=iUserMetier.findHistoriqueServicesByUser(id, PageRequest.of(page, size));
						if(Liste==null)
						{
							
							throw new ResourceNotFoundException("services not found");
						}
						return Liste;
			
		} catch (EntityException e) {
			throw new EntityException("Internal Server Exception while getting exception");
				}
	}

	@RequestMapping(value = "/doctorsOFSelectedService",method = RequestMethod.GET)
	public List<User_Service> findDoctorsOfServiceSelected(
			@RequestParam(name="id") Long id) throws EntityException,ResourceNotFoundException {
		
		try {
			List<User_Service> Liste=iUserMetier.findDoctorsOfServiceSelected(id);
						if(Liste==null)
						{
							
							throw new ResourceNotFoundException("any doctors is found");
						}
						return Liste;
			
		} catch (Exception e) {
			throw new EntityException("Internal Server Exception while getting exception");
				}
	}



}
