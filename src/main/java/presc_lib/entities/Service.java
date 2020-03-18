package presc_lib.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity

public class Service implements Serializable{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String nom;
	  private String telephone;
	  private Boolean etat;
	  /*
	  @ManyToMany(mappedBy ="services")
	  private Collection<User>employers;
	  */
	  @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
	  private Collection<User_Service> user_services;
	  
	 
	  @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
	  private Collection<Patient>patients;
	  
	  
	@OneToOne  
	  @JoinColumn( name="chef_service" )
	  private User chefService;/*??? type c medecin ou user*/
	  
	  @OneToMany(mappedBy = "serv", fetch = FetchType.LAZY)
      private Collection<Prescription>prescriptions;
      
      
      
     public Service() {
  		super();
  		// TODO Auto-generated constructor stub
  	                  }
     
     public Collection<User_Service> getUser_services() {
 		return user_services;
 	}

 	public void setUser_services(Collection<User_Service> user_services) {
 		this.user_services = user_services;
 	}
      
	public Collection<Prescription> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(Collection<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	public Long getId() {
		return id;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public Collection<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Collection<Patient> patients) {
		this.patients = patients;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public User getChefService() {
		return chefService;
	}
	public void setChefService(User chefService) {
		this.chefService = chefService;
	}
	
	
	  
}
