/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author De
 */
@Entity
@Table(name = "appliedcompanytb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countAppliedcompanys",query="SELECT COUNT(a) FROM Appliedcompanytb a"),
    @NamedQuery(name = "Appliedcompanytb.findAll", query = "SELECT a FROM Appliedcompanytb a"),
    @NamedQuery(name = "Appliedcompanytb.findByAcid", query = "SELECT a FROM Appliedcompanytb a WHERE a.acid = :acid"),
    @NamedQuery(name = "Appliedcompanytb.findByApplicationDate", query = "SELECT a FROM Appliedcompanytb a WHERE a.applicationDate = :applicationDate"),
    @NamedQuery(name = "Appliedcompanytb.findAppliedcompanyByStudentId", query = "SELECT a FROM Appliedcompanytb a WHERE a.stid = :St_id"),
    @NamedQuery(name = "Appliedcompanytb.findAppliedcompanyByCompanyId", query = "SELECT a FROM Appliedcompanytb a WHERE a.cid = :C_id")})
public class Appliedcompanytb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Ac_id")
    private Integer acid;
    @Basic(optional = false)
    @Column(name = "ApplicationDate")
    @Temporal(TemporalType.DATE)
    private Date applicationDate;
    @JoinColumn(name = "C_id", referencedColumnName = "C_id")
    @ManyToOne(optional = false)
    private Companytb cid;
    @JoinColumn(name = "St_id", referencedColumnName = "St_id")
    @ManyToOne(optional = false)
    private Studenttb stid;

    public Appliedcompanytb() {
    }

    public Appliedcompanytb(Integer acid) {
        this.acid = acid;
    }

    public Appliedcompanytb(Integer acid, Date applicationDate) {
        this.acid = acid;
        this.applicationDate = applicationDate;
    }

    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Companytb getCid() {
        return cid;
    }

    public void setCid(Companytb cid) {
        this.cid = cid;
    }

    public Studenttb getStid() {
        return stid;
    }

    public void setStid(Studenttb stid) {
        this.stid = stid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acid != null ? acid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appliedcompanytb)) {
            return false;
        }
        Appliedcompanytb other = (Appliedcompanytb) object;
        if ((this.acid == null && other.acid != null) || (this.acid != null && !this.acid.equals(other.acid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Appliedcompanytb[ acid=" + acid + " ]";
    }
    
}
