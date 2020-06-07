package presc_lib.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.*;

public interface TraitementRepository extends JpaRepository<Traitement, Long>{

	@Query(value = "SELECT * FROM Contenu c,traitement t where c.etat=true and c.id_prescription= :idP and t.id=c.id " 
			 ,nativeQuery = true)
	public List<Traitement> findActifTraitmentByPrescription(@Param("idP") Long idP);

	
	
	
	
	@Query(value = "SELECT * FROM Contenu c,traitement t where c.id_prescription= :idP and t.id=c.id ORDER BY t.nom_traitement ",nativeQuery = true)
	public List<Traitement> findAllTraitmentByPrescription(@Param("idP") Long idP);
	
	@Transactional 
	@Modifying
	@Query(value = "update Contenu u set u.etat = false where u.id = :idT", 
	  nativeQuery = true)
	public void stopTraitement(@Param("idT")  Long idT);
	
	
}
