package presc_lib.metier;

import java.util.List;

public interface IContenuMetier<E> {
	public List<E> getAllContentByPrescription(Long idP);
	public List<E> getActifContentByPrescription(Long idP);
}
