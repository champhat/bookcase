/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author champhat
 */
@Entity
public class PretEmprunt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPretEmprunt;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datePret;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateRetour;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dureePret;
    
    @Column(nullable = true)
    boolean relance;
    
    @OneToOne
    Livre livre;
    
    @ManyToOne
    User emprunteur;
    
    public PretEmprunt() {
    }

    public PretEmprunt(Date datePret, Date dateRetour, Date dureePret, boolean relance) {
        this.datePret = datePret;
        this.dateRetour = dateRetour;
        this.dureePret = dureePret;
        this.relance = relance;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public User getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(User emprunteur) {
        this.emprunteur = emprunteur;
    }
    

    public Long getIdPretEmprunt() {
        return idPretEmprunt;
    }

    public Date getDatePret() {
        return datePret;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public Date getDureePret() {
        return dureePret;
    }

    public boolean isRelance() {
        return relance;
    }

    public void setIdPretEmprunt(Long idPretEmprunt) {
        this.idPretEmprunt = idPretEmprunt;
    }

    public void setDatePret(Date datePret) {
        this.datePret = datePret;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public void setDureePret(Date dureePret) {
        this.dureePret = dureePret;
    }

    public void setRelance(boolean relance) {
        this.relance = relance;
    }

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPretEmprunt != null ? idPretEmprunt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PretEmprunt)) {
            return false;
        }
        PretEmprunt other = (PretEmprunt) object;
        if ((this.idPretEmprunt == null && other.idPretEmprunt != null) || (this.idPretEmprunt != null && !this.idPretEmprunt.equals(other.idPretEmprunt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.bookcase.entity.PretEmprunt[ id=" + idPretEmprunt + " ]";
    }
    
}
