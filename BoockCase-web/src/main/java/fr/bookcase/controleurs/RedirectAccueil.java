/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.controleurs;

import fr.bookcase.beans.GestionCategorieLocal;
import fr.bookcase.beans.GestionUserLocal;
import fr.bookcase.entity.User;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author Windows
 */
public class RedirectAccueil implements SousControleurIt, Serializable {

    GestionUserLocal gestionUser = lookupGestionUserLocal();
    GestionCategorieLocal gestionCategorie = lookupGestionCategorieLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        //vérifie si une session est en cours sinon la créer
        HttpSession session = request.getSession();
        String url = "/WEB-INF/login.jsp";
        String login = "";
        String mdp = "";
        //vérifie mdp et login et renvoi vers la page d'accueil
        if ("versAccueil".equals(request.getParameter("section"))) {
            login = request.getParameter("Login");
            mdp = request.getParameter("mdp");
            if (gestionUser.checkLogin(mdp, login) == true) {
                url = "/WEB-INF/accueil.jsp";
                //passe le user login connecter en session
                session.setAttribute("userConnecteLogin", login);
                request.setAttribute("listeCat", gestionCategorie.getCategorie());
            } else {
                System.out.println("mot de passe ou login incorrecte");
                url = "/WEB-INF/login.jsp";
            }
        }
        return url;
    }

    private GestionUserLocal lookupGestionUserLocal() {
        try {
            Context c = new InitialContext();
            return (GestionUserLocal) c.lookup("java:global/BoockCase-ear/BoockCase-ejb-1.0-SNAPSHOT/GestionUser");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private GestionCategorieLocal lookupGestionCategorieLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCategorieLocal) c.lookup("java:global/BoockCase-ear/BoockCase-ejb-1.0-SNAPSHOT/GestionCategorie");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
