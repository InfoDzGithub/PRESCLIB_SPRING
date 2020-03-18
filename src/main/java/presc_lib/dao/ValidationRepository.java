package presc_lib.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import presc_lib.entities.Validation;

public interface ValidationRepository extends JpaRepository<Validation, Long>{

}
