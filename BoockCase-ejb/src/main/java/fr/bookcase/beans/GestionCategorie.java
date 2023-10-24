/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.beans;

import fr.bookcase.entity.Categorie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Windows
 */
@Stateless
public class GestionCategorie implements GestionCategorieLocal {

    @PersistenceContext(unitName = "BoockCasePU")
    private EntityManager em;
//créer cat

    @Override
    public void creerCategorie() {
        String intitule[] = {"littérature", "romance", "colaire", "théâtre", "auto-édition", "dictionnaire", "langue", "guide pratique",
            "informatique et internet", "policier et suspense", "sciences humaines", "SF, Fantasy", "tourisme et voyages",
            "bande dessinée", "Droit, économie", "histoire", "jeunesse", "religion et spiritualité",
            "sciences techniques et médecine", "sport loisir et vie pratique", "cusine", "humour", "Essais et documents", "Art, musique et cinéma"};
        String inti = "";
        for (int i = 0; i < intitule.length - 1; i++) {
            inti = intitule[i];
            em.persist(new Categorie(inti));
        }
    }

//récup une liste de cat
    @Override
    public List<Categorie> getCategorie() {
        String req = "select catego from Categorie catego";
        Query qer = em.createQuery(req);
        List<Categorie> maList = qer.getResultList();
        return maList;
    }
/*//verifie si les catégorie existe déjà
    @Override
    public boolean checkExisteCat(String intitule) {
        boolean test = false;
        String req = "select cat from Categorie cat";
        Query qr = em.createQuery(req);
        qr.setParameter("SearchIntitule", intitule);
        List<Categorie> maList = qr.getResultList();
    if
        return test;
    }*/
    
//recup IDcat selon intitule

    @Override
    public Categorie cat(String intitule) {
        String req = "select cat from Categorie cat WHERE cat.intitule= :SearchIntitule";
        Query qr = em.createQuery(req);
        qr.setParameter("SearchIntitule", intitule);
        Categorie cat = (Categorie) qr.getSingleResult();
        return cat;
    }
}
