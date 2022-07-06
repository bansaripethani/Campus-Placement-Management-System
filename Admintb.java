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
@Table(name = "admintb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countAdmins",query="SELECT COUNT(a) FROM Admintb a"),
    @NamedQuery(name = "Admintb.findAll", query = "SELECT a FROM Admintb a"),
    @NamedQuery(name = "Admintb.findByAdminid", query = "SELECT a FROM Admintb a WHERE a.adminid = :adminid"),
    @NamedQuery(name = "Admintb.findByAdminName", query = "SELECT a FROM Admintb a WHERE a.adminName = :adminName"),
    @NamedQuery(name = "Admintb.findByEmail", query = "SELECT a FROM Admintb a WHERE a.email = :email"),
    @NamedQuery(name = "Admintb.findByPassword", query = "SELECT a FROM Admintb a WHERE a.password = :password"),
    @NamedQuery(name = "Admintb.findByPhoneNo", query = "SELECT a FROM Admintb a WHERE a.phoneNo = :phoneNo")})
public class Admintb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Admin_id")
    private Integer adminid;
    @Basic(optional = false)
    @Column(name = "AdminName")
    private String adminName;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "PhoneNo")
    private int phoneNo;

    public Admintb() {
    }

    public Admintb(Integer adminid) {
        this.adminid = adminid;
    }

    public Admintb(String adminName, String email, String password, int phoneNo) {
        //this.adminid = adminid;
        this.adminName = adminName;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminid != null ? adminid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admintb)) {
            return false;
        }
        Admintb other = (Admintb) object;
        if ((this.adminid == null && other.adminid != null) || (this.adminid != null && !this.adminid.equals(other.adminid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Admintb[ adminid=" + adminid + " ]";
    }
    
}
