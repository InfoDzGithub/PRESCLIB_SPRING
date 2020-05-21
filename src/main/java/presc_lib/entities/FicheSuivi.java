package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SUIVI")
public class FicheSuivi extends FicheInfirmier implements Serializable {

}
