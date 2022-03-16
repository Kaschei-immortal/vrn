package com.storage.vrn.setKab;

public class AddKabForm {

    private String name;
    private Integer kab;
    private String login;
    private  String pass;

    public AddKabForm() {

    }

    public AddKabForm(String name, Integer kab, String login, String pass) {
        this.name = name;
        this.kab = kab;
        this.login = login;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getKab() {
        return kab;
    }
    public void setKab(Integer kab) {
        this.kab = kab;
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