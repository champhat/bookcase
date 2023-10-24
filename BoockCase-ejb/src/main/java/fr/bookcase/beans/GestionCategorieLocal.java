/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.beans;

import fr.bookcase.entity.Categorie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Windows
 */
@Local
public interface GestionCategorieLocal {

    public void creerCategorie();

    public List<Categorie> getCategorie();

    public Categorie cat(String intitule);
}
