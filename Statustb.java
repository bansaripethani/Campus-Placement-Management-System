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
@Table(name = "statustb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statustb.findAll", query = "SELECT s FROM Statustb s"),
    @NamedQuery(name = "Statustb.findBySid", query = "SELECT s FROM Statustb s WHERE s.sid = :sid"),
    @NamedQuery(name = "Statustb.findByType", query = "SELECT s FROM Statustb s WHERE s.type = :type")})
public class Statustb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "S_id")
    private Integer sid;
    @Basic(optional = false)
    @Column(name = "Type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sid")
    private Collection<Companytb> companytbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sid")
    private Collection<Academictb> academictbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sid")
    private Collection<Studenttb> studenttbCollection;

    public Statustb() {
    }

    public Statustb(Integer sid) {
        this.sid = sid;
    }

    public Statustb(Integer sid, String type) {
        this.sid = sid;
        this.type = type;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    @XmlTransient
    @JsonbTransient
    public Collection<Academictb> getAcademictbCollection() {
        return academictbCollection;
    }

    public void setAcademictbCollection(Collection<Academictb> academictbCollection) {
        this.academictbCollection = academictbCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Studenttb> getStudenttbCollection() {
        return studenttbCollection;
    }

    public void setStudenttbCollection(Collection<Studenttb> studenttbCollection) {
        this.studenttbCollection = studenttbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sid != null ? sid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statustb)) {
            return false;
        }
        Statustb other = (Statustb) object;
        if ((this.sid == null && other.sid != null) || (this.sid != null && !this.sid.equals(other.sid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Statustb[ sid=" + sid + " ]";
    }
    
}
