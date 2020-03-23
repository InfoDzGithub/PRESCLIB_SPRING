package presc_lib.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import presc_lib.dao.PrescriptionRepository;
import presc_lib.entities.Prescription;
@Service
public class PrescriptionMetierImp implements IPrescriptionMetier{
    @Autowired
	private PrescriptionRepository prescriptionRepository;
	@Override
	public Prescription save(Prescription entity) {
		entity.setEtat(true);
		return prescriptionRepository.save(entity);
	}

	@Override
	public Prescription update(Long id, Prescription entity) {
		entity.setId(id);
		entity.setEtat(true);
		return prescriptionRepository.save(entity);
	}

	@Override
	public List<Prescription> getAll() {
		
		return prescriptionRepository.findAll();
	}

	@Override
	public Prescription getById(Long id) {
		return prescriptionRepository.findById(id).orElse(null);
	}

	@Override
	public void stop(Long id) {
		prescriptionRepository.stopPrescription(id);
	}

	@Override
	public List<Prescription> ActivatePrescription() {
		
		return prescriptionRepository.findActivatePrescription();
	}
	

}
