package presc_lib.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.*;

public interface TraitementRepository extends JpaRepository<Traitement, Long>{
	
	@Query(value = "SELECT u FROM Traitement u where u.etat=true "
			+ " and u.id_prescription= :idP ORDER BY nom_traitement ",nativeQuery = true)
	public List<Traitement> findTraitmentByPrescription(@Param("idP") Long idP);
	
	@Transactional 
	@Modifying
	@Query(value = "update Traitement u set u.etat = false where u.id = :idT", 
	  nativeQuery = true)
	public void stopTraitement(@Param("idT")  Long idT);
	
}
