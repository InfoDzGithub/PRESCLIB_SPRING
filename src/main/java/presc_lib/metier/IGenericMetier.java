package presc_lib.metier;

import java.util.List;

public interface IGenericMetier<E> {
  
	public E save(E entity);
	public E update(Long id,E entity);
	public List<E> getAll();
	public E getById(Long id);
	public void stop(Long id);
}
