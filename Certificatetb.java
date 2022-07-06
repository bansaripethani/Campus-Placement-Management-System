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
@Table(name = "certificatetb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificatetb.findAll", query = "SELECT c FROM Certificatetb c"),
    @NamedQuery(name = "Certificatetb.findByCrid", query = "SELECT c FROM Certificatetb c WHERE c.crid = :crid"),
    @NamedQuery(name = "Certificatetb.findByTitle", query = "SELECT c FROM Certificatetb c WHERE c.title = :title"),
    @NamedQuery(name = "Certificatetb.findByImage", query = "SELECT c FROM Certificatetb c WHERE c.image = :image"),
    @NamedQuery(name = "Certificatetb.findCertificateByStudentId", query = "SELECT c FROM Certificatetb c WHERE c.stid = :St_id")})
public class Certificatetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cr_id")
    private Integer crid;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "Image")
    private String image;
    @JoinColumn(name = "St_id", referencedColumnName = "St_id")
    @ManyToOne(optional = false)
    private Studenttb stid;

    public Certificatetb() {
    }

    public Certificatetb(Integer crid) {
        this.crid = crid;
    }

    public Certificatetb(Integer crid, String title, String image) {
        this.crid = crid;
        this.title = title;
        this.image = image;
    }

    public Integer getCrid() {
        return crid;
    }

    public void setCrid(Integer crid) {
        this.crid = crid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        hash += (crid != null ? crid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificatetb)) {
            return false;
        }
        Certificatetb other = (Certificatetb) object;
        if ((this.crid == null && other.crid != null) || (this.crid != null && !this.crid.equals(other.crid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Certificatetb[ crid=" + crid + " ]";
    }
    
}
