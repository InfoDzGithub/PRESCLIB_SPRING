package presc_lib.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_validation", discriminatorType = DiscriminatorType.STRING,length = 2)

public abstract class Validation implements Serializable{
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="dateV")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull
	private Date dateV;
	
	@Column(name="timeValidation")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
    @Temporal(TemporalType.TIME)
    @NotNull
	private Date timeValidation;
	@ManyToOne
	@JoinColumn(name="id_contenu")
    private Contenu contenu;
	
	@ManyToOne
	@JoinColumn(name="id_infirmier")
    private User infirmier;
	
	
	
	
	public Validation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Validation(Contenu contenu, User infirmier,Date dateV,Date timeValidation) {
		super();
		this.contenu = contenu;
		this.infirmier = infirmier;
		this.dateV=dateV;
		this.timeValidation=timeValidation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contenu getContenu() {
		return contenu;
	}

	public void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}

	public Date getDateV() {
		return dateV;
	}

	public void setDateV(Date date) {
		this.dateV = date;
	}

	public Date getTimeValidation() {
		return timeValidation;
	}

	public void setHeur(Date timeValidation) {
		this.timeValidation = timeValidation;
	}

	public User getInfirmier() {
		return infirmier;
	}

	public void setInfirmier(User infirmier) {
		this.infirmier = infirmier;
	}

	
}
