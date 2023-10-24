package fr.bookcase.entity;

import fr.bookcase.entity.Livre;
import fr.bookcase.entity.PretEmprunt;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2017-07-11T11:18:20")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> mail;
    public static volatile CollectionAttribute<User, Livre> listeLivre;
    public static volatile SingularAttribute<User, Date> dateInscription;
    public static volatile SingularAttribute<User, String> mdp;
    public static volatile SingularAttribute<User, String> adresse;
    public static volatile CollectionAttribute<User, PretEmprunt> listePretEmprunt;
    public static volatile SingularAttribute<User, Long> idUtilisateur;
    public static volatile SingularAttribute<User, String> telephone;
    public static volatile SingularAttribute<User, String> login;
    public static volatile SingularAttribute<User, String> prenom;
    public static volatile SingularAttribute<User, String> nom;

}