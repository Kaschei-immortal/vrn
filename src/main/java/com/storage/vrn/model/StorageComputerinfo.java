package com.storage.vrn.model;

public class StorageComputerinfo {
    private Long id;
    private Integer computer;
    private Integer monitor;
    private Integer printer;
    private Boolean mfp;
    private Integer ups;
    private Long idacc;

    public StorageComputerinfo(Long id, Integer computer, Long idacc) {
        super();
        this.id = id;
        this.computer = computer;
        this.idacc = idacc;
    }
    public StorageComputerinfo(Long id, Integer computer, Integer monitor, Integer printer, Boolean mfp, Integer ups, Long idacc) {
        super();
        this.id = id;
        this.computer = computer;
        this.monitor = monitor;
        this.printer = printer;
        this.mfp = mfp;
        this.ups = ups;
        this.idacc = idacc;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
