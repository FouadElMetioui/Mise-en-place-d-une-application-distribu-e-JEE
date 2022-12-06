<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		%@page import="ma.fstt.entities.Etudiant"%>
		<%@page import="java.util.List" %>
			<% List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("etudiants");
					%>
					<% Etudiant etudiant=(Etudiant) request.getAttribute("etudiant"); %>
						<!DOCTYPE html>
						<html>

						<head>
							<meta charset="ISO-8859-1">
							<title>Ajouter Etudiant</title>
							<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
						</head>

						<body>

							<div id="page-content-wrapper">
								<div class="container-fluid">
									<div class="row">
										<div class="col-lg-2 mt-4"></div>
										<c:if test="${empty etudiant}">
											<div class="col-lg-4 mt-4">
												<form method="post"
													action="/GetudiantsWeb/ServletController?action=ajouterEtu"
													class="card">
													<div class="form-group">
														<label for="nom">Prenom Etudiant</label> <input type="text"
															name="prenom" class="form-control" id="nom"
															placeholder="Entrer le prenom du etudiant">
													</div>
													<div class="form-group">
														<label for="prenom">Nom Etudiant</label> <input type="text"
															name="nom" class="form-control" id="prenom"
															placeholder="Entrer le prenom du etudiant">
													</div>
													<div class="form-group">
														<label for="adress">Adress Etudiant</label> <input type="text"
															name="addr" class="form-control" id="adress"
															placeholder="Entrer l'adress du etudiant">
													</div>
													<div class="form-group">
														<label for="tel">Niveau Etudiant</label> <input type="text"
															name="niveau" class="form-control" id="tel"
															placeholder="Entrer le telephone du etudiant">
													</div>
													<div class="form-group">
														<label for="ville">CNE Etudiant</label> <input type="text"
															name="cne" class="form-control" id="ville"
															placeholder="Entrer le cne du etudiant">
													</div>
													<input type="submit" class="btn btn-primary mb-2 mt-3"
														value="Ajouter">
												</form>
											</div>
										</c:if>
										<c:if test="${not empty etudiant}">
											<div class="col-lg-4 mt-4">
												<form method="post"
													action="/GetudiantsWeb/ServletController?action=modifierEtu"
													class="card">
													<div class="form-group">
														<label for="nom">Prenom Etudiant</label> <input type="text"
															name="prenom" class="form-control" id="nom"
															value="${ etudiant.getPrenom()}">
													</div>
													<div class="form-group">
														<label for="prenom">Nom Etudiant</label> <input type="text"
															name="nom" class="form-control" id="prenom"
															value="${ etudiant.getNom()}">
													</div>
													<div class="form-group">
														<label for="adress">Adress Etudiant</label> <input type="text"
															name="addr" class="form-control" id="adress"
															value="${ etudiant.getAdresse()}">
													</div>

													<div class="form-group">
														<label for="adress">niveau Etudiant</label> <input type="text"
															name="niveau" class="form-control" id="adress"
															value="${ etudiant.getNiveau()}">
													</div>

													<div class="form-group">
														<label for="adress">CNE Etudiant</label> <input type="text"
															name="cne" class="form-control" id="adress"
															value="${ etudiant.getCne()}">
													</div>

													<input type="hidden" id="id" name="idEtudiant"
														value="${ etudiant.getId_etudiant()}">
													<input type="submit" class="btn btn-warning mb-2 mt-3"
														value="Update">
												</form>
											</div>
										</c:if>

										<div class="col-lg-6 mt-4">
											<table class="table" class="card">
												<thead class="card-header">
													<tr>
														<th scope="col">prenom</th>
														<th scope="col">nom</th>
														<th scope="col">adress</th>
														<th scope="col">niveau</th>
														<th scope="col">cne</th>
														<th scope="col">action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${etudiants}" var="etudiant">
														<tr>
															<td>${etudiant.getPrenom()}</td>
															<td>${etudiant.getNom()}</td>
															<td>${etudiant.getAdresse()}</td>
															<td>${etudiant.getNiveau() }</td>
															<td>${etudiant.getCne()}</td>
															<td><a href="/GetudiantsWeb/ServletController?action=supprimerEtu${etudiant.getId_etudiant()}"
																	class="btn btn-danger">Delete</a><a
																	href="/GetudiantsWeb/ServletController?action=UpdateEtu${etudiant.getId_etudiant()}"
																	class="btn btn-warning">update</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>


								</div>
							</div>


							</div>


						</body>

						</html>