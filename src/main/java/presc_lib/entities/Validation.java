package presc_lib.entities;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_validation", discriminatorType = DiscriminatorType.STRING,length = 2)

public abstract class Validation implements Serializable{
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private Long heur;
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
	public Validation(Contenu contenu, Date date, Long heur, User infirmier) {
		super();
		this.contenu = contenu;
		this.date = date;
		this.heur = heur;
		this.infirmier = infirmier;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getHeur() {
		return heur;
	}

	public void setHeur(Long heur) {
		this.heur = heur;
	}

	public User getInfirmier() {
		return infirmier;
	}

	public void setInfirmier(User infirmier) {
		this.infirmier = infirmier;
	}

	
}
