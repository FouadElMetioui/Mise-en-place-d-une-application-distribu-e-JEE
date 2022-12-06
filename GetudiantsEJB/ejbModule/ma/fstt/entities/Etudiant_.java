package ma.fstt.entities;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-12-03T00:32:18.933+0100")
@StaticMetamodel(Etudiant.class)
public class Etudiant_ {
	public static volatile SingularAttribute<Etudiant, Long> id_etudiant;
	public static volatile SingularAttribute<Etudiant, String> nom;
	public static volatile SingularAttribute<Etudiant, String> prenom;
	public static volatile SingularAttribute<Etudiant, String> cne;
	public static volatile SingularAttribute<Etudiant, String> adresse;
	public static volatile SingularAttribute<Etudiant, String> niveau;
}
