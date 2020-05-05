package presc_lib.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	/***********************************************************************************/
	@Query(value = "SELECT * FROM Prescription p where p.id_service= :idS and p.id_patient =:idP and p.datep>= :dateE and p.datep<= :dateS",nativeQuery = true)
	public Page<Prescription> allPatientPrescriptionByService(@Param("idP")  Long idP,@Param("idS")  Long idS,@Param("dateE")Date date_entre,@Param("dateS")Date date_sortie,Pageable p);
	
	/********************************************************************************/
	@Query(value = "SELECT * FROM Prescription p where p.id_service= :idS and p.id_patient =:idP and p.datep>= :dateE",nativeQuery = true)
	public Page<Prescription> allPrescriptionInCurrentService(@Param("idP")  Long idP,@Param("idS")  Long idS,@Param("dateE")Date date_entre,Pageable p);
	
	/*******************************************************************************/
	@Transactional 
	@Modifying
	@Query(value = "update Prescription u set u.etat = false where u.id = :idP", 
	  nativeQuery = true)
	public void stopPrescription(@Param("idP")  Long idP);
	
	
}
