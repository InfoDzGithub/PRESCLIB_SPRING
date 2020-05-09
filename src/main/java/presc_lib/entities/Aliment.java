package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ALMT")

public class Aliment extends Prescription implements Serializable{
	
	private String type_aliment;

	public Aliment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aliment(Patient patient, Service serv, User medecin, User secretaire,String type,String aliment) {
		super(patient, serv, medecin, secretaire, type);
		this.type_aliment=aliment;
		// TODO Auto-generated constructor stub
	}

	public String getType_aliment() {
		return type_aliment;
	}

	public void setType_aliment(String type_aliment) {
		this.type_aliment = type_aliment;
	}

	public Aliment(String type_aliment) {
		super();
		this.type_aliment = type_aliment;
	}



}
