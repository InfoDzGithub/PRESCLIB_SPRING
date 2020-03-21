package presc_lib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import presc_lib.entities.*;

public interface TraitementRepository extends JpaRepository<Traitement, Long>{
	@Query(value = "SELECT u FROM Traitement u ORDER BY nom_traitement where u.etat=true"
			+ " and u.id_prescription=? ")
	public List<Traitement> findTraitmentByPrescription(Long idP);
	
	
	@Modifying
	@Query(value = "update Traitement u set u.etat = false where u.id = ?", 
	  nativeQuery = true)
	public void stopTraitement( Long idT);
	
}
