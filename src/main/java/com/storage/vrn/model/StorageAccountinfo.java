package com.storage.vrn.model;

public class StorageAccountinfo {
    private Long id;
    private String name;
    private Integer kab;
    private String dolzhn;
    private String naprav;

    public StorageAccountinfo(Long id, String name, Integer kab) {
        super();
        this.id = id;
        this.name = name;
        this.kab = kab;
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
}
