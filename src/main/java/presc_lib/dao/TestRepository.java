package presc_lib.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.Tests;

public interface TestRepository extends JpaRepository<Tests, Long>{
	@Query(value = "SELECT t FROM Tests t ORDER BY nom_test where t.etat=true"
			+ " and t.id_prescription= :idP ",nativeQuery = true)
	public List<Tests> findTestByPrescription(@Param("idP") Long idP);
	
	@Transactional 
	@Modifying
	@Query(value = "update Tests u set u.etat = false where u.id = :idT", 
	  nativeQuery = true)
	public void stopTests(@Param("idT") Long idT);
}