package com.storage.vrn.getId;

public class GetIdForm {

    private Long accountId;

    public GetIdForm() {

    }

    public GetIdForm(Long AccountId) {
        this.accountId = AccountId;
    }

    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

}