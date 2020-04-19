package presc_lib.entities;

import java.io.Serializable;
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

public class User_Service implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	@ManyToOne
	@JoinColumn(name="id_service")
	private Service service;
	private Boolean etat;
	@Column(name="dateE")
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	 @Temporal(TemporalType.DATE)
	 @NotNull
	private Date dateE;
	@Column(name="dateS")
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	 @Temporal(TemporalType.DATE)
	 @NotNull
	private Date dateS;
	
	public User_Service() {
		super();
		
	}
	
	public User_Service(User user, Service service, Boolean etat, Date dateE, Date dateS) {
		super();
		this.user = user;
		this.service = service;
		this.etat = etat;
		this.dateE = dateE;
		this.dateS = dateS;
	}
	public User getUser() {
		return user;
	}
	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
}
