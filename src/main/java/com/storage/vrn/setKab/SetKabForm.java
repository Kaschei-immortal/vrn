package com.storage.vrn.setKab;

public class SetKabForm {

    private Long accountId;
    private Integer kab;

    public SetKabForm() {

    }

    public SetKabForm(Long AccountId, Integer kab) {
        this.accountId = AccountId;
        this.kab = kab;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getKab() {
        return kab;
    }

    public void setKab(Integer kab) {
        this.kab = kab;
    }

}