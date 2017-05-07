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
@Table(name = "commandefournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commandefournisseur.findAll", query = "SELECT c FROM Commandefournisseur c")
    , @NamedQuery(name = "Commandefournisseur.findByIdClient", query = "SELECT c FROM Commandefournisseur c WHERE c.commandefournisseurPK.idClient = :idClient")
    , @NamedQuery(name = "Commandefournisseur.findByReference", query = "SELECT c FROM Commandefournisseur c WHERE c.commandefournisseurPK.reference = :reference")
    , @NamedQuery(name = "Commandefournisseur.findByDateAppro", query = "SELECT c FROM Commandefournisseur c WHERE c.commandefournisseurPK.dateAppro = :dateAppro")
    , @NamedQuery(name = "Commandefournisseur.findByIdFournisseur", query = "SELECT c FROM Commandefournisseur c WHERE c.idFournisseur = :idFournisseur")
    , @NamedQuery(name = "Commandefournisseur.findByQuantiteCmd", query = "SELECT c FROM Commandefournisseur c WHERE c.quantiteCmd = :quantiteCmd")})
public class Commandefournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommandefournisseurPK commandefournisseurPK;
    @Column(name = "idFournisseur")
    private Integer idFournisseur;
    @Column(name = "quantiteCmd")
    private Integer quantiteCmd;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "reference", referencedColumnName = "reference", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;

    public Commandefournisseur() {
    }

    public Commandefournisseur(CommandefournisseurPK commandefournisseurPK) {
        this.commandefournisseurPK = commandefournisseurPK;
    }

    public Commandefournisseur(int idClient, int reference, Date dateAppro) {
        this.commandefournisseurPK = new CommandefournisseurPK(idClient, reference, dateAppro);
    }

    public CommandefournisseurPK getCommandefournisseurPK() {
        return commandefournisseurPK;
    }

    public void setCommandefournisseurPK(CommandefournisseurPK commandefournisseurPK) {
        this.commandefournisseurPK = commandefournisseurPK;
    }

    public Integer getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Integer idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public Integer getQuantiteCmd() {
        return quantiteCmd;
    }

    public void setQuantiteCmd(Integer quantiteCmd) {
        this.quantiteCmd = quantiteCmd;
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
        hash += (commandefournisseurPK != null ? commandefournisseurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commandefournisseur)) {
            return false;
        }
        Commandefournisseur other = (Commandefournisseur) object;
        if ((this.commandefournisseurPK == null && other.commandefournisseurPK != null) || (this.commandefournisseurPK != null && !this.commandefournisseurPK.equals(other.commandefournisseurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Commandefournisseur[ commandefournisseurPK=" + commandefournisseurPK + " ]";
    }
    
}
