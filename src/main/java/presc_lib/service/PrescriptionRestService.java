package presc_lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presc_lib.entities.Prescription;
import presc_lib.metier.IPrescriptionMetier;

@RestController
public class PrescriptionRestService {
	@Autowired
   private IPrescriptionMetier iPrescriptionMetier;

   @RequestMapping(value = "/prescriptions",method = RequestMethod.POST)
public Prescription save(@RequestBody Prescription entity) {
	return iPrescriptionMetier.save(entity);
}

@RequestMapping(value = "/prescriptions/{id}",method = RequestMethod.PUT)
public Prescription update(@PathVariable Long id,@RequestBody Prescription entity) {
	return iPrescriptionMetier.update(id, entity);
}

@RequestMapping(value = "/prescriptions",method = RequestMethod.GET)
public List<Prescription> getAll() {
	return iPrescriptionMetier.getAll();
}

@RequestMapping(value = "/activatePrescriptions",method = RequestMethod.GET)
public List<Prescription> ActivatePrescription() {
	return iPrescriptionMetier.ActivatePrescription();
}

@RequestMapping(value = "/prescriptions/{id}",method = RequestMethod.GET)
public Prescription getById(@PathVariable Long id) {
	return iPrescriptionMetier.getById(id);
}

@RequestMapping(value = "/archivePrescription/{id}",method = RequestMethod.PUT)
public void stop(@PathVariable Long id) {
	iPrescriptionMetier.stop(id);
}
}
