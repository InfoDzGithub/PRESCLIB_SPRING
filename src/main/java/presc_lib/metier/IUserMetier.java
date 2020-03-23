package presc_lib.metier;

import presc_lib.entities.User;

public interface IUserMetier extends IGenericMetier<User>
{

	public void affecterUserToSerice(Long idU,Long idS);
	public void stopUserFromSerice(Long idU,Long idS);
}
