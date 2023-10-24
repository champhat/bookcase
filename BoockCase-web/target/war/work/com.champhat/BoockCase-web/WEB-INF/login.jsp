<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <title>Bookcase</title>
    </head>
    <body>
         <center>
        <h1 class="panel-heading">Authentification</h1>
        <br />
        <form method="POST" action="FrontControler?section=versAccueil">
            <p>
                <label >entrer Login</label>
                <input type="text" name="Login" required />
                <br>
                <label>entrer MDP</label>
                <input type="text" name="mdp" required />
                <input type="submit" name="doIt" value="ok" class="btn btn-success" />
            </p>
        </form>
        <span><a href="FrontControler?section=versInscription">s'inscrire</a></span>
         </center>
         <script src="js/monScript.js" type="text/javascript"></script>
    </body>
</html>
