package presc_lib.metier;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import presc_lib.entities.Historique_Hospitalisation;
import presc_lib.entities.Prescription;
import presc_lib.exception.EntityException;

public interface IPrescriptionMetier extends IGenericMetier<Prescription>{
   public List<Prescription> ActivatePrescription() throws EntityException ;
   // public Prescription getId(Long id)throws EntityException ;
   public Page<Prescription> allPatientPrescriptionByService(Long idH,Pageable p)throws EntityException;
   public Page<Prescription> allPrescriptionInCurrentService(Long idH,Pageable p)throws EntityException;
   public int nbrePatientPrescriptionByHosp(Long idH);
   
}
