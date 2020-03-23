package presc_lib.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import presc_lib.dao.TraitementRepository;
import presc_lib.entities.Traitement;

@Service
public class TraitementMetierImp  implements  ITraitementMetier
{
	@Autowired
     private TraitementRepository traitementRepository;
	@Override
	public Traitement save(Traitement entity) {
		entity.setEtat(true);
		return traitementRepository.save(entity);
	}

	@Override
	public Traitement update(Long id, Traitement entity) {
		entity.setId(id);
		entity.setEtat(true);
		return traitementRepository.save(entity);
	}

	@Override
	public Traitement getById(Long idT) {
		
		return traitementRepository.findById(idT).orElse(null);
	}

	@Override
	public void stop(Long idT) {
		traitementRepository.stopTraitement(idT);
	}

	
	@Override
	public List<Traitement> getAllContentByPrescription(Long idP) {
		return traitementRepository.findTraitmentByPrescription(idP);
	}
	
	//on l'utilise pas
	@Override
	public List<Traitement> getAll() {
		
		return traitementRepository.findAll();
	}

}
