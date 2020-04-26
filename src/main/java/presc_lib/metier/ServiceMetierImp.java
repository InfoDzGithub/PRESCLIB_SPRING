package presc_lib.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import presc_lib.dao.ServiceRepository;
import presc_lib.entities.Service;

@org.springframework.stereotype.Service
public class ServiceMetierImp implements IServiceMetier{
     @Autowired
	private ServiceRepository serviceRepository;
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
		 serviceRepository.archiverService(id);
		
	}

	@Override
	public Page<Service> getAllService(Pageable p) {
		
		return serviceRepository.findAll(p);
	}

}
