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
@Table(name = "placementtb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countPlacements",query="SELECT COUNT(p) FROM Placementtb p"),
    @NamedQuery(name = "Placementtb.findAll", query = "SELECT p FROM Placementtb p"),
    @NamedQuery(name = "Placementtb.findByPid", query = "SELECT p FROM Placementtb p WHERE p.pid = :pid"),
    @NamedQuery(name = "Placementtb.findByPlacementDate", query = "SELECT p FROM Placementtb p WHERE p.placementDate = :placementDate"),
    @NamedQuery(name = "Placementtb.findPlacementByStudentId", query = "SELECT p FROM Placementtb p WHERE p.stid = :St_id"),
    @NamedQuery(name = "Placementtb.findPlacementByCompanyId", query = "SELECT p FROM Placementtb p WHERE p.cid = :C_id")})
public class Placementtb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "P_id")
    private Integer pid;
    @Basic(optional = false)
    @Column(name = "PlacementDate")
    @Temporal(TemporalType.DATE)
    private Date placementDate;
    @JoinColumn(name = "C_id", referencedColumnName = "C_id")
    @ManyToOne(optional = false)
    private Companytb cid;
    @JoinColumn(name = "St_id", referencedColumnName = "St_id")
    @ManyToOne(optional = false)
    private Studenttb stid;

    public Placementtb() {
    }

    public Placementtb(Integer pid) {
        this.pid = pid;
    }

    public Placementtb(Integer pid, Date placementDate) {
        this.pid = pid;
        this.placementDate = placementDate;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
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
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placementtb)) {
            return false;
        }
        Placementtb other = (Placementtb) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Placementtb[ pid=" + pid + " ]";
    }
    
}
