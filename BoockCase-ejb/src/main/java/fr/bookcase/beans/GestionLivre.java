/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.beans;

import fr.bookcase.entity.Categorie;
import fr.bookcase.entity.Livre;
import fr.bookcase.entity.User;
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
public class GestionLivre implements GestionLivreLocal {

    @PersistenceContext(unitName = "BoockCasePU")
    private EntityManager em;

    @Override
    public void creerLivre(String titreLivre, String isbn, int notation, String etat, String datePublication, String intituleCategorie, User us, Categorie cat) {
        em.persist(new Livre(titreLivre, isbn, notation, etat, datePublication, intituleCategorie, us, cat));
    }
    
   @Override
    public List<Livre> selectlivre_avec_id_Membre(Long idMembre) {
        //pas besoin de jointure
        String req = "select liv from Livre liv where liv.proprietaire.idUtilisateur= :idUser";
        System.out.println(req);
        Query qr = em.createQuery(req);
        qr.setParameter("idUser", idMembre);
        List<Livre> membreListeLivre = qr.getResultList();
        return membreListeLivre;
    }


   @Override
    public List<Livre> selectAlllivre() {
        String req = "select liv from Livre liv";
        System.out.println(req);
        Query qr = em.createQuery(req);
        List<Livre> membreListeLivre = qr.getResultList();
        return membreListeLivre;
    }
}