package fr.bookcase.entity;

import fr.bookcase.entity.Livre;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2017-07-11T11:18:20")
@StaticMetamodel(Categorie.class)
public class Categorie_ { 

    public static volatile CollectionAttribute<Categorie, Livre> listeLivre;
    public static volatile SingularAttribute<Categorie, Long> idCategorie;
    public static volatile SingularAttribute<Categorie, String> intitule;

}