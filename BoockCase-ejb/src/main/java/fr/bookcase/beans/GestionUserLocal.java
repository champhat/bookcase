/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.beans;

import fr.bookcase.entity.Livre;
import fr.bookcase.entity.User;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Windows
 */
@Local
public interface GestionUserLocal {

    public boolean checkLogin(String mdp, String login);

    public void creerUser(String log, String mdp, String prenom, String nom, String adresse, String telephone, String mail, Date dateInscription);

    public long selectUserID(String login);

    public User selectUser(String login);

    public boolean checkUser (String login, String mail);
}
