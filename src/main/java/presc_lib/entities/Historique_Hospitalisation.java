package presc_lib.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
public class Historique_Hospitalisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    @ManyToOne
	@JoinColumn(name="id_patient")
  private Patient patient;
    @ManyToOne
	@JoinColumn(name="id_service")
  private Service service;
  private Date date_entre;
  private Date date_sortie;
  private int num_chambre;
  private Boolean etat;
    @ManyToOne
	@JoinColumn(name="id_medecin")
  private User medecin_traitant;
  
  

  
  public Historique_Hospitalisation(Patient patient, Service service, Date date_entre, int num_chambre,
			User medecin_traitant) {
		super();
		this.patient = patient;
		this.service = service;
		this.date_entre = date_entre;
		this.num_chambre = num_chambre;
		this.medecin_traitant = medecin_traitant;
	}
public Historique_Hospitalisation()
  {
		super();
  }
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Patient getPatient() {
	return patient;
}
public void setPatient(Patient patient) {
	this.patient = patient;
}
public Service getService() {
	return service;
}
public void setService(Service service) {
	this.service = service;
}
public Date getDate_entre() {
	return date_entre;
}
public void setDate_entre(Date date_entre) {
	this.date_entre = date_entre;
}
public Date getDate_sortie() {
	return date_sortie;
}
public void setDate_sortie(Date date_sortie) {
	this.date_sortie = date_sortie;
}
public int getNum_chambre() {
	return num_chambre;
}
public void setNum_chambre(int num_chambre) {
	this.num_chambre = num_chambre;
}
public Boolean getEtat() {
	return etat;
}
public void setEtat(Boolean etat) {
	this.etat = etat;
}
public User getMedecin_traitant() {
	return medecin_traitant;
}
public void setMedecin_traitant(User medecin_traitant) {
	this.medecin_traitant = medecin_traitant;
}

  
  
}
