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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author De
 */
@Entity
@Table(name = "studenttb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countStudents",query="SELECT COUNT(s) FROM Studenttb s"),
    @NamedQuery(name = "Studenttb.findAll", query = "SELECT s FROM Studenttb s"),
    @NamedQuery(name = "Studenttb.findByStid", query = "SELECT s FROM Studenttb s WHERE s.stid = :stid"),
    @NamedQuery(name = "Studenttb.findByFirstname", query = "SELECT s FROM Studenttb s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Studenttb.findByLastname", query = "SELECT s FROM Studenttb s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Studenttb.findByEmail", query = "SELECT s FROM Studenttb s WHERE s.email = :email"),
    @NamedQuery(name = "Studenttb.findByPhoneNo", query = "SELECT s FROM Studenttb s WHERE s.phoneNo = :phoneNo"),
    @NamedQuery(name = "Studenttb.findByPassword", query = "SELECT s FROM Studenttb s WHERE s.password = :password"),
    @NamedQuery(name = "Studenttb.findByDob", query = "SELECT s FROM Studenttb s WHERE s.dob = :dob"),
    @NamedQuery(name = "Studenttb.findByAddress", query = "SELECT s FROM Studenttb s WHERE s.address = :address"),
    @NamedQuery(name = "Studenttb.findByPercentage10th", query = "SELECT s FROM Studenttb s WHERE s.percentage10th = :percentage10th"),
    @NamedQuery(name = "Studenttb.findByPercentage12th", query = "SELECT s FROM Studenttb s WHERE s.percentage12th = :percentage12th"),
    @NamedQuery(name = "Studenttb.findBySemAggregate", query = "SELECT s FROM Studenttb s WHERE s.semAggregate = :semAggregate"),
    @NamedQuery(name = "Studenttb.findByProfilepic", query = "SELECT s FROM Studenttb s WHERE s.profilepic = :profilepic"),
    @NamedQuery(name = "Studenttb.findByStudentnames", query = "SELECT s FROM Studenttb s WHERE s.firstname IN :firstnames"),
    @NamedQuery(name = "Studenttb.findStudentByDeptId", query = "SELECT s FROM Studenttb s WHERE s.deptid = :Dept_id"),
    @NamedQuery(name = "Studenttb.findStudentBySId", query = "SELECT s FROM Studenttb s WHERE s.sid = :S_id")})
public class Studenttb implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stid")
    private Collection<Academictb> academictbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stid")
    private Collection<Notificationtb> notificationtbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stid")
    private Collection<Appliedcompanytb> appliedcompanytbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stid")
    private Collection<Certificatetb> certificatetbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stid")
    private Collection<Querytb> querytbCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "St_id")
    private Integer stid;
    @Basic(optional = false)
    @Column(name = "Firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "Lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "PhoneNo")
    private int phoneNo;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
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
    @Column(name = "Profilepic")
    private String profilepic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stid")
    private Collection<Placementtb> placementtbCollection;
    @JoinColumn(name = "S_id", referencedColumnName = "S_id")
    @ManyToOne(optional = false)
    private Statustb sid;
    @JoinColumn(name = "Dept_id", referencedColumnName = "Dept_id")
    @ManyToOne(optional = false)
    private Departmenttb deptid;

    public Studenttb() {
    }

    public Studenttb(Integer stid) {
        this.stid = stid;
    }

    public Studenttb(Integer stid, String firstname, String lastname, String email, int phoneNo, String password, Date dob, String address, String percentage10th, String percentage12th, String semAggregate, String profilepic) {
        this.stid = stid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.dob = dob;
        this.address = address;
        this.percentage10th = percentage10th;
        this.percentage12th = percentage12th;
        this.semAggregate = semAggregate;
        this.profilepic = profilepic;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Placementtb> getPlacementtbCollection() {
        return placementtbCollection;
    }

    public void setPlacementtbCollection(Collection<Placementtb> placementtbCollection) {
        this.placementtbCollection = placementtbCollection;
    }

    public Statustb getSid() {
        return sid;
    }

    public void setSid(Statustb sid) {
        this.sid = sid;
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
        hash += (stid != null ? stid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studenttb)) {
            return false;
        }
        Studenttb other = (Studenttb) object;
        if ((this.stid == null && other.stid != null) || (this.stid != null && !this.stid.equals(other.stid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Studenttb[ stid=" + stid + " ]";
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
    public Collection<Certificatetb> getCertificatetbCollection() {
        return certificatetbCollection;
    }

    public void setCertificatetbCollection(Collection<Certificatetb> certificatetbCollection) {
        this.certificatetbCollection = certificatetbCollection;
    }

  

    @XmlTransient
    @JsonbTransient
    public Collection<Querytb> getQuerytbCollection() {
        return querytbCollection;
    }

    public void setQuerytbCollection(Collection<Querytb> querytbCollection) {
        this.querytbCollection = querytbCollection;
    }
    
}
