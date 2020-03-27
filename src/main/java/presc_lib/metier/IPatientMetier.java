package presc_lib.metier;

import java.util.List;

import presc_lib.entities.Historique_Hospitalisation;
import presc_lib.entities.Patient;
import presc_lib.exception.EntityException;

public interface IPatientMetier extends IGenericMetier<Patient>{
    
	public void sortirPatient(Long idP);
    public Historique_Hospitalisation affecterPatient(Historique_Hospitalisation entity);
    public Historique_Hospitalisation transfererPatient(Long idP,Historique_Hospitalisation entity);
    public List<Patient> hospitalizedPatient();
    public List<Patient> searchPatient(String mc) throws EntityException;
}
