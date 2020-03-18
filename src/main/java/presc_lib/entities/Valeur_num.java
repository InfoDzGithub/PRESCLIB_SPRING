package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VN")
public class Valeur_num extends Validation implements Serializable{
   
	private double val_num;

	public Valeur_num() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getVal_num() {
		return val_num;
	}

	public void setVal_num(double val_num) {
		this.val_num = val_num;
	}
}
