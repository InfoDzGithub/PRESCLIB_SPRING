package presc_lib.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_FICHE", discriminatorType = DiscriminatorType.STRING,length = 5)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type_fiche")
@JsonSubTypes({
	@Type(name="SOINS",value=FicheSoin.class),
	@Type(name="ALIMT",value=FicheAliment.class),
	@Type(name="MIDCL",value=FicheMedicale.class),
	@Type(name="SUIVI",value=FicheSuivi.class)
})
public class FicheInfirmier implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateF = new Date();
	private Boolean etat;
	private int num_chambre;
    @ManyToOne
	@JoinColumn(name="id_prescription")
    private Prescription prescription;
    @ManyToOne
	@JoinColumn(name="id_patient")
    private Patient patient;
    @ManyToOne
	@JoinColumn(name="id_service")
    private Service service;
    @OneToMany(mappedBy = "ficheInfirmier", fetch = FetchType.LAZY)
    private Collection<Validation>validations;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public Prescription getPrescription() {
		return prescription;
	}
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	public Collection<Validation> getValidations() {
		return validations;
	}
	public FicheInfirmier() {
		super();
	}
	public void setValidations(Collection<Validation> validations) {
		this.validations = validations;
	}
	public FicheInfirmier(Prescription prescription,Service s,Patient p,int num_chambre) {
		super();
		this.prescription = prescription;
		this.patient=p;
		this.service=s;
		this.num_chambre=num_chambre;
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
	public int getNum_chambre() {
		return num_chambre;
	}
	public void setNum_chambre(int num_chambre) {
		this.num_chambre = num_chambre;
	}

}
