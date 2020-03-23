package presc_lib.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.*;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{
//ORDER BY dateP
	@Query(value = "SELECT p FROM Prescription p ORDER BY dateP")
	public List<Prescription> findAllPrescription();
	/************************************************************************************/
	@Query(value = "SELECT p FROM Prescription p where p.etat=true ORDER BY dateP")
	public List<Prescription> findActivatePrescription();
	/*******************************************************************************/
	@Transactional 
	@Modifying
	@Query(value = "update Prescription u set u.etat = false where u.id = :idP", 
	  nativeQuery = true)
	public void stopPrescription(@Param("idP")  Long idP);
	
	
}
