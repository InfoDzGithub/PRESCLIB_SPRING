package presc_lib.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import presc_lib.dao.UserRepository;
import presc_lib.entities.Patient;
import presc_lib.entities.User;
import presc_lib.exception.EntityException;
@Service
public class UserMetierImp implements IUserMetier{
    @Autowired
	private UserRepository userRepository;
	@Override
	public User save(User entity) {
		entity.setEtat(true);
		return userRepository.save(entity);
	}

	@Override
	public User update(Long id,User entity) {
		entity.setId(id);
		entity.setEtat(true);
		return userRepository.save(entity);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAllUsers();
	}

	@Override
	public User getById(Long id) {
		//return userRepository.getOne(id);
		return userRepository.findById(id).orElse(null);
	}
	
	@Override
	public void stop(Long id)
	{
		userRepository.archiverUser(id);
	}

	@Override
	public void affecterUserToSerice(Long idU, Long idS) {
		userRepository.insertUserToServicve(idU, idS);
		
	}

	@Override
	public void stopUserFromSerice(Long idU, Long idS) {
		userRepository.stopUserfromService(idU, idS);
		
	}
	@Override
	public List<User> searchUser(String mc) {
		
		return userRepository.searchUser(mc);
	}

	@Override
	public User login(String email, String password)// throws EntityException 
	{
		
		return userRepository.login(email, password);
	}


}
