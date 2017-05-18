/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ArticleFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Niony
 */
@Stateless
public class GestionArticle implements GestionArticleLocal  {

    @EJB
    private ArticleFacadeLocal articleFacadelocal;
    
    @Override
    public void ajouterArticle(String type,Double prixUnitaire){
        articleFacadelocal.creerArticle(type, prixUnitaire);
    }
    
    
}
