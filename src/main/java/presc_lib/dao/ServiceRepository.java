package presc_lib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import presc_lib.entities.*;

public interface ServiceRepository extends JpaRepository<Service, Long>{

	@Query(value = "SELECT p FROM Service p ORDER BY nom where p.etat=true")
	public List<Service> findActivateService();
	
	@Modifying
	@Query(value = "update Service u set u.etat = false where u.id = ?", 
	  nativeQuery = true)
	void archiverService( Long id);
}
