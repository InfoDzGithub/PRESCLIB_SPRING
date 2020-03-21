package presc_lib.metier;

import java.util.List;



import presc_lib.dao.UserRepository;
import presc_lib.entities.User;

public class UserMetierImp implements IUserMetier{
   
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
		return userRepository.getOne(id);
	}
	
	@Override
	public void delete(Long id)
	{
		userRepository.archiverUser(id);
	}

}
