package controllers;

import javax.ejb.Local;



@Local
public interface ArticleFacadeLocal {
      public void creerArticle(String type,Double prixUnitaire);
}