package presc_lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import presc_lib.entities.Historique_Hospitalisation;
import presc_lib.entities.Patient;
import presc_lib.entities.Prescription;
import presc_lib.exception.EntityException;
import presc_lib.exception.ResourceNotFoundException;
import presc_lib.metier.IPatientMetier;

@RestController
@CrossOrigin("*")
public class PatientRestService {
	@Autowired
  private IPatientMetier iPatientMetier;

@RequestMapping(value = "/patients",method = RequestMethod.POST)
public Patient save(@RequestBody Patient entity) {
	return iPatientMetier.save(entity);
}

@RequestMapping(value = "/patients/{id}",method = RequestMethod.PUT)
public Patient update(@PathVariable Long id,@RequestBody Patient entity) {
	return iPatientMetier.update(id, entity);
}

@RequestMapping(value = "/patients",method = RequestMethod.GET)
public List<Patient> getAll() {
	return iPatientMetier.getAll();
}


@RequestMapping(value = "/searchPatient",method = RequestMethod.GET)
public List<Patient> searchPatient(@RequestParam(name="mc",defaultValue="") String mc) throws EntityException,ResourceNotFoundException {
	
	try {
		List<Patient> Listepatient=iPatientMetier.searchPatient(mc+"%");
					if(Listepatient.size()==0)
					{
						
						throw new ResourceNotFoundException("patient not found");
					}
					return Listepatient;
		
	} catch (EntityException e) {
		throw new EntityException("Internal Server Exception while getting exception");
			}
}



@RequestMapping(value = "/exitPatient/{id}",method = RequestMethod.PUT)
public void sortirPatient(@PathVariable Long id) {
	iPatientMetier.sortirPatient(id);
}

@RequestMapping(value = "/patients/{id}",method = RequestMethod.GET)
public Patient getById(@PathVariable Long id) throws EntityException,ResourceNotFoundException {
	try {
		Patient patient=iPatientMetier.getById(id);
					if(patient==null)
					{
						
						throw new ResourceNotFoundException("patient not found");
					}
					return patient;
		
	} catch (EntityException e) {
		throw new EntityException("Internal Server Exception while getting exception");
			}
}


@RequestMapping(value = "/affectPatient",method = RequestMethod.POST)
public Historique_Hospitalisation affecterPatient(@RequestBody Historique_Hospitalisation entity)  {
	
	return iPatientMetier.affecterPatient(entity);
}

//do anything
@RequestMapping(value = "/archivePatient/{id}",method = RequestMethod.PUT)
public void stop(@PathVariable Long id) {
	iPatientMetier.stop(id);
}

@RequestMapping(value = "/transfertPatient/{idP}",method = RequestMethod.POST)
public Historique_Hospitalisation transfererPatient(@PathVariable Long idP,@RequestBody Historique_Hospitalisation entity) {
	return iPatientMetier.transfererPatient(idP, entity);
}

@RequestMapping(value = "/hospitalPatients",method = RequestMethod.GET)
public List<Patient> hospitalizedPatient() {
	return iPatientMetier.hospitalizedPatient();
}


}
