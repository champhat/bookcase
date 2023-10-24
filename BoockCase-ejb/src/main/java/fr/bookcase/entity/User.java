/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.bookcase.entity;

/**
 *
 * @author Windows
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;
    
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String mdp;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private String mail;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInscription;
   
    @OneToMany(mappedBy = "proprietaire")
    private Collection <Livre> listeLivre;
    
    @OneToMany(mappedBy = "emprunteur")
    private Collection<PretEmprunt> listePretEmprunt;

    public User() {
         listeLivre=new ArrayList();
    }

    
    public User(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    public User(String login, String mdp, String prenom, String nom, String adresse, String telephone, String mail, Date dateInscription) {
        this.login = login;
        this.mdp = mdp;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
        this.dateInscription = dateInscription;
    }

    public Collection<PretEmprunt> getListePretEmprunt() {
        return listePretEmprunt;
    }

    public void setListePretEmprunt(Collection<PretEmprunt> listePretEmprunt) {
        this.listePretEmprunt = listePretEmprunt;
    }

    
    public Collection<Livre> getListeLivre() {
        return listeLivre;
    }

    public void setListeLivre(Collection<Livre> listeLivre) {
        this.listeLivre = listeLivre;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public String toString() {
        return "User{" + "login=" + login + ", mdp=" + mdp + ", prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + ", mail=" + mail + ", dateInscription=" + dateInscription + '}';
    }
    
}

