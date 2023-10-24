/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.controleurs;

import fr.bookcase.beans.GestionUserLocal;
import fr.bookcase.entity.User;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows
 */
public class RedirectInscription implements SousControleurIt, Serializable{

    GestionUserLocal gestionUser = lookupGestionUserLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        //Ajoute un utilisateur à la BD quand on valide le formulaire
        String url ="/WEB-INF/inscription.jsp";
        if(request.getParameter("doIt")!=null){ 
        Date d=new Date();
        String login =request.getParameter("log");
        String mdp =request.getParameter("mdp");
        String nom =request.getParameter("nom");
        String prenom =request.getParameter("prenom");
        String adresse =request.getParameter("adresse");
        String tel =request.getParameter("tel");
        String email =request.getParameter("mail");
        
        try {
            if(gestionUser.checkUser(login, email)==false){
//                System.out.println(""+gestionUser.checkUser(login, email));
             gestionUser.creerUser(login, mdp,nom, prenom,adresse,tel,email, d);
            }else{
                System.out.println("login ou mail existe dejà");
            }
             url ="/WEB-INF/login.jsp";
        } catch (Exception e) {
            System.out.println("Impossible de créer un nouvel utilisateur");
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
}
