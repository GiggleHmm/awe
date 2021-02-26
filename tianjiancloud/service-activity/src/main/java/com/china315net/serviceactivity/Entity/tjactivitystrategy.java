package com.china315net.serviceactivity.Entity;

import java.util.Date;

public class tjactivitystrategy {
    private Integer id;

    private Integer compid;

    private Date createdate;

    private Integer createuserid;

    private Byte isactive;

    private String strategyname;

    private Integer totalwinrate;

    private Integer timelimit;

    private Integer maxtimeself;

    private Integer packagenum;

    private String remarks;

    private Integer pid;

    private Byte md;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompid() {
        return compid;
    }

    public void setCompid(Integer compid) {
        this.compid = compid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    public Byte getIsactive() {
        return isactive;
    }

    public void setIsactive(Byte isactive) {
        this.isactive = isactive;
    }

    public String getStrategyname() {
        return strategyname;
    }

    public void setStrategyname(String strategyname) {
        this.strategyname = strategyname == null ? null : strategyname.trim();
    }

    public Integer getTotalwinrate() {
        return totalwinrate;
    }

    public void setTotalwinrate(Integer totalwinrate) {
        this.totalwinrate = totalwinrate;
    }

    public Integer getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Integer timelimit) {
        this.timelimit = timelimit;
    }

    public Integer getMaxtimeself() {
        return maxtimeself;
    }

    public void setMaxtimeself(Integer maxtimeself) {
        this.maxtimeself = maxtimeself;
    }

    public Integer getPackagenum() {
        return packagenum;
    }

    public void setPackagenum(Integer packagenum) {
        this.packagenum = packagenum;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getMd() {
        return md;
    }

    public void setMd(Byte md) {
        this.md = md;
    }
}