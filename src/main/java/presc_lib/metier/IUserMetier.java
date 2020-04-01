package presc_lib.metier;

import java.util.List;
import java.util.Optional;

import presc_lib.entities.User;
import presc_lib.exception.EntityException;

public interface IUserMetier extends IGenericMetier<User>
{

	public void affecterUserToSerice(Long idU,Long idS);
	public void stopUserFromSerice(Long idU,Long idS);
	public List<User> searchUser(String mc) throws EntityException;
	public User login(String email,String password) throws EntityException;
	public User findUserByEmail(String email)throws EntityException;
    
}