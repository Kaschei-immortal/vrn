package com.storage.vrn.Entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "storage_account", schema = "public", catalog = "storage")
public class StorageAccountEntity {
    private long id;
    private String name;
    private Integer kab;
    private String login;
    private String password;
    private List<StorageWorkStationEntity> storageWorkStationEntities;

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
    @Column(name = "kab")
    public Integer getKab() {
        return kab;
    }

    public void setKab(Integer kab) {
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

    @OneToMany(mappedBy = "storageAccountEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    public List<StorageWorkStationEntity> getStorageWorkStationEntities() {
        return storageWorkStationEntities;
    }

    public void setStorageWorkStationEntities(List<StorageWorkStationEntity> storageWorkStationEntities) {
        this.storageWorkStationEntities = storageWorkStationEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageAccountEntity that = (StorageAccountEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(kab, that.kab) && Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, kab, login, password);
    }
}
