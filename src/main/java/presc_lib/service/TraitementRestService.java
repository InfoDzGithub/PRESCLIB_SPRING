package presc_lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presc_lib.entities.Traitement;
import presc_lib.metier.ITraitementMetier;

@RestController
public class TraitementRestService {
	@Autowired
	private ITraitementMetier iTraitementMetier;

	@RequestMapping(value = "/traitementsByprescription/{idP}",method = RequestMethod.GET)
	public List<Traitement> getAllContentByPrescription(@PathVariable Long idP) {
		return iTraitementMetier.getAllContentByPrescription(idP);
	}

	@RequestMapping(value = "/actifTraitementsByPrescription/{idP}",method = RequestMethod.GET)
	public List<Traitement> getActifContentByPrescription(@PathVariable Long idP) {
		return iTraitementMetier.getActifContentByPrescription(idP);
	}
	
	@RequestMapping(value = "/traitements",method = RequestMethod.POST)
	public Traitement save(@RequestBody Traitement entity) {
		return iTraitementMetier.save(entity);
	}

	@RequestMapping(value = "/traitements/{id}",method = RequestMethod.PUT)
	public Traitement update(@PathVariable Long id,@RequestBody Traitement entity) {
		return iTraitementMetier.update(id, entity);
	}

	//tous les traitement actif & inactif 
	@RequestMapping(value = "/allTraitements",method = RequestMethod.GET)
	public List<Traitement> getAll() {
		return iTraitementMetier.getAll();
	}

	@RequestMapping(value = "/traitements/{id}",method = RequestMethod.GET)
	public Traitement getById(@PathVariable Long id) {
		return iTraitementMetier.getById(id);
	}

	@RequestMapping(value = "/stopTraitement/{id}",method = RequestMethod.PUT)
	public void stop(@PathVariable Long id) {
		iTraitementMetier.stop(id);
	}
}
