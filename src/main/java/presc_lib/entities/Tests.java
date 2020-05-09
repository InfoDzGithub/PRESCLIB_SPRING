package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Tests extends Contenu implements Serializable{
 
 
   private String nom_test;
   private int nbre_par_jr;
   private String remarque;
   
public Tests() 
{
		super();
		// TODO Auto-generated constructor stub
}
 
 public Tests(Prescription prescription, String nom_test, int nbre_par_jr,String remarque) {
	super(prescription);
	this.nom_test = nom_test;
	this.nbre_par_jr = nbre_par_jr;
	this.remarque=remarque;
}

public String getRemarque() {
	return remarque;
}

public void setRemarque(String remarque) {
	this.remarque = remarque;
}

public String getNom_test() {
	return nom_test;
}

public void setNom_test(String nom_test) {
	this.nom_test = nom_test;
}

public int getNbre_par_jr() {
	return nbre_par_jr;
}

public void setNbre_par_jr(int nbre_par_jr) {
	this.nbre_par_jr = nbre_par_jr;
}


}
