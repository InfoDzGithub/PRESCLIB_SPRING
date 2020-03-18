package presc_lib.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import presc_lib.entities.Prescription;

public interface PrescriptionRepository extends JpaRepository<PrescriptionRepository, Long>{

}
