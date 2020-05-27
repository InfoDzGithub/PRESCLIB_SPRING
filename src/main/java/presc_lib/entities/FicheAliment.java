package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("ALIMT")
public class FicheAliment extends FicheInfirmier implements Serializable {

}
