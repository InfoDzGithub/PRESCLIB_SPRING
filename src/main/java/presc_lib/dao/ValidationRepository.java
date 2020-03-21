package presc_lib.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import presc_lib.entities.Validation;

public interface ValidationRepository extends JpaRepository<Validation, Long>
{
	@Query(value = "SELECT u FROM validation u ORDER BY date where u.id_contenu=?")
	public List<Validation> findValuesByContent(Long idC);
	
	
}