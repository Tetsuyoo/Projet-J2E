/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.GestionArticleLocal;

/**
 *
 * @author Niony
 */
@Stateless
public class ServiceCommercial implements ServiceCommercialRemote{
    
    @EJB
    GestionArticleLocal gestionarticle;
    
    @Override
    public void ajouterArticle(String type,Double prixUnitaire){
        gestionarticle.ajouterArticle(type, prixUnitaire);
    }        
 }

