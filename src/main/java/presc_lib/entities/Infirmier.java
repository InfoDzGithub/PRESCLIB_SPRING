package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("INF")
public class Infirmier extends User implements Serializable {

	public Infirmier() {
		super();
		// TODO Auto-generated constructor stub
	}

}
