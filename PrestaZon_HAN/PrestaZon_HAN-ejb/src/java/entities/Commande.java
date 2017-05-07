/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexis
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByIdClient", query = "SELECT c FROM Commande c WHERE c.commandePK.idClient = :idClient")
    , @NamedQuery(name = "Commande.findByReference", query = "SELECT c FROM Commande c WHERE c.commandePK.reference = :reference")
    , @NamedQuery(name = "Commande.findByDateCommande", query = "SELECT c FROM Commande c WHERE c.commandePK.dateCommande = :dateCommande")
    , @NamedQuery(name = "Commande.findByQuantite", query = "SELECT c FROM Commande c WHERE c.quantite = :quantite")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommandePK commandePK;
    @Column(name = "quantite")
    private Integer quantite;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "reference", referencedColumnName = "reference", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;

    public Commande() {
    }

    public Commande(CommandePK commandePK) {
        this.commandePK = commandePK;
    }

    public Commande(int idClient, int reference, Date dateCommande) {
        this.commandePK = new CommandePK(idClient, reference, dateCommande);
    }

    public CommandePK getCommandePK() {
        return commandePK;
    }

    public void setCommandePK(CommandePK commandePK) {
        this.commandePK = commandePK;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandePK != null ? commandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.commandePK == null && other.commandePK != null) || (this.commandePK != null && !this.commandePK.equals(other.commandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Commande[ commandePK=" + commandePK + " ]";
    }
    
}
