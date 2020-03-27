package presc_lib.metier;

import java.util.List;

import presc_lib.exception.EntityException;

public interface IGenericMetier<E> {
  
	public E save(E entity);
	public E update(Long id,E entity);
	public List<E> getAll() ;//throws EntityException;
	public E getById(Long id) throws EntityException;
	public void stop(Long id);
}
