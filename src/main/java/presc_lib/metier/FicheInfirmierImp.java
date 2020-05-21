package presc_lib.metier;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import presc_lib.dao.FicheInfirmierRepository;
import presc_lib.entities.FicheInfirmier;
import presc_lib.entities.Prescription;
import presc_lib.exception.EntityException;

@Service
public class FicheInfirmierImp implements IFicheInfirmierMetier{
   
	@Autowired
	private FicheInfirmierRepository ficheInfirmierRepository;

	@Override
	public FicheInfirmier save(FicheInfirmier entity) {
		entity.setEtat(true);
		return ficheInfirmierRepository.save(entity);
	}

	@Override
	public FicheInfirmier update(Long id, FicheInfirmier entity) {
		entity.setId(id);
		entity.setEtat(true);
		return ficheInfirmierRepository.save(entity);
	}

	@Override
	public List<FicheInfirmier> getAll() {
		
		 return ficheInfirmierRepository.findAll();
	}

	@Override
	public FicheInfirmier getById(Long id) throws EntityException {
		
		return ficheInfirmierRepository.findById(id).orElse(null);
	}

	@Override
	public void stop(Long id) {
		
	}

	@Override
	public Page<FicheInfirmier> allCareFileByPrescription(Long idP, Pageable p) throws EntityException {
		
		Date dateE=new Date();
		//Date dateS=new Date();
		
		Date yesterday = new Date(dateE.getTime() - (1000 * 60 * 60 * 24));
		return ficheInfirmierRepository.allCareFileByPrescription(idP,yesterday,dateE,p);
	}

	@Override
	public Page<FicheInfirmier> currentCareFileByPrescription(Long idP,Pageable p) throws EntityException {
		Date dateE=new Date();
		//Date dateS=new Date();
		
		Date yesterday = new Date(dateE.getTime() - (1000 * 60 * 60 * 24));
		return ficheInfirmierRepository.currentCareFileByPrescription(idP,yesterday,dateE, p);
	}
}
