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
	//tt les prescription in periode D'hospitalisation
	@Query(value = "SELECT * FROM Prescription p where  p.id_patient=:idP and p.datep>= :dateE and p.datep<= :dateS",nativeQuery = true)
	public Page<Prescription> allPatientPrescriptionByService(@Param("idP")  Long idP,@Param("dateE")Date date_entre,@Param("dateS")Date date_sortie,Pageable p);
	
	/***********************************************************************************/
	//nbre prescription actif par hospitalisation
	@Query(value = "SELECT count(*) FROM Prescription p where  p.id_patient =:idP and p.etat=true and p.datep>= :dateE and p.datep<= :dateS",nativeQuery = true)
	public int nbrePatientPrescriptionByHosp(@Param("idP")  Long idP,@Param("dateE")Date date_entre,@Param("dateS")Date date_sortie);
	/***************************************************************************************/
	@Query(value = "SELECT count(*) FROM Prescription p where  p.id_patient =:idP and p.etat=true",nativeQuery = true)
	public int nbrePrescriptionActifParPAtient(@Param("idP")  Long idP);
	/*****************************************************************************************/
	@Query(value = "SELECT p FROM Prescription p where  p.patient.id =:idP and p.etat=true ORDER BY dateP")
	public Page<Prescription> ListprescriptionActifByPatient(@Param("idP")  Long idP, Pageable p);
	/********************************************************************************/
	@Query(value = "SELECT * FROM Prescription p where p.id_patient =:idP and p.datep>= :dateE",nativeQuery = true)
	public Page<Prescription> allPrescriptionInCurrentService(@Param("idP")  Long idP,@Param("dateE")Date date_entre,Pageable p);
	/*****************************************************************************/
	@Query(value = "SELECT * FROM Prescription p where p.id_patient =:idP and p.etat=true",nativeQuery = true)
	public List<Prescription> listPrescByPatient(@Param("idP")  Long idP);
	
	/********************************Stop les prescriptions par patient***********************************************/
	@Transactional 
	@Modifying
	@Query(value = "update Prescription u set u.etat = false where u.id_patient= :idP",nativeQuery = true
	  )
	public void stopPrescription(@Param("idP")  Long idP);
	
	/***********************************************************************************/
	
	@Transactional 
	@Modifying
	@Query(value = "update Prescription u set u.etat = false where u.id= :id",nativeQuery = true
	  )
	public void archivePresc(@Param("id")  Long id);
	
	
	
}
