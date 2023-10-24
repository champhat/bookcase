/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.controleurs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows
 */
public class FrontControler extends HttpServlet {

    private HashMap<String, SousControleurIt> mp;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        mp = new HashMap();
        for (Enumeration<String> e = config.getInitParameterNames(); e.hasMoreElements();) {
            //on récupere une énumaration de chaine de charactere qui represente le String de la hasmap soit le paramètre de la section : versLogin qui est la clé string de la HasMap etc...
            String name = e.nextElement(); //cousin de l'iterator l'enumeration
            String valeur = config.getInitParameter(name);
            SousControleurIt cit;
            try {
                cit = (SousControleurIt) Class.forName(valeur).newInstance();
//je veux la classe dont la valeur est donnée par la chaine de charactere contenu dans la variable valeur et créer un nouvelle instance de cette classe
                mp.put(name, cit);//on passe a la Hasmap
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String section = request.getParameter("section");
            String url = "/WEB-INF/login.jsp";

           if (section != null && mp.containsKey(section)) {
                SousControleurIt it = mp.get(section);
                url = it.execute(request, response, this);

            }

            
            url = response.encodeURL(url);
            getServletContext().getRequestDispatcher(url).include(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

