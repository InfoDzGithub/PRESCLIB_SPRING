package presc_lib.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.*;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query(value = "SELECT p FROM Patient p ORDER BY nom")
	public List<Patient> findAllPatient();
	/************************************************************************************/
	@Query(value = "SELECT p FROM Patient p where p.nom like :x ORDER BY nom")
	public Page<Patient> searchPatient(@Param("x") String x,Pageable p);
	
	/*************************************************************************************/
	@Query(value = "SELECT p FROM Patient p where p.etat=true ORDER BY nom")
	public List<Patient> findHospitalizedPatient();
	/************************************************************************************/
	@Query(value = "SELECT u FROM Patient u where u.nom= :nom and u.prenom= :prenom and u.date_naissance= :dateN")
	Patient checkPatientExistenceByInfo(@Param("nom")  String nom,@Param("prenom")  String prenom,@Param("dateN")  Date date_naissance);
	/***********************************************************************************/
	
	
	/**********************************************************************************/
	@Transactional 
	@Modifying
	@Query(value = "update Patient p set p.etat = false,p.id_service=null where p.id = :idP", 
	  nativeQuery = true)
	public void libererPatient(@Param("idP")  Long idP);
	/***********************************************************************************/
	@Transactional 
	@Modifying
	@Query(value = "update Patient p set p.etat = true,p.id_service = :idS where p.id = :idP", 
	  nativeQuery = true)
	public void deLibererPatient(@Param("idP")  Long idP,@Param("idS") Long idS);
	
	
	
}
