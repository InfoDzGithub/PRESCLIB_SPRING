package presc_lib.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
