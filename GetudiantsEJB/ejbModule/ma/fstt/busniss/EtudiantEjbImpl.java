package ma.fstt.busniss;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.fstt.entities.Etudiant;

@Stateless(name="GEtudiant")
public class EtudiantEjbImpl implements EtudiantRemote{
	@PersistenceContext(unitName="Etudiant")
	private static EntityManager entityManager ;
	
	@Override
	public void save(Etudiant etudiant) {
		System.out.println("Save : " + etudiant.toString());		
		entityManager.persist(etudiant);
		
	}

	@Override
	public void update(Etudiant etudiant) {
		System.out.println("Update : " + etudiant.toString());
		entityManager.refresh(etudiant);
	}

	@Override
	public void delete(Etudiant etudiant) {
		System.out.println("Delete : " + etudiant.toString());
		entityManager.remove(etudiant);
	}

	@Override
	public Etudiant getById(int idEtudiant) {
		System.out.println("idEtudiant : " + idEtudiant);
		Etudiant etudiant = entityManager.find(Etudiant.class, idEtudiant);
		if(etudiant == null)
			throw new RuntimeException("Etudiant introuvale !");
		return etudiant;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> list() {
		System.out.println("List des Etudiants");
		Query qry = entityManager.createQuery("Select e from Etudiant e");
		return qry.getResultList();
	}

}
