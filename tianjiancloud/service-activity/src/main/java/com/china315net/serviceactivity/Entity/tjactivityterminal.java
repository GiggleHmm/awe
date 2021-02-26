package com.china315net.serviceactivity.Entity;

public class tjactivityterminal {
    private Integer id;

    private Integer acid;

    private Integer terminalid;

    private String terminalnm;

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

    public Integer getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(Integer terminalid) {
        this.terminalid = terminalid;
    }

    public String getTerminalnm() {
        return terminalnm;
    }

    public void setTerminalnm(String terminalnm) {
        this.terminalnm = terminalnm == null ? null : terminalnm.trim();
    }
}