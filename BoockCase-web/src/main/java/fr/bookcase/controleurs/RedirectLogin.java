/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.controleurs;

import fr.bookcase.beans.GestionCategorieLocal;
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
//import sessionsbeans.GestionUserLocal;

public class RedirectLogin implements SousControleurIt, Serializable {

    GestionCategorieLocal gestionCategorie = lookupGestionCategorieLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url = "/WEB-INF/login.jsp";

        //créer les catégories par défaut
        try {
            if (gestionCategorie.getCategorie().isEmpty() ) {
                gestionCategorie.creerCategorie();
            }
        } catch (Exception e) {
            System.out.println("problème créations des cat");
        }

        return url;
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
