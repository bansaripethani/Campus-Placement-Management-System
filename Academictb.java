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
@Table(name = "academictb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Academictb.findAll", query = "SELECT a FROM Academictb a"),
    @NamedQuery(name = "Academictb.findByAid", query = "SELECT a FROM Academictb a WHERE a.aid = :aid"),
    @NamedQuery(name = "Academictb.findByPercentage10th", query = "SELECT a FROM Academictb a WHERE a.percentage10th = :percentage10th"),
    @NamedQuery(name = "Academictb.findByPercentage12th", query = "SELECT a FROM Academictb a WHERE a.percentage12th = :percentage12th"),
    @NamedQuery(name = "Academictb.findBySemAggregate", query = "SELECT a FROM Academictb a WHERE a.semAggregate = :semAggregate")})
public class Academictb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "A_id")
    private Integer aid;
    @Basic(optional = false)
    @Column(name = "Percentage10th")
    private String percentage10th;
    @Basic(optional = false)
    @Column(name = "Percentage12th")
    private String percentage12th;
    @Basic(optional = false)
    @Column(name = "SemAggregate")
    private String semAggregate;
    @JoinColumn(name = "St_id", referencedColumnName = "St_id")
    @ManyToOne(optional = false)
    private Studenttb stid;
    @JoinColumn(name = "S_id", referencedColumnName = "S_id")
    @ManyToOne(optional = false)
    private Statustb sid;

    public Academictb() {
    }

    public Academictb(Integer aid) {
        this.aid = aid;
    }

    public Academictb(Integer aid, String percentage10th, String percentage12th, String semAggregate) {
        this.aid = aid;
        this.percentage10th = percentage10th;
        this.percentage12th = percentage12th;
        this.semAggregate = semAggregate;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getPercentage10th() {
        return percentage10th;
    }

    public void setPercentage10th(String percentage10th) {
        this.percentage10th = percentage10th;
    }

    public String getPercentage12th() {
        return percentage12th;
    }

    public void setPercentage12th(String percentage12th) {
        this.percentage12th = percentage12th;
    }

    public String getSemAggregate() {
        return semAggregate;
    }

    public void setSemAggregate(String semAggregate) {
        this.semAggregate = semAggregate;
    }

    public Studenttb getStid() {
        return stid;
    }

    public void setStid(Studenttb stid) {
        this.stid = stid;
    }

    public Statustb getSid() {
        return sid;
    }

    public void setSid(Statustb sid) {
        this.sid = sid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Academictb)) {
            return false;
        }
        Academictb other = (Academictb) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Academictb[ aid=" + aid + " ]";
    }
    
}
