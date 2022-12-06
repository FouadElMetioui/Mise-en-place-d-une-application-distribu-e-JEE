package ma.fstt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.busniss.EtudiantRemote;
import ma.fstt.entities.Etudiant;



@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Etudiant etudiant ;
	private List<Etudiant> etudiants;
	
	 @jakarta.ejb.EJB
	 private EtudiantRemote remote;
    
    public ServletController() {
        super();
        etudiants = new ArrayList<>();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "index":
				ShowIndex(request, response);
				break;

			case "ajouterEtu":

				AjouterEtudiant(request, response);
				break;
			case "supprimerEtu":

				SupprimerEtudiant(request, response);
				break;

			case "modifierEtu":

				ModifierEtudiant(request, response);
				break;
				
			case "UpdateEtu":

				UpdateEtudiant(request, response);
				break;

			default:
				ShowIndex(request, response);
				break;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void UpdateEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowIndex(request , response);
	}
	
	public void ShowIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 etudiants = remote.list();
		request.setAttribute("etudiants", etudiants);
		request.getRequestDispatcher("jsp/Etudiant.jsp").forward(request, response);
	}
	
	private void AjouterEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String addr = request.getParameter("addr");
		String niveau = request.getParameter("niveau");
		String cne = request.getParameter("cne");
		
		
		
		Etudiant etu = new Etudiant(nom,prenom,cne,addr,niveau);
		remote.save(etu);
		
		ShowIndex(request , response);
	}
	
	private void SupprimerEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idEtudiant"));
		Etudiant etu = new Etudiant();
		etu =remote.getById(id);
		remote.delete(etu);
		ShowIndex(request , response);
	}
	

	private void ModifierEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idEtudiant"));
		etudiant =remote.getById(id);
		request.setAttribute("etudiant", etudiant);
		ShowIndex(request , response);
		
	}
	
	
}
