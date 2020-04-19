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
@Query(value = "SELECT u FROM User_Service u where u.user.id= :idU")
	
	public Page<User_Service> findServicesByUser(@Param("idU")  Long id,Pageable p);
	
}
