package presc_lib.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import presc_lib.dao.ContenuRepository;
import presc_lib.dao.Historique_HospitalisationRepository;
import presc_lib.dao.PatientRepository;
import presc_lib.dao.PrescriptionRepository;
import presc_lib.entities.Historique_Hospitalisation;
import presc_lib.entities.Patient;
import presc_lib.entities.Prescription;
import presc_lib.exception.EntityException;

@Service
public class PatientMetierImp implements IPatientMetier{
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private Historique_HospitalisationRepository historiqueHRepository;
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	@Autowired
	private ContenuRepository contenuRepository;
	
	
	
	@Override
	public Patient save(Patient entity) {
		entity.setEtat(false);
		return patientRepository.save(entity);
	}

	@Override
	public Patient update(Long id, Patient entity) {
		entity.setId(id);
		//entity.setEtat(true);
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
		prescriptionRepository.stopPrescription(idP);
		
		List<Prescription> l=prescriptionRepository.listPrescByPatient(idP);
		for(int i=0;i<l.size();i++)
		{
			Long id=l.get(i).getId();
			
			contenuRepository.stopContenu(id);}
		
		
		
	}

	@Override
	public Historique_Hospitalisation affecterPatient(Historique_Hospitalisation entity) {
		//System.out.println("service  id: "+entity.getService().getId());
		
		patientRepository.deLibererPatient(entity.getPatient().getId(),entity.getService().getId());
		entity.setEtat(true);
		entity.setDate_entre(new Date());
		
				Historique_Hospitalisation a=historiqueHRepository.save(entity);
				
				return  a;
	
	}

	@Override
	public Historique_Hospitalisation transfererPatient(Long idP, Historique_Hospitalisation entity) {
		historiqueHRepository.sortir(idP);
		
		return affecterPatient(entity);
	}

	@Override
	public Page<Patient> searchPatient(String mc,Pageable p) {
		
		return patientRepository.searchPatient(mc,p);
	}

	@Override
	public Page<Historique_Hospitalisation> serviceHospitalizedByPatient(Long idP, Pageable p) throws EntityException {
		
		Page<Historique_Hospitalisation>u=historiqueHRepository.findServicesHospByPatient(idP,p);
		
		return u;
	}
	
	@Override
	 public boolean checkExistancePatientInfo(String nom,String prenom,Date dateN){
		
		Patient u= patientRepository.checkPatientExistenceByInfo(nom, prenom, dateN);
		if(u!=null)
			return true;//il ya
		else return false;// il ya pas
		
	}

	@Override
	public Historique_Hospitalisation findCurrentServicesInByPatient(Long idP) throws EntityException {
		
		return historiqueHRepository.findCurrentServicesInByPatient(idP);
	}

	@Override
	public Historique_Hospitalisation getOne(Long idH) throws EntityException {
		// TODO Auto-generated method stub
		return historiqueHRepository.findById(idH).orElse(null);
	}

	@Override
	public Page<Historique_Hospitalisation> PatientActifParUserAcess(Long idU, Pageable p) throws EntityException {
		
		return historiqueHRepository.PatientActifParUserAcess(idU, p);
	}

}
