package com.storage.vrn.setPass;

public class SetPassForm {

    private Long accountId;
    private String login;
    private  String pass;

    public SetPassForm() {

    }

    public SetPassForm(Long AccountId, String login, String pass) {
        this.accountId = AccountId;
        this.login = login;
        this.pass = pass;
    }

    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

}