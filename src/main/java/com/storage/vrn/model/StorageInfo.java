package com.storage.vrn.model;

public class StorageInfo {
    private Long ida;
    private String name;
    private Integer kab;
    private String login;
    private String pass;
    private Long ids;
    private Integer computer;
    private Integer monitor;
    private Integer printer;
    private Boolean mfp;
    private Integer ups;
    private Long idacc;

    public StorageInfo(Long ida, String name, Integer kab, String login, String pass, Long ids, Integer computer, Integer monitor, Integer printer, Boolean mfp, Integer ups, Long idacc) {
        super();
        this.ida = ida;
        this.name = name;
        this.kab = kab;
        this.login = login;
        this.pass = pass;
        this.ids = ids;
        this.computer = computer;
        this.monitor = monitor;
        this.printer = printer;
        this.mfp = mfp;
        this.ups = ups;
        this.idacc = idacc;
    }

    public Long getIda() {
        return ida;
    }
    public void setIda(Long id) {
        this.ida = ida;
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

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public Long getIds() {
        return ids;
    }
    public void setIds(Long ids) {
        this.ids = ids;
    }

    public Integer getComputer() {
        return computer;
    }
    public void setComputer(Integer computer) {
        this.computer = computer;
    }

    public Integer getMonitor() {
        return monitor;
    }
    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    public Integer getPrinter() {
        return printer;
    }
    public void setPrinter(Integer printer) {
        this.printer = printer;
    }

    public Boolean getMfp() {
        return mfp;
    }
    public void setMfp(Boolean mfp) {
        this.mfp = mfp;
    }

    public Integer getUps() {
        return ups;
    }
    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public Long getIdacc() {
        return idacc;
    }
    public void setIdacc(Long idacc) {
        this.idacc = idacc;
    }
}
