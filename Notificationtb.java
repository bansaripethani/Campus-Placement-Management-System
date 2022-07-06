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
@Table(name = "notificationtb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countNotifications",query="SELECT COUNT(n) FROM Notificationtb n"),
    @NamedQuery(name = "Notificationtb.findAll", query = "SELECT n FROM Notificationtb n"),
    @NamedQuery(name = "Notificationtb.findByNid", query = "SELECT n FROM Notificationtb n WHERE n.nid = :nid"),
    @NamedQuery(name = "Notificationtb.findByTitle", query = "SELECT n FROM Notificationtb n WHERE n.title = :title"),
    @NamedQuery(name = "Notificationtb.findByDescription", query = "SELECT n FROM Notificationtb n WHERE n.description = :description"),
    @NamedQuery(name = "Notificationtb.findNotificationByStudentId", query = "SELECT n FROM Notificationtb n WHERE n.stid = :St_id"),
    @NamedQuery(name = "Notificationtb.findNotificationByComapanyId", query = "SELECT n FROM Notificationtb n WHERE n.cid = :C_id")})

public class Notificationtb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "N_id")
    private Integer nid;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "C_id", referencedColumnName = "C_id")
    @ManyToOne(optional = false)
    private Companytb cid;
    @JoinColumn(name = "St_id", referencedColumnName = "St_id")
    @ManyToOne(optional = false)
    private Studenttb stid;

    public Notificationtb() {
    }

    public Notificationtb(Integer nid) {
        this.nid = nid;
    }

    public Notificationtb(Integer nid, String title, String description) {
        this.nid = nid;
        this.title = title;
        this.description = description;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (nid != null ? nid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificationtb)) {
            return false;
        }
        Notificationtb other = (Notificationtb) object;
        if ((this.nid == null && other.nid != null) || (this.nid != null && !this.nid.equals(other.nid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Notificationtb[ nid=" + nid + " ]";
    }
    
}
