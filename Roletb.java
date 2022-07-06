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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author De
 */
@Entity
@Table(name = "roletb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roletb.findAll", query = "SELECT r FROM Roletb r"),
    @NamedQuery(name = "Roletb.findByRid", query = "SELECT r FROM Roletb r WHERE r.rid = :rid"),
    @NamedQuery(name = "Roletb.findByName", query = "SELECT r FROM Roletb r WHERE r.name = :name"),
    @NamedQuery(name = "Roletb.findByUserid", query = "SELECT r FROM Roletb r WHERE r.userid = :userid")})
public class Roletb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "R_id")
    private Integer rid;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "User_id")
    private int userid;

    public Roletb() {
    }

    public Roletb(Integer rid) {
        this.rid = rid;
    }

    public Roletb(Integer rid, String name, int userid) {
        this.rid = rid;
        this.name = name;
        this.userid = userid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roletb)) {
            return false;
        }
        Roletb other = (Roletb) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Roletb[ rid=" + rid + " ]";
    }
    
}
