package presc_lib.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.FicheInfirmier;
public interface FicheInfirmierRepository extends JpaRepository<FicheInfirmier, Long>{

	@Query(value = "SELECT * FROM fiche_infirmier p where  p.id_prescription=:idP and p.etat=true and p.datef NOT BETWEEN :dateE AND  :dateS",nativeQuery = true)
	public Page<FicheInfirmier> allCareFileByPrescription(@Param("idP")  Long idP,@Param("dateE")Date date_entre,@Param("dateS")Date date_sortie,Pageable p);
	/**********************************************************************************
	 * and p.datef NOT BETWEEN :dateE AND  :dateS
	 * @Param("dateE")Date date_entre,@Param("dateS")Date date_sortie,
	 */
	/***********************************************************************************/
	
	@Query(value = "SELECT * FROM fiche_infirmier p where  p.id_prescription =:idP and p.etat=true and p.datef BETWEEN :dateE  AND  :dateS",nativeQuery = true)
	public Page<FicheInfirmier> currentCareFileByPrescription(@Param("idP")  Long idP,@Param("dateE")Date date_entre,@Param("dateS")Date date_sortie,Pageable p);
	/***************************************************************************************/

	@Transactional
	@Modifying
    @Query(value = "update fiche_infirmier u set u.etat = false  where u.id = :idU"
	,nativeQuery = true)
	public void archiverFile(@Param("idU")  Long id);

/*****************************************************************************************/
	@Query(value = "SELECT * FROM fiche_infirmier p where  p.etat=true and p.datef NOT BETWEEN :dateE AND  :dateS and p.id_patient in (select id_patient from Historique_Hospitalisation h where h.etat=true and h.id_service in (select id_service from User_Service u where u.etat=true and u.id_user= :idU))",nativeQuery = true)
	public Page<FicheInfirmier> fileCareHasProb(@Param("idU")  Long idU,@Param("dateE")Date date_entre,@Param("dateS")Date date_sortie,Pageable p);

/*******************************************************************************************/
	@Transactional
	@Modifying
    @Query(value = "update fiche_infirmier u set u.etat = false  where u.id_patient = :idP"
	,nativeQuery = true)
	public void archiverFilesByPatient(@Param("idP")  Long idP);

/**********************************************************************************/
	@Transactional 
	@Modifying
    @Query(value = "update fiche_infirmier u set u.etat = false  where u.id_prescription = :idP"
	,nativeQuery = true)
	public void archiverFilesByPresc(@Param("idP")  Long idP);

/**********************************************************************/

	@Query(value = "SELECT p FROM FicheInfirmier p where  p.prescription.id= :idP")
	public Page<FicheInfirmier> fileCareByPresc(@Param("idP")  Long idP,Pageable p);

	
	
}
