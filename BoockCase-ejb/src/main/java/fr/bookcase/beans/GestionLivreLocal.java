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
import javax.ejb.Local;

/**
 *
 * @author Windows
 */
@Local
public interface GestionLivreLocal {
    public void creerLivre(String titreLivre, String bn, int notation, String etat, String datePublication, String intituleCategorie, User selectUser, Categorie cat);
    public List<Livre> selectlivre_avec_id_Membre(Long idMembre);
    public List<Livre> selectAlllivre();
}
