package presc_lib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.Validation;

public interface ValidationRepository extends JpaRepository<Validation, Long>
{
	@Query(value = "SELECT u FROM Validation u where u.id_contenu= :idC",nativeQuery = true)
	public List<Validation> findValuesByContent(@Param("idC")  Long idC);
	
	
	
}