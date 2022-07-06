/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author De
 */
@Entity
@Table(name = "companytb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countCompanys",query="SELECT COUNT(c) FROM Companytb c"),
    @NamedQuery(name = "Companytb.findAll", query = "SELECT c FROM Companytb c"),
    @NamedQuery(name = "Companytb.findByCid", query = "SELECT c FROM Companytb c WHERE c.cid = :cid"),
    @NamedQuery(name = "Companytb.findByCName", query = "SELECT c FROM Companytb c WHERE c.cName = :cName"),
    @NamedQuery(name = "Companytb.findByLocation", query = "SELECT c FROM Companytb c WHERE c.location = :location"),
    @NamedQuery(name = "Companytb.findByPackage1", query = "SELECT c FROM Companytb c WHERE c.package1 = :package1"),
    @NamedQuery(name = "Companytb.findByNoOfVacancy", query = "SELECT c FROM Companytb c WHERE c.noOfVacancy = :noOfVacancy"),
    @NamedQuery(name = "Companytb.findByPercentage10th", query = "SELECT c FROM Companytb c WHERE c.percentage10th = :percentage10th"),
    @NamedQuery(name = "Companytb.findByPercentage12th", query = "SELECT c FROM Companytb c WHERE c.percentage12th = :percentage12th"),
    @NamedQuery(name = "Companytb.findBySemAggregate", query = "SELECT c FROM Companytb c WHERE c.semAggregate = :semAggregate"),
    @NamedQuery(name = "Companytb.findByPassingDate", query = "SELECT c FROM Companytb c WHERE c.passingDate = :passingDate"),
    @NamedQuery(name = "Companytb.findCompanyByJob", query = "SELECT c FROM Companytb c WHERE c.jid = :J_id"),
    @NamedQuery(name = "Companytb.findCompanyByStatus", query = "SELECT c FROM Companytb c WHERE c.sid = :S_id")})
public class Companytb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "C_id")
    private Integer cid;
    @Basic(optional = false)
    @Column(name = "C_Name")
    private String cName;
    @Basic(optional = false)
    @Column(name = "Location")
    private String location;
    @Basic(optional = false)
    @Column(name = "Package")
    private int package1;
    @Basic(optional = false)
    @Column(name = "NoOfVacancy")
    private int noOfVacancy;
    @Basic(optional = false)
    @Column(name = "Percentage10th")
    private String percentage10th;
    @Basic(optional = false)
    @Column(name = "Percentage12th")
    private String percentage12th;
    @Basic(optional = false)
    @Column(name = "SemAggregate")
    private String semAggregate;
    @Basic(optional = false)
    @Column(name = "PassingDate")
    @Temporal(TemporalType.DATE)
    private Date passingDate;
    @JoinColumn(name = "J_id", referencedColumnName = "J_id")
    @ManyToOne(optional = false)
    private Jobtb jid;
    @JoinColumn(name = "Pt_id", referencedColumnName = "Pt_id")
    @ManyToOne(optional = false)
    private Placementtypetb ptid;
    @JoinColumn(name = "Dept_id", referencedColumnName = "Dept_id")
    @ManyToOne(optional = false)
    private Departmenttb deptid;
    @JoinColumn(name = "S_id", referencedColumnName = "S_id")
    @ManyToOne(optional = false)
    private Statustb sid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cid")
    private Collection<Notificationtb> notificationtbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cid")
    private Collection<Appliedcompanytb> appliedcompanytbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cid")
    private Collection<Placementtb> placementtbCollection;

    public Companytb() {
    }

    public Companytb(Integer cid) {
        this.cid = cid;
    }

    public Companytb(Integer cid, String cName, String location, int package1, int noOfVacancy, String percentage10th, String percentage12th, String semAggregate, Date passingDate) {
        this.cid = cid;
        this.cName = cName;
        this.location = location;
        this.package1 = package1;
        this.noOfVacancy = noOfVacancy;
        this.percentage10th = percentage10th;
        this.percentage12th = percentage12th;
        this.semAggregate = semAggregate;
        this.passingDate = passingDate;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPackage1() {
        return package1;
    }

    public void setPackage1(int package1) {
        this.package1 = package1;
    }

    public int getNoOfVacancy() {
        return noOfVacancy;
    }

    public void setNoOfVacancy(int noOfVacancy) {
        this.noOfVacancy = noOfVacancy;
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

    public Date getPassingDate() {
        return passingDate;
    }

    public void setPassingDate(Date passingDate) {
        this.passingDate = passingDate;
    }

    public Jobtb getJid() {
        return jid;
    }

    public void setJid(Jobtb jid) {
        this.jid = jid;
    }

    public Placementtypetb getPtid() {
        return ptid;
    }

    public void setPtid(Placementtypetb ptid) {
        this.ptid = ptid;
    }

    public Departmenttb getDeptid() {
        return deptid;
    }

    public void setDeptid(Departmenttb deptid) {
        this.deptid = deptid;
    }

    public Statustb getSid() {
        return sid;
    }

    public void setSid(Statustb sid) {
        this.sid = sid;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Notificationtb> getNotificationtbCollection() {
        return notificationtbCollection;
    }

    public void setNotificationtbCollection(Collection<Notificationtb> notificationtbCollection) {
        this.notificationtbCollection = notificationtbCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Appliedcompanytb> getAppliedcompanytbCollection() {
        return appliedcompanytbCollection;
    }

    public void setAppliedcompanytbCollection(Collection<Appliedcompanytb> appliedcompanytbCollection) {
        this.appliedcompanytbCollection = appliedcompanytbCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Placementtb> getPlacementtbCollection() {
        return placementtbCollection;
    }

    public void setPlacementtbCollection(Collection<Placementtb> placementtbCollection) {
        this.placementtbCollection = placementtbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companytb)) {
            return false;
        }
        Companytb other = (Companytb) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Companytb[ cid=" + cid + " ]";
    }
    
}
