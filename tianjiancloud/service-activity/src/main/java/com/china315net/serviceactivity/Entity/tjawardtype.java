package com.china315net.serviceactivity.Entity;

public class tjawardtype {
    private Integer id;

    private Integer parentid;

    private String awardtype;

    private String remarks;

    private Integer compid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getAwardtype() {
        return awardtype;
    }

    public void setAwardtype(String awardtype) {
        this.awardtype = awardtype == null ? null : awardtype.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getCompid() {
        return compid;
    }

    public void setCompid(Integer compid) {
        this.compid = compid;
    }
}