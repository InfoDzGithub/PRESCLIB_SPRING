package presc_lib.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import presc_lib.dao.Historique_HospitalisationRepository;
import presc_lib.dao.PatientRepository;
import presc_lib.entities.Historique_Hospitalisation;
import presc_lib.entities.Patient;

@Service
public class PatientMetierImp implements IPatientMetier{
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private Historique_HospitalisationRepository historiqueHRepository;
	
	@Override
	public Patient save(Patient entity) {
		entity.setEtat(true);
		return patientRepository.save(entity);
	}

	@Override
	public Patient update(Long id, Patient entity) {
		entity.setId(id);
		entity.setEtat(true);
		return patientRepository.save(entity);
	}

	@Override
	public List<Patient> getAll() {
		
		return patientRepository.findAllPatient();
	}

	@Override
	public Patient getById(Long id) {
		return patientRepository.findById(id).orElse(null);
	}

	@Override
	public void stop(Long id) {
		
		
	}

	@Override
	public List<Patient> hospitalizedPatient() {
		
		return patientRepository.findHospitalizedPatient();
	}

	@Override
	public void sortirPatient(Long idP) {
		historiqueHRepository.sortir(idP);
		patientRepository.libererPatient(idP);
		
	}

	@Override
	public Historique_Hospitalisation affecterPatient(Historique_Hospitalisation entity) {
		System.out.println("service  id: "+entity.getService().getId());
		patientRepository.deLibererPatient(entity.getPatient().getId(),entity.getService().getId());
		entity.setEtat(true);
		return historiqueHRepository.save(entity);
	}

	@Override
	public Historique_Hospitalisation transfererPatient(Long idP, Historique_Hospitalisation entity) {
		historiqueHRepository.sortir(idP);
		
		return affecterPatient(entity);
	}

}
