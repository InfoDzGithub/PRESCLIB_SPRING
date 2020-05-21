package presc_lib.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SOINS")
public class FicheSoin extends FicheInfirmier implements Serializable {




}
