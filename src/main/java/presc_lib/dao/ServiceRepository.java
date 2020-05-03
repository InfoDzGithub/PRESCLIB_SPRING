package presc_lib.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.*;

public interface ServiceRepository extends JpaRepository<Service, Long>{

	@Query(value = "SELECT p FROM Service p  where p.etat=true ORDER BY nom")
	public List<Service> findActivateService();
	
	@Transactional 
	@Modifying
	@Query(value = "update Service u set u.etat = false where u.id = :idS", 
	  nativeQuery = true)
	void archiverService(@Param("idS")  Long idS);
	
	@Transactional 
	@Modifying
	@Query(value = "update Service u set u.etat = true where u.id = :idS", 
	  nativeQuery = true)
	void enableService(@Param("idS")  Long idS);
}
