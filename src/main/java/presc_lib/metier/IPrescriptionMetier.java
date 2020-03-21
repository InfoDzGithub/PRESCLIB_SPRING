package presc_lib.metier;

import java.util.List;

import presc_lib.entities.Prescription;

public interface IPrescriptionMetier extends IGenericMetier<Prescription>{
   public List<Prescription> ActivatePrescription();
}
