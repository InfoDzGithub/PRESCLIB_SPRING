package presc_lib.metier;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.FicheInfirmier;
import presc_lib.entities.Prescription;
import presc_lib.exception.EntityException;

public interface IFicheInfirmierMetier extends IGenericMetier<FicheInfirmier>{
	public Page<FicheInfirmier> allCareFileByPrescription(Long idP,Pageable p)throws EntityException;
	public Page<FicheInfirmier> currentCareFileByPrescription(Long idP,Pageable p)throws EntityException;
	
}
