package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("ADM")
public class Admin extends User implements Serializable {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
