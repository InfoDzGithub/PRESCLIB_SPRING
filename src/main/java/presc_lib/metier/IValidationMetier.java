package presc_lib.metier;

import java.util.List;

import org.springframework.data.repository.query.Param;

import presc_lib.entities.*;
import presc_lib.exception.EntityException;

public interface IValidationMetier extends IGenericMetier<Validation>{
    public List<Validation> getValuesByContent(Long idC);
    public List<Validation> listValidationByContenuAndFile(Long idC,Long idF)throws EntityException;
    public List<Validation> listValidationByFileCare(Long idF)throws EntityException;
	
}
