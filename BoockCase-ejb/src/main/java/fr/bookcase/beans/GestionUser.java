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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GestionUser implements GestionUserLocal {

    @PersistenceContext(unitName = "BoockCasePU")
    private EntityManager em;

    //vérifie si l'utilisateur existe déjà
    @Override
    public boolean checkUser(String login, String mail) {
        boolean result = false;
        String req = "select us from User us";
        Query qr = em.createQuery(req);
        List<User> us = qr.getResultList();
        for (User use : us) {
            if (use.getLogin().equals(login) || use.getMail().equals(mail)) {
                result = true;
                System.out.println("-----------"+login+"-----------"+mail );
            }
        }
        return result;
    }

    //verifie que le mot de passe entré existe dans la base de donnée
    @Override
    public boolean checkLogin(String mdp, String login) {
        boolean verifParam = false;
        String req = "select us from User us";
        Query qr = em.createQuery(req);
        List<User> us = qr.getResultList();
        for (User a : us) {
            if (mdp.equals(a.getMdp()) && login.equals(a.getLogin())) {
                verifParam = true;
            }
        }
        return verifParam;
    }

    //récupère l'utilisateur qui se log pour le passer dans la session
    @Override
    public User selectUser(String login) {
        String req = "select us from User us where us.login= :logUser";
        Query qr = em.createQuery(req);
        qr.setParameter("logUser", login);
        User selectUser = (User) qr.getSingleResult();
        return selectUser;
    }
//récupère l'id de l'utilisateur en fonction du login

    @Override
    public long selectUserID(String login) {
        long userID = 0;
        String req = "select us from User us where us.login= :logUser";        
        Query qr = em.createQuery(req);
        qr.setParameter("logUser", login);
        List<User> selectUser = qr.getResultList();
        for (User us : selectUser) {
            userID = us.getIdUtilisateur();
        }
        return userID;
    }

    @Override
    public void creerUser(String log, String mdp, String prenom, String nom, String adresse, String telephone, String mail, Date dateInscription) {
        em.persist(new User(log, mdp, prenom, nom, adresse, telephone, mail, dateInscription));
        System.out.println("done!");
    }

}
