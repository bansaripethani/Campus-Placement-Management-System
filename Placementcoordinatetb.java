/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author De
 */
@Entity
@Table(name = "placementcoordinatetb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countPlacementcoordinators",query="SELECT COUNT(p) FROM Placementcoordinatetb p"),
    @NamedQuery(name = "Placementcoordinatetb.findAll", query = "SELECT p FROM Placementcoordinatetb p"),
    @NamedQuery(name = "Placementcoordinatetb.findByPcid", query = "SELECT p FROM Placementcoordinatetb p WHERE p.pcid = :pcid"),
    @NamedQuery(name = "Placementcoordinatetb.findByName", query = "SELECT p FROM Placementcoordinatetb p WHERE p.name = :name"),
    @NamedQuery(name = "Placementcoordinatetb.findByEmail", query = "SELECT p FROM Placementcoordinatetb p WHERE p.email = :email"),
    @NamedQuery(name = "Placementcoordinatetb.findByPassword", query = "SELECT p FROM Placementcoordinatetb p WHERE p.password = :password"),
    @NamedQuery(name = "Placementcoordinatetb.findByPhoneno", query = "SELECT p FROM Placementcoordinatetb p WHERE p.phoneno = :phoneno"),
    @NamedQuery(name = "Placementcoordinatetb.findCoordinateByDepartmentId", query = "SELECT p FROM Placementcoordinatetb p WHERE p.deptid = :Dept_id")})
public class Placementcoordinatetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Pc_id")
    private Integer pcid;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "Phoneno")
    private int phoneno;
    @JoinColumn(name = "Dept_id", referencedColumnName = "Dept_id")
    @ManyToOne(optional = false)
    private Departmenttb deptid;

    public Placementcoordinatetb() {
    }

    public Placementcoordinatetb(Integer pcid) {
        this.pcid = pcid;
    }

    public Placementcoordinatetb(Integer pcid, String name, String email, String password, int phoneno) {
        this.pcid = pcid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
    }

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public Departmenttb getDeptid() {
        return deptid;
    }

    public void setDeptid(Departmenttb deptid) {
        this.deptid = deptid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcid != null ? pcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placementcoordinatetb)) {
            return false;
        }
        Placementcoordinatetb other = (Placementcoordinatetb) object;
        if ((this.pcid == null && other.pcid != null) || (this.pcid != null && !this.pcid.equals(other.pcid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Placementcoordinatetb[ pcid=" + pcid + " ]";
    }
    
}
