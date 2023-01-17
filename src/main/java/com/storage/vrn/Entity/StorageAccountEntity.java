package com.storage.vrn.Entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "storage_account", schema = "public", catalog = "storage")
public class StorageAccountEntity {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String kab;
    private String login;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "patronymic")
    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    @Basic
    @Column(name = "kab")
    public String getKab() {
        return kab;
    }
    public void setKab(String kab) {
        this.kab = kab;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageAccountEntity that = (StorageAccountEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(kab, that.kab) && Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, kab, login, password);
    }
}
