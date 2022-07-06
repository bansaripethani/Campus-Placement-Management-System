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
@Table(name = "answertb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="countAnswers",query="SELECT COUNT(a) FROM Answertb a"),
    @NamedQuery(name = "Answertb.findAll", query = "SELECT a FROM Answertb a"),
    @NamedQuery(name = "Answertb.findByAnid", query = "SELECT a FROM Answertb a WHERE a.anid = :anid"),
    @NamedQuery(name = "Answertb.findByAnsDesc", query = "SELECT a FROM Answertb a WHERE a.ansDesc = :ansDesc"),
    @NamedQuery(name = "Answertb.findAnserByQueryId", query = "SELECT a FROM Answertb a WHERE a.qid = :Q_id")})
public class Answertb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "An_id")
    private Integer anid;
    @Basic(optional = false)
    @Column(name = "AnsDesc")
    private String ansDesc;
    @JoinColumn(name = "Q_id", referencedColumnName = "Q_id")
    @ManyToOne(optional = false)
    private Querytb qid;

    public Answertb() {
    }

    public Answertb(Integer anid) {
        this.anid = anid;
    }

    public Answertb(Integer anid, String ansDesc) {
        this.anid = anid;
        this.ansDesc = ansDesc;
    }

    public Integer getAnid() {
        return anid;
    }

    public void setAnid(Integer anid) {
        this.anid = anid;
    }

    public String getAnsDesc() {
        return ansDesc;
    }

    public void setAnsDesc(String ansDesc) {
        this.ansDesc = ansDesc;
    }

    public Querytb getQid() {
        return qid;
    }

    public void setQid(Querytb qid) {
        this.qid = qid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anid != null ? anid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answertb)) {
            return false;
        }
        Answertb other = (Answertb) object;
        if ((this.anid == null && other.anid != null) || (this.anid != null && !this.anid.equals(other.anid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Answertb[ anid=" + anid + " ]";
    }
    
}
