package presc_lib.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import presc_lib.entities.*;

public interface ServiceRepository extends JpaRepository<Service, Long>{

	@Modifying
	@Query(value = "update Service u set u.etat = 0 where u.id = ?", 
	  nativeQuery = true)
	void archiverService( Long id);
}
