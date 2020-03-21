package presc_lib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import presc_lib.entities.Tests;

public interface TestRepository extends JpaRepository<Tests, Long>{
	@Query(value = "SELECT t FROM Tests t ORDER BY nom_test where t.etat=true"
			+ " and t.id_prescription=? ")
	public List<Tests> findTestByPrescription(Long idP);
	
	
	@Modifying
	@Query(value = "update Tests u set u.etat = false where u.id = ?", 
	  nativeQuery = true)
	public void stopTests( Long idT);
}