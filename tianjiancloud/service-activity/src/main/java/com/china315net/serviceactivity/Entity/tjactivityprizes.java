package com.china315net.serviceactivity.Entity;

public class tjactivityprizes {
    private Integer id;

    private Integer acid;

    private Integer awtype;

    private Integer awid;

    private Double prizevalue;

    private Integer percentvl;

    private Integer createuserid;

    private String acname;

    private String awtypenm;

    private String awnm;

    private String creatusernm;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }

    public Integer getAwtype() {
        return awtype;
    }

    public void setAwtype(Integer awtype) {
        this.awtype = awtype;
    }

    public Integer getAwid() {
        return awid;
    }

    public void setAwid(Integer awid) {
        this.awid = awid;
    }

    public Double getPrizevalue() {
        return prizevalue;
    }

    public void setPrizevalue(Double prizevalue) {
        this.prizevalue = prizevalue;
    }

    public Integer getPercentvl() {
        return percentvl;
    }

    public void setPercentvl(Integer percentvl) {
        this.percentvl = percentvl;
    }

    public Integer getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    public String getAcname() {
        return acname;
    }

    public void setAcname(String acname) {
        this.acname = acname == null ? null : acname.trim();
    }

    public String getAwtypenm() {
        return awtypenm;
    }

    public void setAwtypenm(String awtypenm) {
        this.awtypenm = awtypenm == null ? null : awtypenm.trim();
    }

    public String getAwnm() {
        return awnm;
    }

    public void setAwnm(String awnm) {
        this.awnm = awnm == null ? null : awnm.trim();
    }

    public String getCreatusernm() {
        return creatusernm;
    }

    public void setCreatusernm(String creatusernm) {
        this.creatusernm = creatusernm == null ? null : creatusernm.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}