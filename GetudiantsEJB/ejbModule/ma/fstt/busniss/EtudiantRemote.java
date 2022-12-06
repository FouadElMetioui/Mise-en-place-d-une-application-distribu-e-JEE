package ma.fstt.busniss;

import java.util.List;

import javax.ejb.Remote;


import ma.fstt.entities.Etudiant;

@Remote

public interface EtudiantRemote {
	public void save(Etudiant etudiant);
	public void update(Etudiant etudiant);
	public void delete(Etudiant etudiant);
	public Etudiant getById(int idEtudiant);
	public List<Etudiant> list();
}
