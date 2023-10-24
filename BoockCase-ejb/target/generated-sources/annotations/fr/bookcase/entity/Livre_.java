package fr.bookcase.entity;

import fr.bookcase.entity.Categorie;
import fr.bookcase.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2017-07-11T11:18:20")
@StaticMetamodel(Livre.class)
public class Livre_ { 

    public static volatile SingularAttribute<Livre, Long> idLivre;
    public static volatile SingularAttribute<Livre, User> proprietaire;
    public static volatile SingularAttribute<Livre, Integer> notationLivre;
    public static volatile SingularAttribute<Livre, String> isbn;
    public static volatile SingularAttribute<Livre, String> datePublication;
    public static volatile SingularAttribute<Livre, String> titreLivre;
    public static volatile SingularAttribute<Livre, String> intituleCategorie;
    public static volatile SingularAttribute<Livre, Categorie> catego;
    public static volatile SingularAttribute<Livre, String> etat;

}