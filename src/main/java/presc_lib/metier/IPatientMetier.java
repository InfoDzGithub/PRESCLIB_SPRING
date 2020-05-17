 package presc_lib.metier;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.Historique_Hospitalisation;
import presc_lib.entities.Patient;
import presc_lib.exception.EntityException;

public interface IPatientMetier extends IGenericMetier<Patient>{
    
	public void sortirPatient(Long idP);
    public Historique_Hospitalisation affecterPatient(Historique_Hospitalisation entity);
    public Historique_Hospitalisation transfererPatient(Long idP,Historique_Hospitalisation entity);
    public List<Patient> hospitalizedPatient();
    public Page<Patient> searchPatient(String mc,Pageable p) throws EntityException;
    public Page<Historique_Hospitalisation> serviceHospitalizedByPatient(Long idP,Pageable p) throws EntityException;
    public boolean checkExistancePatientInfo(String nom,String prenom,Date dateN);
    public Historique_Hospitalisation findCurrentServicesInByPatient(Long idP)throws EntityException;;
    public Historique_Hospitalisation getOne(Long idH)throws EntityException;
    public Page<Historique_Hospitalisation> PatientActifParUserAcess(Long idU,Pageable p) throws EntityException;

}
