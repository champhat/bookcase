/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author Windows
 */
@Entity
public class Livre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivre;
    
    @Column(nullable = false)
    private String titreLivre;
    
    @Column(nullable = false)
    private String isbn;
    
    private int notationLivre;
    
    @Column(nullable = false)
    private String etat;
    
    @Column(nullable = false)
    private String intituleCategorie;
    
    @Column(nullable = false)
    private String datePublication;
    
    @ManyToOne
    private User proprietaire;
    
    @ManyToOne
    private Categorie catego;

    public Livre() {
    }

    public Livre(String titreLivre, String isbn, int notationLivre, String etat,String datePublication, String intituleCategorie, User proprietaire, Categorie catego) {
        this.titreLivre = titreLivre;
        this.isbn = isbn;
        this.notationLivre = notationLivre;
        this.etat = etat;
        this.intituleCategorie = intituleCategorie;
        this.datePublication = datePublication;
        this.proprietaire = proprietaire;
        this.catego = catego;
    }


    public Categorie getCatego() {
        return catego;
    }

    public void setCatego(Categorie catego) {
        this.catego = catego;
    }

    public User getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(User proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getTitreLivre() {
        return titreLivre;
    }

    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNotationLivre() {
        return notationLivre;
    }

    public void setNotationLivre(int notationLivre) {
        this.notationLivre = notationLivre;
    }

    public String isEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }


    public Long getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Long id) {
        this.idLivre = id;
    }

    public String getIntituleCategorie() {
        return intituleCategorie;
    }

    public void setIntituleCategorie(String intituleCategorie) {
        this.intituleCategorie = intituleCategorie;
    }


    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLivre != null ? idLivre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livre)) {
            return false;
        }
        Livre other = (Livre) object;
        if ((this.idLivre == null && other.idLivre != null) || (this.idLivre != null && !this.idLivre.equals(other.idLivre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.bookcase.entity.Livre[ id=" + idLivre + " ]";
    }
    
}
