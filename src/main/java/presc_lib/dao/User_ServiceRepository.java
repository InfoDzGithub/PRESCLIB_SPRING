package presc_lib.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.User;
import presc_lib.entities.User_Service;



public interface User_ServiceRepository extends JpaRepository<User_Service, Long>
{
@Query(value = "SELECT u FROM User_Service u where u.user.id= :idU and u.etat=true")
	
	public Page<User_Service> findServicesByUser(@Param("idU")  Long id,Pageable p);
	
//list
@Query(value = "SELECT u FROM User_Service u where u.user.id= :idU and u.etat=true")
	
	public List<User_Service> findServicesByUserL(@Param("idU")  Long id);
	

@Query(value = "SELECT u FROM User_Service u where u.user.id= :idU and u.etat=false")
	
	public Page<User_Service> findHistoriqueServicesByUser(@Param("idU")  Long id,Pageable p);

@Query(value = "SELECT u FROM User_Service u where u.service.id= :idS and u.user.role='medecin' and u.user.etat=true and u.etat=true")
	
	public List<User_Service> findDoctorsOfServiceSelected(@Param("idS")  Long id);
	

}
