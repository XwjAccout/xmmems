package com.xmmems.domain;

public class OperationPerson {
    private Integer id;

    private Integer unitID;

    private String account;

    private String name;

    private String role;

    private String cardID;

    private String telephoneNumer;

    private String sex;

    private Integer isvalid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnitID() {
        return unitID;
    }

    public void setUnitID(Integer unitID) {
        this.unitID = unitID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID == null ? null : cardID.trim();
    }

    public String getTelephoneNumer() {
        return telephoneNumer;
    }

    public void setTelephoneNumer(String telephoneNumer) {
        this.telephoneNumer = telephoneNumer == null ? null : telephoneNumer.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }
}