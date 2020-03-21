package presc_lib.metier;

import java.util.List;

import presc_lib.dao.TraitementRepository;
import presc_lib.entities.Traitement;

public class TraitementMetierImp  implements  ITraitementMetier
{
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
		
		return traitementRepository.getOne(idT);
	}

	@Override
	public void delete(Long idT) {
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
