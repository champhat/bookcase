/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.controleurs;

import fr.bookcase.beans.GestionCategorieLocal;
import fr.bookcase.beans.GestionLivreLocal;
import fr.bookcase.beans.GestionUserLocal;
import fr.bookcase.entity.Livre;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Windows
 */
public class RedirectGestionLivre implements SousControleurIt, Serializable {

    GestionCategorieLocal gestionCategorie = lookupGestionCategorieLocal();

    GestionLivreLocal gestionLivre = lookupGestionLivreLocal();
    GestionUserLocal gestionUser = lookupGestionUserLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url = "/WEB-INF/catalogue.jsp";
        //vérifie si une session est en cours sinon la créer
        HttpSession session = request.getSession();
       //récup la session en cours (le login)
        String login = (String) session.getAttribute("userConnecteLogin");
        
        if (request.getParameter("saveIt")!=null) {
            String titreLivre = request.getParameter("titre");
            String isbn = request.getParameter("isbn");
            int notation = Integer.valueOf(request.getParameter("note"));
            String etat = request.getParameter("dispo");
            String datePublication = request.getParameter("date");
            String intituleCategorie = request.getParameter("cat");
            try {
                gestionLivre.creerLivre(titreLivre, isbn, notation, etat, datePublication, intituleCategorie, gestionUser.selectUser(login), gestionCategorie.cat(intituleCategorie));
            } catch (Exception e) {
                System.out.println("problème d'ajout de livre ou de selection des livres du membres");
            } 
        }
            List<Livre> listeLivre = gestionLivre.selectlivre_avec_id_Membre(gestionUser.selectUserID(login));
            request.setAttribute("livreDuMembre", listeLivre);
        return url;
    }

    private GestionLivreLocal lookupGestionLivreLocal() {
        try {
            Context c = new InitialContext();
            return (GestionLivreLocal) c.lookup("java:global/BoockCase-ear/BoockCase-ejb-1.0-SNAPSHOT/GestionLivre");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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
