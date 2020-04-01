package presc_lib.metier;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import presc_lib.dao.UserRepository;
import presc_lib.entities.Patient;
import presc_lib.entities.User;
import presc_lib.exception.EntityException;
@Service
public class UserMetierImp implements IUserMetier{
    @Autowired
	private UserRepository userRepository;
    @Autowired
    private MailService mailService;
	@Override
	public User save(User entity) {
		long code = ThreadLocalRandom.current().nextLong(10000,99999);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate= formatter.format(date);
		String password=strDate+code;
		entity.setEtat(true);
		entity.setPassword(password);
		String content="Bonjour, \n"+entity.getNom()+" "+entity.getPrenom()+"\n"+"  Voici Votre mot de passe: "+password;
		try {
			mailService.send(entity.getEmail(), "bouchekiflatifa13@gmail.com", "Envoie de mpt passe", content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRepository.save(entity);
	}

	@Override
	public User update(Long id,User entity) {
		entity.setId(id);
		entity.setEtat(true);
		return userRepository.save(entity);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAllUsers();
	}

	@Override
	public User getById(Long id) {
		//return userRepository.getOne(id);
		return userRepository.findById(id).orElse(null);
	}
	
	@Override
	public void stop(Long id)
	{
		userRepository.archiverUser(id);
	}

	@Override
	public void affecterUserToSerice(Long idU, Long idS) {
		userRepository.insertUserToServicve(idU, idS);
		
	}

	@Override
	public void stopUserFromSerice(Long idU, Long idS) {
		userRepository.stopUserfromService(idU, idS);
		
	}
	@Override
	public List<User> searchUser(String mc) {
		
		return userRepository.searchUser(mc);
	}

	@Override
	public User login(String email, String password) // throws EntityException 
	{
		String pwd="";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			pwd = (new HexBinaryAdapter()).marshal(md.digest(password.getBytes(Charset.forName("UTF-8"))));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return userRepository.login(email, pwd);
	}

    
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	
}
