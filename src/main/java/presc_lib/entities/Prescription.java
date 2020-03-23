package presc_lib.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.sun.istack.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PRESC", discriminatorType = DiscriminatorType.STRING,length = 4)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type_presc")
@JsonSubTypes({
	@Type(name="SOIN",value=Soin.class),
	@Type(name="SUIV",value=Suivi.class),
	@Type(name="MDCL",value=Medicale.class),
	@Type(name="ALMT",value=Aliment.class)
})
public abstract class Prescription implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="dateP")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@NotNull
  private Date dateP;
  private Boolean etat;
  
@ManyToOne
	@JoinColumn(name="id_patient")
  private Patient patient;
  @ManyToOne
	@JoinColumn(name="id_service")
  private Service serv;
  @ManyToOne
	@JoinColumn(name="id_medecin")
  private User medecin;
  @ManyToOne
	@JoinColumn(name="id_secretaire")
  private User secretaire;
  
  @OneToMany(mappedBy = "prescription", fetch = FetchType.LAZY)
  private Collection<Contenu>contenu;
  
  
  
public Prescription() {
	super();
	// TODO Auto-generated constructor stub
}
public Prescription(Date date, Patient patient, Service serv, User medecin, User secretaire) {
	super();
	this.dateP = date;
	this.patient = patient;
	this.serv = serv;
	this.medecin = medecin;
	this.secretaire = secretaire;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Date getDateP() {
	return dateP;
}
public void setDateP(Date date) {
	this.dateP = date;
}
public Boolean getEtat() {
	return etat;
}
public void setEtat(Boolean etat) {
	this.etat = etat;
}
public Patient getPatient() {
	return patient;
}
public void setPatient(Patient patient) {
	this.patient = patient;
}
public Service getService() {
	return serv;
}
public void setService(Service service) {
	this.serv = service;
}
public User getMedecin() {
	return medecin;
}
public void setMedecin(User medecin) {
	this.medecin = medecin;
}
public User getSecretaire() {
	return secretaire;
}
public void setSecretaire(User secretaire) {
	this.secretaire = secretaire;
}
public Collection<Contenu> getContenu() {
	return contenu;
}
public void setContenu(Collection<Contenu> contenu) {
	this.contenu = contenu;
}
}
