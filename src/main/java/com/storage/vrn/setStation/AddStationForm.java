package com.storage.vrn.setStation;

public class AddStationForm {

    private Integer computer;
    private Integer monitor;
    private Integer printer;
    private Boolean mfp;
    private Integer ups;
    private Long idAccount;

    public AddStationForm() {

    }

    public AddStationForm(Integer computer, Integer monitor, Integer printer, Boolean mfp, Integer ups) {
        this.computer = computer;
        this.monitor = monitor;
        this.printer = printer;
        this.mfp =mfp;
        this.ups = ups;
    }

    public AddStationForm(Integer computer, Integer monitor, Integer printer, Boolean mfp, Integer ups, Long idAccount) {
        this.computer = computer;
        this.monitor = monitor;
        this.printer = printer;
        this.mfp =mfp;
        this.ups = ups;
        this.idAccount = idAccount;
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

    public Long getIdAccount() {
        return idAccount;
    }
    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

}