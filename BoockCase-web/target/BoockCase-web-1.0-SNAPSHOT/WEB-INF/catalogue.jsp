<%-- 
    Document   : catalogue_Du_Membre
    Created on : 20 févr. 2017, 14:20:24
    Author     : champhat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/bootstrap-theme.min.css" rel="stylesheet">
            <%@ include file="topMenu.jsp"%>
        </head>
        <body>
            <h1>Votre catalogue!</h1>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Isbn</th>
                            <th>Titre</th>
                            <th>Category</th>
                            <th>Date de publication</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="LivreMembre" items="${livreDuMembre}">
                            <tr>
                                <td>${LivreMembre.isbn}</td>
                                <td>${LivreMembre.titreLivre}</td>
                                <td>${LivreMembre.catego.intitule}</td>
                                <td>${LivreMembre.datePublication}</td>
                                <%-- <td class="text-right">${p.prix}</td>
                                 <td>
                                    <c:url var="url" value="Controleur?section=panier&action=ajouter&ref=${p.reference}" />
                                     <a href="${url}" class="btn btn-xs btn-primary">
                                         Ajouter
                                     </a></td>--%>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- jQuery (nécessaire pour les plugins javascript de Bootstrap) -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <!-- Ce fichier javascript contient tous les plugins fournis par Bootstrap -->
            <script src="js/bootstrap.min.js"></script>
            <script src="js/main.js"></script>
        </body>
    </html>
