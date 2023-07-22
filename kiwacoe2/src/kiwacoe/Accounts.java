/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwacoe;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "accounts", catalog = "maji", schema = "")
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
    , @NamedQuery(name = "Accounts.findBySeq", query = "SELECT a FROM Accounts a WHERE a.seq = :seq")
    , @NamedQuery(name = "Accounts.findByAccno", query = "SELECT a FROM Accounts a WHERE a.accno = :accno")
    , @NamedQuery(name = "Accounts.findByTyp", query = "SELECT a FROM Accounts a WHERE a.typ = :typ")
    , @NamedQuery(name = "Accounts.findByGrp", query = "SELECT a FROM Accounts a WHERE a.grp = :grp")
    , @NamedQuery(name = "Accounts.findBySdate", query = "SELECT a FROM Accounts a WHERE a.sdate = :sdate")
    , @NamedQuery(name = "Accounts.findByStime", query = "SELECT a FROM Accounts a WHERE a.stime = :stime")
    , @NamedQuery(name = "Accounts.findByNam", query = "SELECT a FROM Accounts a WHERE a.nam = :nam")})
public class Accounts implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seq")
    private Integer seq;
    @Basic(optional = false)
    @Column(name = "accno")
    private String accno;
    @Basic(optional = false)
    @Column(name = "typ")
    private String typ;
    @Basic(optional = false)
    @Column(name = "grp")
    private String grp;
    @Basic(optional = false)
    @Column(name = "sdate")
    @Temporal(TemporalType.DATE)
    private Date sdate;
    @Basic(optional = false)
    @Column(name = "stime")
    @Temporal(TemporalType.TIME)
    private Date stime;
    @Basic(optional = false)
    @Column(name = "nam")
    private String nam;

    public Accounts() {
    }

    public Accounts(Integer seq) {
        this.seq = seq;
    }

    public Accounts(Integer seq, String accno, String typ, String grp, Date sdate, Date stime, String nam) {
        this.seq = seq;
        this.accno = accno;
        this.typ = typ;
        this.grp = grp;
        this.sdate = sdate;
        this.stime = stime;
        this.nam = nam;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        Integer oldSeq = this.seq;
        this.seq = seq;
        changeSupport.firePropertyChange("seq", oldSeq, seq);
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        String oldAccno = this.accno;
        this.accno = accno;
        changeSupport.firePropertyChange("accno", oldAccno, accno);
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        String oldTyp = this.typ;
        this.typ = typ;
        changeSupport.firePropertyChange("typ", oldTyp, typ);
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        String oldGrp = this.grp;
        this.grp = grp;
        changeSupport.firePropertyChange("grp", oldGrp, grp);
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        Date oldSdate = this.sdate;
        this.sdate = sdate;
        changeSupport.firePropertyChange("sdate", oldSdate, sdate);
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        Date oldStime = this.stime;
        this.stime = stime;
        changeSupport.firePropertyChange("stime", oldStime, stime);
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        String oldNam = this.nam;
        this.nam = nam;
        changeSupport.firePropertyChange("nam", oldNam, nam);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seq != null ? seq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.seq == null && other.seq != null) || (this.seq != null && !this.seq.equals(other.seq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "majiApp.Accounts[ seq=" + seq + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
