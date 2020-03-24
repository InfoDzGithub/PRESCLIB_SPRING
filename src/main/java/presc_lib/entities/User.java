package presc_lib.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonToken;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_USER", discriminatorType = DiscriminatorType.STRING,length = 3)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type_user")
@JsonSubTypes({
	@Type(name="ADM",value=Admin.class),
	@Type(name="MED",value=Medecin.class),
	@Type(name="SCR",value=Secretaire.class),
	@Type(name="INF",value=Infirmier.class)
})
public abstract class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String adress;
	private Date date_naissance;
	private String role;
	private String sexe;
	private String telephone;
	private String email;
	private String photo;
	private Boolean etat;
	/*
	@ManyToMany
	@JoinTable(
	  name = "USER_SERV", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "service_id"))
	  */
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Collection<User_Service> user_services;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String nom, String prenom, String adress, Date date_naissance, String role, String sexe,
			String telephone, String email, String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adress = adress;
		this.date_naissance = date_naissance;
		this.role = role;
		this.sexe = sexe;
		this.telephone = telephone;
		this.email = email;
		this.photo = photo;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public Long getId() {
		return id;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@JsonIgnore
	public Collection<User_Service> getUser_services() {
		return user_services;
	}
	public void setUser_services(Collection<User_Service> user_services) {
		this.user_services = user_services;
	}
	
}
