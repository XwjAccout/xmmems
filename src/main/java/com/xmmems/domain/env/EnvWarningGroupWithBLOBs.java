package com.xmmems.domain.env;

public class EnvWarningGroupWithBLOBs extends EnvWarningGroup {
    private String relateSite;

    private String relatePerson;

    public String getRelateSite() {
        return relateSite;
    }

    public void setRelateSite(String relateSite) {
        this.relateSite = relateSite == null ? null : relateSite.trim();
    }

    public String getRelatePerson() {
        return relatePerson;
    }

    public void setRelatePerson(String relatePerson) {
        this.relatePerson = relatePerson == null ? null : relatePerson.trim();
    }
}