package presc_lib.metier;

import java.util.List;

import presc_lib.entities.*;

public interface IValidationMetier extends IGenericMetier<Validation>{
    public List<Validation> getValuesByContent(Long IdC);
    
}
