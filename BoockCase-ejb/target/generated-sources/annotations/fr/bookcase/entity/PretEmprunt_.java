package fr.bookcase.entity;

import fr.bookcase.entity.Livre;
import fr.bookcase.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2017-07-11T11:18:20")
@StaticMetamodel(PretEmprunt.class)
public class PretEmprunt_ { 

    public static volatile SingularAttribute<PretEmprunt, Long> idPretEmprunt;
    public static volatile SingularAttribute<PretEmprunt, User> emprunteur;
    public static volatile SingularAttribute<PretEmprunt, Date> datePret;
    public static volatile SingularAttribute<PretEmprunt, Date> dateRetour;
    public static volatile SingularAttribute<PretEmprunt, Boolean> relance;
    public static volatile SingularAttribute<PretEmprunt, Date> dureePret;
    public static volatile SingularAttribute<PretEmprunt, Livre> livre;

}