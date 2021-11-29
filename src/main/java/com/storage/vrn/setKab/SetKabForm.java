package com.storage.vrn.setKab;

public class SetKabForm {

    private Long AccountId;
    private Integer kab;

    public SetKabForm() {

    }

    public SetKabForm(Long AccountId, Integer kab) {
        this.AccountId = AccountId;
        this.kab = kab;
    }

    public Long getAccountId() {
        return AccountId;
    }

    public void setAccountId(Long AccountId) {
        this.AccountId = AccountId;
    }

    public Integer getKab() {
        return kab;
    }

    public void setKab(Integer kab) {
        this.kab = kab;
    }

}