package com.storage.vrn.model;

public class StorageAccountinfo {
    private Long id;
    private String name;
    private Integer kab;
    private String login;
    private String pass;

    public StorageAccountinfo(Long id, String name, Integer kab) {
        super();
        this.id = id;
        this.name = name;
        this.kab = kab;
    }
    public StorageAccountinfo(Long id, String name, Integer kab, String login, String pass) {
        super();
        this.id = id;
        this.name = name;
        this.kab = kab;
        this.login = login;
        this.pass = pass;
    }
    public StorageAccountinfo(Long id, String name, String login, String pass) {
        super();
        this.id = id;
        this.name = name;
        this.login = login;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public String getLogin() { return login; }
    public  void setLogin(String login) { this.login = login; }

    public String getPass() { return login; }
    public void setPass(String pass) { this.pass = pass; }
}
