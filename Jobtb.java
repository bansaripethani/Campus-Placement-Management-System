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
@Table(name = "jobtb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countJobs",query="SELECT COUNT(j) FROM Jobtb j"),
    @NamedQuery(name = "Jobtb.findAll", query = "SELECT j FROM Jobtb j"),
    @NamedQuery(name = "Jobtb.findByJid", query = "SELECT j FROM Jobtb j WHERE j.jid = :jid"),
    @NamedQuery(name = "Jobtb.findByTitle", query = "SELECT j FROM Jobtb j WHERE j.title = :title")})
public class Jobtb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "J_id")
    private Integer jid;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jid")
    private Collection<Companytb> companytbCollection;

    public Jobtb() {
    }

    public Jobtb(Integer jid) {
        this.jid = jid;
    }

    public Jobtb(Integer jid, String title) {
        this.jid = jid;
        this.title = title;
    }

    public Jobtb(String Title) {
        this.title = Title;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        hash += (jid != null ? jid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobtb)) {
            return false;
        }
        Jobtb other = (Jobtb) object;
        if ((this.jid == null && other.jid != null) || (this.jid != null && !this.jid.equals(other.jid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Jobtb[ jid=" + jid + " ]";
    }
    
}
