package presc_lib.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query(value = "SELECT u FROM User u where u.etat=true ORDER BY nom")
	public List<User> findAllUsers();
	
	@Transactional 
	@Modifying
	@Query(value = "update User u set u.etat = false where u.id = :idU"
	,nativeQuery = true)
	public void archiverUser(@Param("idU")  Long id);
	
	@Transactional 
	@Modifying
	@Query(value ="insert into User_Service (id_user, id_service, etat, dateE) values ( :idU, :idS,true,SYSDATE())"
    ,nativeQuery = true)
	public void insertUserToServicve(@Param("idU")  Long idU,@Param("idS")  Long idS);
	
	@Transactional 
	@Modifying
	@Query(value ="update User_Service u set u.etat=false , u.dateS=SYSDATE() where u.id_user= :idU and u.id_service= :idS and u.etat=true"
    ,nativeQuery = true)
	public void stopUserfromService(@Param("idU")  Long idU,@Param("idS")  Long idS);
	
}


