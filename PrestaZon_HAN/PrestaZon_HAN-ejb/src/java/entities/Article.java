/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexis
 */
@Entity
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
    , @NamedQuery(name = "Article.findByReference", query = "SELECT a FROM Article a WHERE a.reference = :reference")
    , @NamedQuery(name = "Article.findByType", query = "SELECT a FROM Article a WHERE a.type = :type")
    , @NamedQuery(name = "Article.findByPrixUnitaire", query = "SELECT a FROM Article a WHERE a.prixUnitaire = :prixUnitaire")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reference", nullable = false)
    private Integer reference;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type", nullable = false, length = 255)
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prixUnitaire", precision = 22)
    private Double prixUnitaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private List<Commandefournisseur> commandefournisseurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private List<Commande> commandeList;

    public Article() {
    }

    public Article(Integer reference) {
        this.reference = reference;
    }

    public Article(Integer reference, String type) {
        this.reference = reference;
        this.type = type;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    @XmlTransient
    public List<Commandefournisseur> getCommandefournisseurList() {
        return commandefournisseurList;
    }

    public void setCommandefournisseurList(List<Commandefournisseur> commandefournisseurList) {
        this.commandefournisseurList = commandefournisseurList;
    }

    @XmlTransient
    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reference != null ? reference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.reference == null && other.reference != null) || (this.reference != null && !this.reference.equals(other.reference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Article[ reference=" + reference + " ]";
    }
    
}
