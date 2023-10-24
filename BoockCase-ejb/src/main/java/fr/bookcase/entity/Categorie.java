/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Windows
 */
@Entity
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    
    @Column(nullable=false)
    private String intitule;

    @OneToMany(mappedBy = "catego")
    private Collection <Livre> listeLivre;

    public Categorie() {
        listeLivre=new ArrayList();
    }

    public Categorie(String intitule) {
        this.intitule = intitule;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Collection<Livre> getListeLivre() {
        return listeLivre;
    }

    public void setListeLivre(Collection<Livre> listeLivre) {
        this.listeLivre = listeLivre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorie != null ? idCategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idCategorie == null && other.idCategorie != null) || (this.idCategorie != null && !this.idCategorie.equals(other.idCategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.bookcase.entity.Categorie[ id=" + idCategorie + " ]";
    }
    
}
