package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Traitement extends Contenu implements Serializable{
  
  private String nom_traitement;
  private String remarque;
  private String voix;
  private int rythme;
  private int dosage;
  
  
  public Traitement() {
		super();
		// TODO Auto-generated constructor stub
	}
  


public Traitement(Prescription prescription, String nom_traitement, String remarque, String voix,
		int rythme,int dosage) {
	super(prescription);
	this.nom_traitement = nom_traitement;
	this.remarque = remarque;
	this.voix = voix;
	this.rythme = rythme;
	this.dosage=dosage;
}



public int getDosage() {
	return dosage;
}



public void setDosage(int dosage) {
	this.dosage = dosage;
}



public String getNom_traitement() {
	return nom_traitement;
}
public void setNom_traitement(String nom_traitement) {
	this.nom_traitement = nom_traitement;
}
public String getRemarque() {
	return remarque;
}
public void setRemarque(String remarque) {
	this.remarque = remarque;
}
public String getVoix() {
	return voix;
}
public void setVoix(String voix) {
	this.voix = voix;
}
public int getRythme() {
	return rythme;
}
public void setRythme(int rythme) {
	this.rythme = rythme;
}

}
