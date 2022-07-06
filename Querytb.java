/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author De
 */
@Entity
@Table(name = "querytb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countQuerys",query="SELECT COUNT(q) FROM Querytb q"),
    @NamedQuery(name = "Querytb.findAll", query = "SELECT q FROM Querytb q"),
    @NamedQuery(name = "Querytb.findByQid", query = "SELECT q FROM Querytb q WHERE q.qid = :qid"),
    @NamedQuery(name = "Querytb.findByQuestion", query = "SELECT q FROM Querytb q WHERE q.question = :question"),
    @NamedQuery(name = "Querytb.findQueryByStudentId", query = "SELECT q FROM Querytb q WHERE q.stid = :St_id")})
public class Querytb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Q_id")
    private Integer qid;
    @Basic(optional = false)
    @Column(name = "Question")
    private String question;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qid")
    private Collection<Answertb> answertbCollection;
    @JoinColumn(name = "St_id", referencedColumnName = "St_id")
    @ManyToOne(optional = false)
    private Studenttb stid;

    public Querytb() {
    }

    public Querytb(Integer qid) {
        this.qid = qid;
    }

    public Querytb(Integer qid, String question) {
        this.qid = qid;
        this.question = question;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<Answertb> getAnswertbCollection() {
        return answertbCollection;
    }

    public void setAnswertbCollection(Collection<Answertb> answertbCollection) {
        this.answertbCollection = answertbCollection;
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
        hash += (qid != null ? qid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Querytb)) {
            return false;
        }
        Querytb other = (Querytb) object;
        if ((this.qid == null && other.qid != null) || (this.qid != null && !this.qid.equals(other.qid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Querytb[ qid=" + qid + " ]";
    }
    
}
