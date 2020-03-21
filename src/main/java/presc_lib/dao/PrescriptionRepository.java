package presc_lib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import presc_lib.entities.*;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{

	@Query(value = "SELECT p FROM Prescription p ORDER BY date")
	public List<Prescription> findAllPrescription();
	/************************************************************************************/
	@Query(value = "SELECT p FROM Prescription p ORDER BY date where p.etat=true")
	public List<Prescription> findActivatePrescription();
	/*******************************************************************************/
	@Modifying
	@Query(value = "update Prescription u set u.etat = false where u.id = ?", 
	  nativeQuery = true)
	public void stopPrescription( Long id);
	
	
}
