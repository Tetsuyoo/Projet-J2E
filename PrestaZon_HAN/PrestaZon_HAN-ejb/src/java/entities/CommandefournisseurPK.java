/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alexis
 */
@Embeddable
public class CommandefournisseurPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idClient", nullable = false)
    private int idClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reference", nullable = false)
    private int reference;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateAppro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateAppro;

    public CommandefournisseurPK() {
    }

    public CommandefournisseurPK(int idClient, int reference, Date dateAppro) {
        this.idClient = idClient;
        this.reference = reference;
        this.dateAppro = dateAppro;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public Date getDateAppro() {
        return dateAppro;
    }

    public void setDateAppro(Date dateAppro) {
        this.dateAppro = dateAppro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idClient;
        hash += (int) reference;
        hash += (dateAppro != null ? dateAppro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandefournisseurPK)) {
            return false;
        }
        CommandefournisseurPK other = (CommandefournisseurPK) object;
        if (this.idClient != other.idClient) {
            return false;
        }
        if (this.reference != other.reference) {
            return false;
        }
        if ((this.dateAppro == null && other.dateAppro != null) || (this.dateAppro != null && !this.dateAppro.equals(other.dateAppro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CommandefournisseurPK[ idClient=" + idClient + ", reference=" + reference + ", dateAppro=" + dateAppro + " ]";
    }
    
}
