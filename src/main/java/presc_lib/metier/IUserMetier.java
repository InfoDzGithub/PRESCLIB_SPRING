package presc_lib.metier;



import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import presc_lib.entities.User;
import presc_lib.entities.User_Service;
import presc_lib.exception.EntityException;

public interface IUserMetier extends IGenericMetier<User>
{

	public void affecterUserToSerice(Long idU,Long idS);
	public void stopUserFromSerice(Long idU,Long idS);
	//public List<User> searchUser(String mc) throws EntityException;
	public Page<User> searchUser(String mc, Pageable p) throws EntityException;
	public User login(String email,String password) throws EntityException;
	public User findUserByEmail(String email)throws EntityException;
	public void enableUser(Long idU);
	public void releaseUserFromService(Long idU);
	public Page<User_Service> findServicesByUser(Long idU,Pageable p) throws EntityException;
	public List<User_Service> findServicesByUserL(Long idU) throws EntityException;
	public Page<User_Service> findHistoriqueServicesByUser(Long idU,Pageable p) throws EntityException;
    //public boolean checkExistanceUserEmail(String email);
    public boolean checkExistanceUserInfo(String email,String nom,String prenom,Date dateN);
    public boolean nbreUserWithEmail(User u,Long id);
    public void uploadPhoto(MultipartFile p,Long id) throws Exception;
    public byte[] getPhoto(Long id) throws Exception;
    //select tous les medecin d'un service selectionné
    public List<User_Service> findDoctorsOfServiceSelected(Long idS);
    
  
    


}