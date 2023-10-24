<%-- 
    Document   : ajouterLivre
    Created on : 25 août 2016, 16:25:37
    Author     : Windows
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un livre</title>
    </head>
    <body>
        <div>
            <h1>Ajouter un livre</h1>
            <form method="post" action="FrontControler?section=versGestionLivre">
                <label>titre du livre</label>
                <input type="text" name="titre" required />
                </br></br>
                <label>nom auteur</label>
                <input type="text" name="nomaut" required />
                </br></br>
                <label>prenom auteur</label>
                <input type="text" name="prenomaut" required />
                </br></br>
                <label>categorie</label>

                <select name="cat" class=form-control required>
                    <c:forEach var="itemCat" items="${listeCat}">
                        <option value="${itemCat.intitule}">${itemCat.intitule}</option>
                    </c:forEach>

                    <!--<option value=litterature>littérature</option>
                    <option value=romance>romance</option>
                    <option value=scolaire>scolaire</option>
                    <option value=theatre>théâtre</option>
                    <option value=auto_edition>auto-édition</option>
                    <option value=dictionnaire_langue>dictionnaire,langue</option>
                    <option value=guide>guide pratique</option>
                    <option value=informatique_internet>informatique et internet</option>
                    <option value=policier_suspense>policier et suspense</option>
                    <option value=sciences_humaines>sciences humaines</option>
                    <option value=SF_Fantasy>SF, Fantasy</option>
                    <option value=tourisme>tourisme et voyages</option>
                    <option value=bande_dessinee>bande dessinée</option>
                    <option value=Droit_economie>Droit, économie</option>
                    <option value=histoire>histoire</option>
                    <option value=jeunesse>jeunesse</option>
                    <option value=religion>religion et spiritualité</option>
                    <option value=sciences>sciences techniques et médecine</option>
                    <option value=sport>sport loisir et vie pratique</option>
                    <option value=cusine>cusine</option>
                    <option value=deux>humour</option>
                    <option value=Essais>Essais et documents</option>
                    <option value=Art>Art, musique et cinéma</option>-->
                </select>
                </br></br>
                <label>Editeur</label>
                <input type="text" name="edi" required />
                </br></br>
                <label>Adresse Editeur</label>
                <input type="text" name="adresseEdi" />
                </br></br>
                <label>isbn</label>
                <input type="text" name="isbn" required />
                </br></br>
                <label>date de publication</label>
                <input type="text" name="date" required />
                </br></br>
                <label>note attribuée au livre</label>
                <input type="text" name="note" required /> 
                </br></br>
                <label>disponibilité</label>
                <input type="text" name="dispo" required />
                </br></br>
                <input name="saveIt" type="submit" value="ok" class="btn btn-success" />
            </form>
        </div>
        
            <h1>ajouter livre par code barre</h1>

                <video id="video"></video>
                <button id="startbutton">Take photo</button>
                <canvas id="canvas"></canvas>
                <img src="http://placekitten.com/g/200/150" id="photo" alt="photo">
                <br/>
                <h2>Regular file upload</h2>
                <input type="file"></input>

                <h2>capture=camera</h2>
                <input type="file" accept="image/*;capture=camera"></input>

                <h2>capture=camcorder</h2>
                <input type="file" accept="video/*;capture=camcorder"></input>



        
    </body>
</html>
