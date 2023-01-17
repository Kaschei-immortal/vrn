package com.storage.vrn.setAcc;

public class SetAccountForm {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String kab;
    private String login;
    private String pass;

    public SetAccountForm() {

    }

    public SetAccountForm(Long id, String name, String surname, String patronymic, String kab, String login, String pass) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.kab = kab;
        this.login = login;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getKab() {
        return kab;
    }
    public void setKab(String kab) {
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
