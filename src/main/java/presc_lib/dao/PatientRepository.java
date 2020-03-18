package presc_lib.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import presc_lib.entities.*;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
