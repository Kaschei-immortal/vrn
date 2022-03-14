package com.storage.vrn.setInventoryNumber;

public class SetInventoryForm {

    private Long stationId;
    private Integer computer;
    private Integer monitor;
    private Integer printer;
    private Boolean mfp;
    private Integer ups;

    public SetInventoryForm() {

    }

    public SetInventoryForm(Long stationId, Integer computer, Integer monitor, Integer printer, Boolean mfp, Integer ups) {
        this.stationId = stationId;
        this.computer = computer;
        this.monitor = monitor;
        this.printer = printer;
        this.mfp =mfp;
        this.ups = ups;
    }

    public Long getStationId() {
        return stationId;
    }
    public void setStationId(Long stationId) {
        this.stationId = stationId;
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
}