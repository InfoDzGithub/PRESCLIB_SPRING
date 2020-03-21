package presc_lib.metier;

import java.util.List;

import presc_lib.dao.PatientRepository;
import presc_lib.entities.Patient;


public class PatientMetierImp implements IPatientMetier{
	private PatientRepository patientRepository;
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
		return patientRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		
		
	}

	@Override
	public void sortirPatient(Long id) {
		patientRepository.sortir(id);
		patientRepository.libererPatient(id);
	}

	@Override
	public void affecterPatient(Long idP, Long idS, Long idM, int num_chambre) {
		patientRepository.affecter(idP, idS, idM, num_chambre);
		
	}

	@Override
	public void transfererPatient(Long idP, Long idS, Long idM, int num_chambre) {
		sortirPatient( idP);
		affecterPatient(idP,idS, idM,num_chambre);
		
	}

	@Override
	public List<Patient> hospitalizedPatient() {
		
		return patientRepository.findHospitalizedPatient();
	}

}
