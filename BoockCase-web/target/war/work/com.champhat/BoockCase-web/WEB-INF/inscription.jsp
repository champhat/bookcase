<%-- 
    Document   : inscription
    Created on : 24 août 2016, 14:10:37
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <title>BooCase inscription</title>
    </head>
    <body>
        <h1>Inscrivez-vous pour accéder aux services, tous les champs sont obligatoires.</h1>
        <form method="post" action="FrontControler?section=versInscription">
            <label class="">Nom</label>
            <input type="text" name="nom" required />
            </br></br>
            <label class="">Prénom</label>
            <input type="text" name="prenom" required />
            </br></br>
            <label class="">Adresse</label>
            <input type="text" name="adresse" required />
            </br></br>
            <label class="">télephone</label>
            <input type="text" name="tel" required />
            </br></br>
            <label class="">email</label>
            <input type="text" name="mail" required />
            </br></br>
            <label class="">Login</label>
            <input type="text" name="log" required />
            </br></br>
            <label class="">Mot de passe</label>
            <input type="text" name="mdp" required />
            </br></br>
            <input name="doIt" type="submit" value="ok" class="btn btn-success" />
        </form>
         <span><a href="FrontControler?section=versLogin">retour vers la page login</a></span>
    </body>
</html>
