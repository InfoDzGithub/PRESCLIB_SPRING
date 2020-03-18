package presc_lib.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import presc_lib.entities.Contenu;

public interface ContenuRepository extends JpaRepository<Contenu, Long>{

}
