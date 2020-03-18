package presc_lib.metier;

import java.util.List;

import presc_lib.dao.ServiceRepository;
import presc_lib.entities.Service;
import presc_lib.entities.User;

public class ServiceMetierImp implements IServiceMetier{
     
	private ServiceRepository serviceRepository;
	@Override
	public Service save(Service entity) {
		
		return serviceRepository.save(entity);
	}

	@Override
	public Service update(Long id, Service entity) {
		entity.setId(id);
		return serviceRepository.save(entity);
	}

	@Override
	public List<Service> getAll() {
		
		return serviceRepository.findAll();
	}

	@Override
	public Service getById(Long id) {
		return serviceRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		 serviceRepository.archiverService(id);
		
	}

}
