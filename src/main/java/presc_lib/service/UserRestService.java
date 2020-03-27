package presc_lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import presc_lib.entities.Patient;
import presc_lib.entities.Tests;
import presc_lib.entities.User;
import presc_lib.exception.EntityException;
import presc_lib.exception.ResourceNotFoundException;
import presc_lib.metier.IUserMetier;

@RestController
public class UserRestService {
	@Autowired
	private IUserMetier iUserMetier;

	@RequestMapping(value = "/users",method = RequestMethod.POST)
	public User save(@RequestBody User entity) {
		return iUserMetier.save(entity);
	}

	@RequestMapping(value = "/users/{id}",method = RequestMethod.PUT)
	public User update(@PathVariable Long id,@RequestBody User entity) {
		return iUserMetier.update(id, entity);
	}
    
	@RequestMapping(value = "/user/{idU}/service/{idS}",method = RequestMethod.POST)
	public void affecterUserToSerice(@PathVariable Long idU,@PathVariable Long idS) {
		iUserMetier.affecterUserToSerice(idU, idS);
	}

	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public List<User> getAll() {
		return iUserMetier.getAll();
	}

	@RequestMapping(value = "/user/{idU}/service/{idS}",method = RequestMethod.PUT)
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

	
	

	@RequestMapping(value = "/archiveUser/{id}",method = RequestMethod.PUT)
	public void stop(@PathVariable Long id) {
		iUserMetier.stop(id);
	}

	@RequestMapping(value = "/searchUser",method = RequestMethod.GET)
	public List<User> searchUser(@RequestParam(name="mc",defaultValue="") String mc) throws EntityException,ResourceNotFoundException {
		
		try {
			List<User> ListeUser=iUserMetier.searchUser(mc+"%");
						if(ListeUser.size()==0)
						{
							
							throw new ResourceNotFoundException("user not found");
						}
						return ListeUser;
			
		} catch (EntityException e) {
			throw new EntityException("Internal Server Exception while getting exception");
				}
	}
//http://localhost:8080/login?email=i@gmail.com&password=15kl
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

}
