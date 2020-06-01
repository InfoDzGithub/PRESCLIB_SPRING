package presc_lib.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.Contenu;

public interface ContenuRepository extends JpaRepository<Contenu, Long>{

	@Transactional 
	@Modifying
	@Query(value = "update Contenu u set u.etat = false where u.id_prescription= :idP",nativeQuery = true
	  )
	public void stopContenu(@Param("idP")  Long idP);
	
	@Transactional 
	@Modifying
	@Query(value = "update Contenu u set u.etat = false where u.id= :idC",nativeQuery = true
	  )
	public void stopContenuById(@Param("idC")  Long idP);
	
	
}
