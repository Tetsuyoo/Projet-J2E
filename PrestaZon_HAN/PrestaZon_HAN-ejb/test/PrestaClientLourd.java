
import javax.naming.InitialContext;
import javax.naming.NamingException;
import services.ServiceCommercialRemote;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Niony
 */
public class PrestaClientLourd {
     public static void main(String[] args) throws NamingException{
        System.setProperty("java.naming.factory.initial",
        "com.sun.enterprise.naming.SerialInitContextFactory");
        System.setProperty("org.omg.CORBA.ORBInitialHost",
        "127.0.0.1");
        System.setProperty("org.omg.CORBA.ORBInitialPort",
        "3700");
         
         
        InitialContext context = new InitialContext();
        ServiceCommercialRemote scom = (ServiceCommercialRemote) context.lookup("services.ServiceCommercialRemote");
        
        System.out.println("Ajout d'article");
        double prixUnitaire = 150 ;
        scom.ajouterArticle("type",prixUnitaire);
     }
}
