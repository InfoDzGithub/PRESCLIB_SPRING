package presc_lib.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import presc_lib.dao.Historique_HospitalisationRepository;
import presc_lib.dao.PatientRepository;
import presc_lib.dao.ServiceRepository;
import presc_lib.entities.Service;

@org.springframework.stereotype.Service
public class ServiceMetierImp implements IServiceMetier{
     @Autowired
	private ServiceRepository serviceRepository;
     @Autowired
 	private Historique_HospitalisationRepository historiqueHRepository;
     @Autowired
 	private PatientRepository patientRepository;
     
	@Override
	public Service save(Service entity) {
		entity.setEtat(true);
		return serviceRepository.save(entity);
	}

	@Override
	public Service update(Long id, Service entity) {
		entity.setId(id);
		entity.setEtat(true);
		return serviceRepository.save(entity);
	}

	@Override
	public List<Service> getAll() {
		
		return serviceRepository.findActivateService();
	}

	@Override
	public Service getById(Long id) {
		return serviceRepository.findById(id).orElse(null);
	}

	@Override
	public void stop(Long id) {
		  //stop le service
		 serviceRepository.archiverService(id);
		 //stop les patient hospitalizer ds le service
		 List<Long>l=historiqueHRepository.findpatientHospInService(id);
		 System.out.print("liste"+l.size());
		 for(int i=0;i< l.size();i++)
		 {
			 patientRepository.libererPatient(l.get(i));
			 System.out.print("p"+l.get(i));
		 }
		 
		 historiqueHRepository.stopService(id);
		 //stop les user travaille dans les service
		 historiqueHRepository.releaseServicefromUser(id);
		
	}

	@Override
	public Page<Service> getAllService(Pageable p) {
		
		return serviceRepository.findAll(p);
	}

	@Override
	public void enableService(Long idS) {
		serviceRepository.enableService(idS);
		
	}

	

}
