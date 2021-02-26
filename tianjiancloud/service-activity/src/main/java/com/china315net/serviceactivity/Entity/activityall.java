package com.china315net.serviceactivity.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;

public class activityall {
    private Integer id;

    private String aname;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Timestamp stm;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Timestamp etm;

    private String obcodetype;

    private Integer asid;

    private Integer compid;

    private Integer createid;

    private Timestamp createdate;

    private String remarks;

    private Byte yzm;

    private Integer faceto;

    private Integer feedbacktoparent;

    private Integer feedvalue;

    private String khddh;

    private Integer anyfahuodate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date sfahuodate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date efahuodate;

    private Integer priority;

    private String tp;

    private Byte isopen;

    private String asname;

    private Integer prizenm;

    private Integer prodnm;

    private Integer agentnm;

    public Integer getTerminum() {
        return terminum;
    }

    public void setTerminum(Integer terminum) {
        this.terminum = terminum;
    }

    private Integer terminum;

    public Integer getPrizenm() {
        return prizenm;
    }

    public void setPrizenm(Integer prizenm) {
        this.prizenm = prizenm;
    }

    public Integer getProdnm() {
        return prodnm;
    }

    public void setProdnm(Integer prodnm) {
        this.prodnm = prodnm;
    }

    public Integer getAgentnm() {
        return agentnm;
    }

    public void setAgentnm(Integer agentnm) {
        this.agentnm = agentnm;
    }

    public String getAsname() {
        return asname;
    }

    public void setAsname(String asname) {
        this.asname = asname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public Date getStm() {
        return stm;
    }

    public void setStm(Timestamp stm) {
        this.stm = stm;
    }

    public Date getEtm() {
        return etm;
    }

    public void setEtm(Timestamp etm) {
        this.etm = etm;
    }

    public String getObcodetype() {
        return obcodetype;
    }

    public void setObcodetype(String obcodetype) {
        this.obcodetype = obcodetype == null ? null : obcodetype.trim();
    }

    public Integer getAsid() {
        return asid;
    }

    public void setAsid(Integer asid) {
        this.asid = asid;
    }

    public Integer getCompid() {
        return compid;
    }

    public void setCompid(Integer compid) {
        this.compid = compid;
    }

    public Integer getCreateid() {
        return createid;
    }

    public void setCreateid(Integer createid) {
        this.createid = createid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Byte getYzm() {
        return yzm;
    }

    public void setYzm(Byte yzm) {
        this.yzm = yzm;
    }

    public Integer getFaceto() {
        return faceto;
    }

    public void setFaceto(Integer faceto) {
        this.faceto = faceto;
    }

    public Integer getFeedbacktoparent() {
        return feedbacktoparent;
    }

    public void setFeedbacktoparent(Integer feedbacktoparent) {
        this.feedbacktoparent = feedbacktoparent;
    }

    public Integer getFeedvalue() {
        return feedvalue;
    }

    public void setFeedvalue(Integer feedvalue) {
        this.feedvalue = feedvalue;
    }

    public String getKhddh() {
        return khddh;
    }

    public void setKhddh(String khddh) {
        this.khddh = khddh == null ? null : khddh.trim();
    }

    public Integer getAnyfahuodate() {
        return anyfahuodate;
    }

    public void setAnyfahuodate(Integer anyfahuodate) {
        this.anyfahuodate = anyfahuodate;
    }

    public Date getSfahuodate() {
        return sfahuodate;
    }

    public void setSfahuodate(Date sfahuodate) {
        this.sfahuodate = sfahuodate;
    }

    public Date getEfahuodate() {
        return efahuodate;
    }

    public void setEfahuodate(Date efahuodate) {
        this.efahuodate = efahuodate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp == null ? null : tp.trim();
    }

    public Byte getIsopen() {
        return isopen;
    }

    public void setIsopen(Byte isopen) {
        this.isopen = isopen;
    }
}