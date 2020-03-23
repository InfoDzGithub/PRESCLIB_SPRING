package presc_lib.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.*;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query(value = "SELECT p FROM Patient p ORDER BY nom")
	public List<Patient> findAllPatient();
	/************************************************************************************/
	@Query(value = "SELECT p FROM Patient p where p.etat=true ORDER BY nom")
	public List<Patient> findHospitalizedPatient();
	/**********************************************************************************/
	@Transactional 
	@Modifying
	@Query(value = "update Patient p set p.etat = false where p.id = :idP", 
	  nativeQuery = true)
	public void libererPatient(@Param("idP")  Long idP);
	/***********************************************************************************/
	@Transactional 
	@Modifying
	@Query(value = "update Historique_Hospitalisation  h set "
			+ "h.etat = false , h.date_sortie= SYSDATE() where h.etat=true and  h.id_patient = :idP", 
	  nativeQuery = true)
	public void sortir(@Param("idP") Long idP);
	/*********************************************************************************/
	@Transactional 
	@Modifying
	@Query(
	  value = 
	    "insert into Historique_Hospitalisation (id_patient, id_service, id_medecin, num_chambre,etat,date_entre) values ( :id_patient, :id_service, :id_medecin, :num_chambre, 1, SYSDATE())",
	  nativeQuery = true)
	void affecter(@Param("id_patient") Long id_patient, @Param("id_service") Long id_service, 
	  @Param("id_medecin") Long id_medecin, @Param("num_chambre") int num_chambre);
	
	
	
	
	
}
