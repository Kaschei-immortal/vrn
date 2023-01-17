package com.storage.vrn.setStation;

public class SetStationForm {

    private Long id;
    private String computer;
    private String monitor;
    private String printer;
    private String ups;

    public SetStationForm(Long id, String computer, String monitor, String printer, String ups) {
        this.id = id;
        this.computer = computer;
        this.monitor = monitor;
        this.printer = printer;
        this.ups = ups;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getComputer() {
        return computer;
    }
    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getMonitor() {
        return monitor;
    }
    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getPrinter() {
        return printer;
    }
    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public String getUps() {
        return ups;
    }
    public void setUps(String ups) {
        this.ups = ups;
    }
}