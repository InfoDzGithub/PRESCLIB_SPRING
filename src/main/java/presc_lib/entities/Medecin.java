package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("MED")
public class Medecin extends User implements Serializable{

	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
