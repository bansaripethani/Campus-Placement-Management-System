/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author De
 */
@Entity
@Table(name = "placementtypetb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Placementtypetb.findAll", query = "SELECT p FROM Placementtypetb p"),
    @NamedQuery(name = "Placementtypetb.findByPtid", query = "SELECT p FROM Placementtypetb p WHERE p.ptid = :ptid"),
    @NamedQuery(name = "Placementtypetb.findByType", query = "SELECT p FROM Placementtypetb p WHERE p.type = :type")})
public class Placementtypetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Pt_id")
    private Integer ptid;
    @Basic(optional = false)
    @Column(name = "Type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ptid")
    private Collection<Companytb> companytbCollection;

    public Placementtypetb() {
    }

    public Placementtypetb(Integer ptid) {
        this.ptid = ptid;
    }

    public Placementtypetb(Integer ptid, String type) {
        this.ptid = ptid;
        this.type = type;
    }

    public Placementtypetb(String type) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.type = type;
    }

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Companytb> getCompanytbCollection() {
        return companytbCollection;
    }

    public void setCompanytbCollection(Collection<Companytb> companytbCollection) {
        this.companytbCollection = companytbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ptid != null ? ptid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placementtypetb)) {
            return false;
        }
        Placementtypetb other = (Placementtypetb) object;
        if ((this.ptid == null && other.ptid != null) || (this.ptid != null && !this.ptid.equals(other.ptid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Placementtypetb[ ptid=" + ptid + " ]";
    }
    
}
