package presc_lib.entities;

import java.io.Serializable;
import java.util.Collection;

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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Contenu implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
  
  @ManyToOne
	@JoinColumn(name="id_prescription")
  private Prescription prescription;
  private Boolean etat;
  
  @OneToMany(mappedBy = "contenu", fetch = FetchType.LAZY)
  private Collection<Validation>validations;
  
public Contenu() {
	super();
                 }


public Contenu(Prescription prescription) {
	super();
	this.prescription = prescription;
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Prescription getPrescription() {
	return prescription;
}
public void setPrescription(Prescription prescription) {
	this.prescription = prescription;
}
public Boolean getEtat() {
	return etat;
}
public void setEtat(Boolean etat) {
	this.etat = etat;
}
public Collection<Validation> getValidations() {
	return validations;
}
public void setValidations(Collection<Validation> validations) {
	this.validations = validations;
}
}
