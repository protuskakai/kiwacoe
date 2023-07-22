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
@Table(name = "mpesa", catalog = "mpesa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Mpesa.findAll", query = "SELECT m FROM Mpesa m")
    , @NamedQuery(name = "Mpesa.findBySeq", query = "SELECT m FROM Mpesa m WHERE m.seq = :seq")
    , @NamedQuery(name = "Mpesa.findByDat", query = "SELECT m FROM Mpesa m WHERE m.dat = :dat")
    , @NamedQuery(name = "Mpesa.findByTcode", query = "SELECT m FROM Mpesa m WHERE m.tcode = :tcode")
    , @NamedQuery(name = "Mpesa.findByAmt", query = "SELECT m FROM Mpesa m WHERE m.amt = :amt")
    , @NamedQuery(name = "Mpesa.findByNam", query = "SELECT m FROM Mpesa m WHERE m.nam = :nam")
    , @NamedQuery(name = "Mpesa.findByAccno", query = "SELECT m FROM Mpesa m WHERE m.accno = :accno")
    , @NamedQuery(name = "Mpesa.findByTelno", query = "SELECT m FROM Mpesa m WHERE m.telno = :telno")
    , @NamedQuery(name = "Mpesa.findByInd", query = "SELECT m FROM Mpesa m WHERE m.ind = :ind")
    , @NamedQuery(name = "Mpesa.findByMdat", query = "SELECT m FROM Mpesa m WHERE m.mdat = :mdat")
    , @NamedQuery(name = "Mpesa.findByReg", query = "SELECT m FROM Mpesa m WHERE m.reg = :reg")
    , @NamedQuery(name = "Mpesa.findByCtime", query = "SELECT m FROM Mpesa m WHERE m.ctime = :ctime")})
public class Mpesa implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seq")
    private Double seq;
    @Basic(optional = false)
    @Column(name = "dat")
    private String dat;
    @Basic(optional = false)
    @Column(name = "tcode")
    private String tcode;
    @Basic(optional = false)
    @Column(name = "amt")
    private double amt;
    @Basic(optional = false)
    @Column(name = "nam")
    private String nam;
    @Basic(optional = false)
    @Column(name = "accno")
    private String accno;
    @Basic(optional = false)
    @Column(name = "telno")
    private String telno;
    @Column(name = "ind")
    private String ind;
    @Column(name = "mdat")
    @Temporal(TemporalType.DATE)
    private Date mdat;
    @Column(name = "reg")
    private String reg;
    @Column(name = "ctime")
    private Double ctime;

    public Mpesa() {
    }

    public Mpesa(Double seq) {
        this.seq = seq;
    }

    public Mpesa(Double seq, String dat, String tcode, double amt, String nam, String accno, String telno) {
        this.seq = seq;
        this.dat = dat;
        this.tcode = tcode;
        this.amt = amt;
        this.nam = nam;
        this.accno = accno;
        this.telno = telno;
    }

    public Double getSeq() {
        return seq;
    }

    public void setSeq(Double seq) {
        Double oldSeq = this.seq;
        this.seq = seq;
        changeSupport.firePropertyChange("seq", oldSeq, seq);
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        String oldDat = this.dat;
        this.dat = dat;
        changeSupport.firePropertyChange("dat", oldDat, dat);
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        String oldTcode = this.tcode;
        this.tcode = tcode;
        changeSupport.firePropertyChange("tcode", oldTcode, tcode);
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        double oldAmt = this.amt;
        this.amt = amt;
        changeSupport.firePropertyChange("amt", oldAmt, amt);
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        String oldNam = this.nam;
        this.nam = nam;
        changeSupport.firePropertyChange("nam", oldNam, nam);
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        String oldAccno = this.accno;
        this.accno = accno;
        changeSupport.firePropertyChange("accno", oldAccno, accno);
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        String oldTelno = this.telno;
        this.telno = telno;
        changeSupport.firePropertyChange("telno", oldTelno, telno);
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        String oldInd = this.ind;
        this.ind = ind;
        changeSupport.firePropertyChange("ind", oldInd, ind);
    }

    public Date getMdat() {
        return mdat;
    }

    public void setMdat(Date mdat) {
        Date oldMdat = this.mdat;
        this.mdat = mdat;
        changeSupport.firePropertyChange("mdat", oldMdat, mdat);
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        String oldReg = this.reg;
        this.reg = reg;
        changeSupport.firePropertyChange("reg", oldReg, reg);
    }

    public Double getCtime() {
        return ctime;
    }

    public void setCtime(Double ctime) {
        Double oldCtime = this.ctime;
        this.ctime = ctime;
        changeSupport.firePropertyChange("ctime", oldCtime, ctime);
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
        if (!(object instanceof Mpesa)) {
            return false;
        }
        Mpesa other = (Mpesa) object;
        if ((this.seq == null && other.seq != null) || (this.seq != null && !this.seq.equals(other.seq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "majiApp.Mpesa[ seq=" + seq + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
