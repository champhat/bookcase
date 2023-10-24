<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
         <link href="css/monStyle.css" rel="stylesheet">
        <%@ include file="topMenu.jsp"%>
    </head>
    <body>
        <div class="panel-body">
            <%@ include file="ajouterLivre.jsp"%>
        </div>
        <!-- jQuery (nécessaire pour les plugins javascript de Bootstrap) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <!-- Ce fichier javascript contient tous les plugins fournis par Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/takePhoto.js"></script>
        <!-- <script src="js/jquery-1.11.0.min.js"></script>-->
    </body>
</html>
