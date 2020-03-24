package presc_lib.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import presc_lib.dao.TestRepository;
import presc_lib.entities.Tests;
@Service
public class TestMetierImp implements ITestMetier {
	@Autowired
	private TestRepository testRepository;

	@Override
	public Tests save(Tests entity) {
		entity.setEtat(true);
		return testRepository.save(entity);
	}

	@Override
	public Tests update(Long id, Tests entity) {
		entity.setId(id);
		entity.setEtat(true);
		return testRepository.save(entity);
	}

	//on l utilise pas
	@Override
	public List<Tests> getAll() {
		// TODO Auto-generated method stub
		return testRepository.findAll();
	}

	@Override
	public Tests getById(Long id) {
		return testRepository.findById(id).orElse(null);
	}

	@Override
	public void stop(Long idT) {
		testRepository.stopTests(idT);
		
	}

	@Override
	public List<Tests> getAllContentByPrescription(Long idP) {
		return testRepository.findAllTestByPrescription(idP);
	}

	@Override
	public List<Tests> getActifContentByPrescription(Long idP) {
		return testRepository.findActifTestByPrescription(idP);
	}

}
