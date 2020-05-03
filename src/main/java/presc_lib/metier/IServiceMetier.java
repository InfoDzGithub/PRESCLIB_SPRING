package presc_lib.metier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import presc_lib.entities.*;

public interface IServiceMetier extends IGenericMetier<Service>{
    public Page<Service>getAllService(Pageable p);
    public void enableService(Long idS);
}
