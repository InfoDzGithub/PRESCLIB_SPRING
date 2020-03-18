package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("SCR")
public class Secretaire extends User implements Serializable{

	public Secretaire() {
		super();
		// TODO Auto-generated constructor stub
	}

}
