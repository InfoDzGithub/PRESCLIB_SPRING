package presc_lib.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.Historique_Hospitalisation;
import presc_lib.entities.Service;

public interface Historique_HospitalisationRepository extends JpaRepository<Historique_Hospitalisation, Long>{ 
	
	/*********************************************************************************/
	@Transactional 
	@Modifying
	@Query(value = "update Historique_Hospitalisation  h set "
			+ "h.etat = false , h.date_sortie= SYSDATE() where h.etat=true and  h.id_patient = :idP", 
	  nativeQuery = true)
	public void sortir(@Param("idP") Long idP);
	/***************************************************************************/
	@Query(value = "SELECT id_patient FROM Historique_Hospitalisation p  where p.etat=true and p.id_service =:idS",nativeQuery = true)
	public List<Long> findpatientHospInService(@Param("idS") Long idS);
	/***************************************************************************/
	@Query(value = "SELECT p FROM Historique_Hospitalisation p  where p.etat=false and p.patient.id =:idU")
	public Page<Historique_Hospitalisation> findServicesHospByPatient(@Param("idU") Long id, Pageable p);
	
	/*********************************************************************************/
	@Transactional 
	@Modifying
	@Query(value = "update Historique_Hospitalisation  h set "
			+ "h.etat = false , h.date_sortie= SYSDATE() where h.etat=true and  h.id_service = :idS", 
	  nativeQuery = true)
	public void stopService(@Param("idS") Long idS);
	/*********************************************************************************/
	@Transactional 
	@Modifying
	@Query(value ="update User_Service u set u.etat=false , u.dateS=SYSDATE() where u.id_service= :idS and u.etat=true"
    ,nativeQuery = true)
	public void releaseServicefromUser(@Param("idS")  Long idS);
	
	/*********************************************************************************/
	/*@Transactional 
	@Modifying
	@Query(
	  value = 
	    "insert into Historique_Hospitalisation (id_patient, id_service, id_medecin, num_chambre,etat,date_entre) values ( :id_patient, :id_service, :id_medecin, :num_chambre, 1, SYSDATE())",
	  nativeQuery = true)
	void affecter(@Param("id_patient") Long id_patient, @Param("id_service") Long id_service, 
	  @Param("id_medecin") Long id_medecin, @Param("num_chambre") int num_chambre);
	
	*/
	

}
