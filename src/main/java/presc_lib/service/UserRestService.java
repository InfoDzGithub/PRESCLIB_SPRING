package presc_lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presc_lib.entities.User;
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
	public User getById(@PathVariable Long id) {
		return iUserMetier.getById(id);
	}

	@RequestMapping(value = "/stopUsers/{id}",method = RequestMethod.PUT)
	public void stop(@PathVariable Long id) {
		iUserMetier.stop(id);
	}

}
