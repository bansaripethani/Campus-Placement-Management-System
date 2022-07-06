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
@Table(name = "departmenttb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countDepartments",query="SELECT COUNT(d) FROM Departmenttb d"),
    @NamedQuery(name = "Departmenttb.findAll", query = "SELECT d FROM Departmenttb d"),
    @NamedQuery(name = "Departmenttb.findByDeptid", query = "SELECT d FROM Departmenttb d WHERE d.deptid = :deptid"),
    @NamedQuery(name = "Departmenttb.findByDeptName", query = "SELECT d FROM Departmenttb d WHERE d.deptName = :deptName")})
public class Departmenttb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Dept_id")
    private Integer deptid;
    @Basic(optional = false)
    @Column(name = "DeptName")
    private String deptName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptid")
    private Collection<Companytb> companytbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptid")
    private Collection<Studenttb> studenttbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptid")
    private Collection<Placementcoordinatetb> placementcoordinatetbCollection;

    public Departmenttb() {
    }

    public Departmenttb(Integer deptid) {
        this.deptid = deptid;
    }

    public Departmenttb(String deptName) {
       
        this.deptName = deptName;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
    public Collection<Studenttb> getStudenttbCollection() {
        return studenttbCollection;
    }

    public void setStudenttbCollection(Collection<Studenttb> studenttbCollection) {
        this.studenttbCollection = studenttbCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Placementcoordinatetb> getPlacementcoordinatetbCollection() {
        return placementcoordinatetbCollection;
    }

    public void setPlacementcoordinatetbCollection(Collection<Placementcoordinatetb> placementcoordinatetbCollection) {
        this.placementcoordinatetbCollection = placementcoordinatetbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptid != null ? deptid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departmenttb)) {
            return false;
        }
        Departmenttb other = (Departmenttb) object;
        if ((this.deptid == null && other.deptid != null) || (this.deptid != null && !this.deptid.equals(other.deptid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Departmenttb[ deptid=" + deptid + " ]";
    }
    
}
