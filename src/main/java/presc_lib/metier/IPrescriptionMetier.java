package presc_lib.metier;

import java.util.List;

import presc_lib.entities.Prescription;
import presc_lib.exception.EntityException;

public interface IPrescriptionMetier extends IGenericMetier<Prescription>{
   public List<Prescription> ActivatePrescription() throws EntityException ;
   // public Prescription getId(Long id)throws EntityException ;

}
