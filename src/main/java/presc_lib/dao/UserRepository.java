package presc_lib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import presc_lib.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query(value = "SELECT u FROM User u ORDER BY nom where u.etat=true")
	public List<User> findAllUsers();
	
	@Modifying
	@Query(value = "update User u set u.etat = false where u.id = ?", 
	  nativeQuery = true)
	public void archiverUser( Long id);
	
	
}
