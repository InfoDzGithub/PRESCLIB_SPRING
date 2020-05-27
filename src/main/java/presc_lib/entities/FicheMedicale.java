package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MIDCL")
public class FicheMedicale extends FicheInfirmier implements Serializable {

}
