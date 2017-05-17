/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Article;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alexis
 */
@Stateless
public class ArticleFacade extends AbstractFacade<Article>
    implements ArticleFacadeLocal {

    @PersistenceContext (unitName = "PrestaZon_HAN-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }
    /*Ajouter article : requete qui va chercher dans la base*/
    //Voir ClientFacade TP Banque => find dans la diagramme de sequence => chercherClient a partir de son nom prenom pour avoir ID
    //Gestion Client appele la fonction chercherClient dans Facade
    //public Integer ajouterArticle(Integer reference, String type,Double prixUnitaire){
        //requette ajout article avec MySQL //ajout dans classe Article comme Client 
        // return null;
    //}
    
    /*Retirer article : requete qui va chercher dans la base*/
   // public void retirerArticle(Integer reference){
        //requette ajout article avec MySQL
         
    //}
    /*Afficher article : requete qui va chercher dans la base*/
    //public void afficherArticle(Integer reference){
        //requette ajout article avec MySQL
         
    //}

 
    @Override
    public void creerArticle(String type,Double prixUnitaire){
        Article art = new Article();
        art.setType(type);
        art.setPrixUnitaire(prixUnitaire);
        em.persist(art);
    }

}
